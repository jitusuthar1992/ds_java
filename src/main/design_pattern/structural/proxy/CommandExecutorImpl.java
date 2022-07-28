package main.design_pattern.structural.proxy;

public class CommandExecutorImpl implements CommandExecutor {
    @Override
    public void runCommand(String command) throws Exception {
        Runtime.getRuntime().exec(command);
        System.out.printf("Command " + command + " executed successfully");
    }
}
