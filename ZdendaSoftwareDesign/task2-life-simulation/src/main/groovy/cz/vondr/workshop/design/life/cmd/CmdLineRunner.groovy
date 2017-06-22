package cz.vondr.workshop.design.life.cmd

import cz.vondr.workshop.design.life.command.CommandProcessor
import cz.vondr.workshop.design.life.parser.PersonsParser

class CmdLineRunner {

    private BufferedReader input

    CmdLineRunner(InputStream input = System.in) {
        this.input = input.newReader()
    }

    void start() {
        askForPersons()
        askForCommands()
    }

    void askForPersons() {
        println "Enter persons:"
        String personsInput = input.readLine()
        new PersonsParser().parse(personsInput)
    }

    void askForCommands() {
        println "Enter commands:"
        String commandString
        while (!"done".equalsIgnoreCase(commandString = input.readLine())) {
            new CommandProcessor(commandString).process()
        }
    }

    static void main(String[] args) {
        CmdLineRunner app = new CmdLineRunner()
        app.start()
    }
}
