package cz.vondr.workshop.design.tree.node.actions

import cz.vondr.workshop.design.tree.SystemOutputTest
import cz.vondr.workshop.design.tree.TreeBuilder
import cz.vondr.workshop.design.tree.node.Node
import cz.vondr.workshop.design.tree.node.iterators.BreadthNodeIterator
import spock.lang.Specification

class PlusMinusActionTestSystem extends Specification implements SystemOutputTest {
    def "basic test"() {
        given:
        Node tree = new TreeBuilder().buildTreeFromString("1 2 3 4 5 6 7")

        when:
        new PlusMinusAction(new BreadthNodeIterator(tree)).perform()

        then:
        ["=4"] == getSystemOutputLines()
    }
}
