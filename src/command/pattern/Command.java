package command.pattern;

public interface Command {
    void execute();
    void undo();
}
