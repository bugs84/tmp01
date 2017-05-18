package cz.vondr.workshop.design.life.command

class CommandProcessor {
    final String commandString

    Command command

    CommandProcessor(String commandString) {
        this.commandString = commandString
    }


    void process() {
        createCommand()
        command?.execute()
    }

    /** factory method */
    private void createCommand() {
        def commands = [
                new InterestCommand(commandString),
                new OccuredCommand(commandString)
        ]
        command = commands.find { it.isValid() }

        printMessageIfNoCommandFound()

    }

    private void printMessageIfNoCommandFound() {
        if (command == null) {
            println "Unknown command"
        }
    }
}

abstract class Command {
    final String commandString

    Command(String commandString) {
        this.commandString = commandString
    }

    abstract boolean isValid()
    abstract void execute()
}

class InterestCommand extends Command {



    InterestCommand(String commandString) {
        super(commandString)
    }

    @Override
    boolean isValid() {
        commandString.contains("->")
    }

    @Override
    void execute() {
//        parseCommand()
        println "Alice is interested in wedding"
    }
}

class OccuredCommand extends Command {

    OccuredCommand(String commandString) {
        super(commandString)
    }

    @Override
    boolean isValid() {
        commandString.contains(":")
    }

    @Override
    void execute() {

    }
}
