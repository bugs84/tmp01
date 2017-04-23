package cz.vondr.workshop.design.tree.cmdline

import cz.vondr.workshop.design.tree.SystemOutputTest
import spock.lang.Specification

class CmdLineRunnerIntegrationTestSystem extends Specification implements SystemOutputTest {

    def "Basic commandline integration test"() {

        def input = """\
1 2 3 4 5 6 7
breadth
+-
"""

        given:
        def inputStream = new ByteArrayInputStream(input.getBytes())

        when:
        new CmdLineRunner(inputStream).start()

        then:
        ["Enter complete binary tree:",
         "Enter tree traversal:",
         "Enter action:",
         "=4"
        ] == getSystemOutputLines()

    }
}
