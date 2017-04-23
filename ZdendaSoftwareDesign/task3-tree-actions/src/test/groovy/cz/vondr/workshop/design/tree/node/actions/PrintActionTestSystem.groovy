package cz.vondr.workshop.design.tree.node.actions

import cz.vondr.workshop.design.tree.SystemOutputTest
import cz.vondr.workshop.design.tree.TreeBuilder
import cz.vondr.workshop.design.tree.node.Node
import cz.vondr.workshop.design.tree.node.iterators.BreadthNodeIterator
import spock.lang.Specification

class PrintActionTestSystem extends Specification implements SystemOutputTest {
    def "print operator basic test"() {
        given:
        Node tree = new TreeBuilder().buildTreeFromString("1 2 3 4 5 6")
        when:
        new PrintAction(new BreadthNodeIterator(tree)).perform()
        then:
        ["1 2 3 4 5 6"] == getSystemOutputLines()
    }
}
