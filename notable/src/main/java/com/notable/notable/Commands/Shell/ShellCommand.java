package com.notable.notable.Commands.Shell;

import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Supplier;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.stereotype.Component;

import com.notable.notable.Commands.NoteCommands.AddNoteCommand;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import picocli.CommandLine.Command;
import picocli.CommandLine.HelpCommand;
import picocli.shell.jline3.PicocliCommands;
import picocli.shell.jline3.PicocliCommands.PicocliCommandsFactory;
import picocli.CommandLine;

import org.fusesource.jansi.AnsiConsole;
import org.jline.console.SystemRegistry;
import org.jline.console.impl.Builtins;
import org.jline.console.impl.SystemRegistryImpl;
import org.jline.keymap.KeyMap;
import org.jline.reader.*;
import org.jline.reader.impl.DefaultParser;
import org.jline.reader.impl.LineReaderImpl;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.widget.TailTipWidgets;

@Command(name = "", description = {
        "Take notes via the command line." +
                "Type @|magenta <TAB>|@ to see available commands.",
        "Type @|magenta ALT-S|@ to toggle tailtips.",
        "" }, footer = { "", "Press Ctl-D to exit." }, subcommands = {
                AddNoteCommand.class,
                HelpCommand.class,
        })
@Component
@RequiredArgsConstructor
@Getter
public class ShellCommand implements Runnable, ExitCodeGenerator {
    private LineReaderImpl reader;
    private PrintWriter out;

    private int exitCode;

    final void setReader(LineReader reader) {
        out = reader.getTerminal().writer();
    }

    @Override
    public int getExitCode() {
        return exitCode;
    }

    @Override
    public void run() {
        ShellCommand shell = new ShellCommand();
        AnsiConsole.systemInstall();
        try {
            Supplier<Path> workDir = () -> Paths.get(System.getProperty("user.dir"));
            Builtins builtins = new Builtins(workDir, null, null);
            builtins.rename(Builtins.Command.TTOP, "top");
            builtins.alias("zle", "widget");
            builtins.alias("bindkey", "keymap");

            PicocliCommandsFactory factory = new PicocliCommandsFactory();
            CommandLine command = new CommandLine(shell, factory);
            PicocliCommands picoCommands = new PicocliCommands(command);
            Parser parser = new DefaultParser();
            try (Terminal terminal = TerminalBuilder.builder().build()) {
                SystemRegistry systemRegistry = new SystemRegistryImpl(parser, terminal, workDir, null);
                systemRegistry.setCommandRegistries(builtins, picoCommands);
                systemRegistry.register("help", picoCommands);

                LineReader reader = LineReaderBuilder.builder()
                        .appName("notable")
                        .terminal(terminal)
                        .completer(systemRegistry.completer())
                        .parser(parser)
                        .variable(LineReader.LIST_MAX, 50)
                        .build();

                builtins.setLineReader(reader);
                shell.setReader(reader);
                factory.setTerminal(terminal);
                TailTipWidgets widgets = new TailTipWidgets(reader, systemRegistry::commandDescription, 5,
                        TailTipWidgets.TipType.COMPLETER);
                widgets.enable();
                KeyMap<Binding> keyMap = reader.getKeyMaps().get("main");
                keyMap.bind(new Reference("tailtip-toggle"), KeyMap.alt("s"));

                String prompt = "notable> ";
                String rightPrompt = null;

                String line;
                while (true) {
                    try {
                        systemRegistry.cleanUp();
                        line = reader.readLine(prompt, rightPrompt, (MaskingCallback) null, null);
                        systemRegistry.execute(line);
                    } catch (UserInterruptException e) {
                        // ignore
                    } catch (EndOfFileException e) {
                        return;
                    } catch (Exception e) {
                        systemRegistry.trace(e);
                    }
                }
            }

        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            AnsiConsole.systemUninstall();
        }
    }

}
