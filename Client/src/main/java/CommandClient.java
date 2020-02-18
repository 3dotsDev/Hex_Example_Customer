import adapter.console.Command;
import adapter.console.CommandConsoleModule;
import adapter.console.CommandConsoleUtils;
import adapter.console.ICommand;
import com.google.inject.Guice;
import com.google.inject.Injector;

import java.util.Scanner;

public class CommandClient {
    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new CommandConsoleModule());
        ICommand commandConsole = injector.getInstance(ICommand.class);
        CommandClient.start(commandConsole);

    }

    public static void start(ICommand commandConsole) {

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            String cmd = CommandConsoleUtils.readString(scanner);
            if ("LS".equalsIgnoreCase(cmd)) {
                commandConsole.list(scanner);
            } else if ("REG".equalsIgnoreCase(cmd)) {
                commandConsole.register(scanner);
            } else if ("UG".equals(cmd)) {
                commandConsole.upgrade(scanner);
            } else if ("DG".equals(cmd)) {
                commandConsole.downgrade(scanner);
            } else if ("INFO".equals(cmd)) {
                commandConsole.info();
            } else if ("EXIT".equalsIgnoreCase(cmd)) {
                exit = true;
            } else {
                commandConsole.info();
            }
        }

    }
}
