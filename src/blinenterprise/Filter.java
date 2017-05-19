package blinenterprise;


public class Filter {
    
    public Commands command;
    private String value;

    public Filter() {
    }

    public enum Commands {
        BLACK, RED, BLUE, GREEN, WHITE, COLORLESS, MATCHCOLORSEXACTLY, SELECTTYPE;
    }
    
    public boolean compareCommand(Filter filter) {
        return filter.command == this.command;
    }

    public boolean compareCommand(Commands command) {
        return command == this.command;
    }
    
    public String getValue() {
        return value;
    }

    public Commands getCommand() {
        return command;
    }
    
    public void setCommand(Commands command) {
        this.command = command;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
