package cz.vondr.workshop.design.life.cmd

import cz.vondr.workshop.design.life.SystemOutputTest
import spock.lang.Specification

class CmdLineRunnerIntegrationTest extends Specification implements SystemOutputTest{

    def "Basic commandline integration test"() {

            def input = """\
F:Alice,M:Bob,M:Charlie,F:Daisy
Alice->wedding
Alice->birthday
Bob->birthday
Charlie->wedding
Daisy->birthday
Alice:wedding
Charlie:birthday
Bob->wedding
Daisy:wedding
xyz
done
"""

            given:
            def inputStream = new ByteArrayInputStream(input.getBytes())

            when:
            new CmdLineRunner(inputStream).start()

            then:
            [
                    "Enter persons:",
                    "Enter commands:",
                    "Alice is interested in wedding",
                    "Alice is interested in birthday",
                    "Bob is interested in birthday",
                    "Charlie is interested in wedding",
                    "Daisy is interested in birthday",
                    "Charlie says: poor Alice, the freedom is gone",
                    "Alice says: all the best Charlie, wish you a wonderful life",
                    "Bob says: oops Charlie has a birthday, one more step to the grave",
                    "Daisy says: all the best Charlie, wish you a wonderful life",
                    "Bob is interested in wedding",
                    "Alice says: yaaay, Daisy is so lucky to be married now",
                    "Charlie says: poor Daisy, the freedom is gone",
                    "Bob says: poor Daisy, the freedom is gone",
                    "Unknown command",
            ] == getSystemOutputLines()

        }

}
