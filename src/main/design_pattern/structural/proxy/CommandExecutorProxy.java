package main.design_pattern.structural.proxy;

public class CommandExecutorProxy implements CommandExecutor {

    private CommandExecutor commandExecutor;
    private boolean isAdmin;

    public CommandExecutorProxy(String user, String pwd) {
        if ("Pankaj".equals(user) && "J@urnalD$v".equals(pwd)) isAdmin = true;
        commandExecutor = new CommandExecutorImpl();
    }

    @Override
    public void runCommand(String cmd) throws Exception {
        if (isAdmin) {
            commandExecutor.runCommand(cmd);
        } else {
            if (cmd.trim().startsWith("rm")) {
                throw new Exception("rm command is not allowed for non-admin users.");
            } else {
                commandExecutor.runCommand(cmd);
            }
        }
    }
}
