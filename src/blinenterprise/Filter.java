package blinenterprise;


public class Filter {
    
    public Commands command;
    private String value;
    private String subCommand;

    public Filter() {
    }
    public Filter(Commands command, String value, String subCommand) {
        this.command = command;
        this.value = value;
        this.subCommand = subCommand;
    }

    public enum Commands {
        BLACK, RED, BLUE, GREEN, WHITE, COLORLESS, MATCHCOLORSEXACTLY,
        SELECTTYPE, EXCLUDEUNSELECTEDCOLORS, CONVERTEDMANACOST;
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

    public String getSubcommand() {
        return subCommand;
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

    public void setSubCommand(String subCommand) {
        this.subCommand = subCommand;
    }
}
