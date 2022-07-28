package main.design_pattern.structural.proxy;

import java.io.IOException;

public interface CommandExecutor {
    void runCommand(String command) throws Exception;
}
