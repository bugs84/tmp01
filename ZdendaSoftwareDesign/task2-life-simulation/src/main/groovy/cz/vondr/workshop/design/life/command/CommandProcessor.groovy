package cz.vondr.workshop.design.life.command

import cz.vondr.workshop.design.life.Context
import cz.vondr.workshop.design.life.events.EventType

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
                new OccurredCommand(commandString)
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

//  Alice->wedding
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
        def (personName, eventName) = commandString.tokenize( '->' )
        println "$personName is interested in $eventName"

        def eventType= EventType.fromString(eventName)
        def event = Context.instance.getEventByType(eventType)
        def person = Context.instance.getPerson(personName)

        event.addInterestedPerson person
    }
}

class OccurredCommand extends Command {

    OccurredCommand(String commandString) {
        super(commandString)
    }

    @Override
    boolean isValid() {
        commandString.contains(":")
    }

    @Override
    void execute() {
        def (personName, eventName) = commandString.tokenize( ':' )
        def eventType= EventType.fromString(eventName)
        def event = Context.instance.getEventByType(eventType)
        def person = Context.instance.getPerson(personName)

        event.eventOccurred(person)
    }

}
