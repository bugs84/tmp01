package cz.vondr.workshop.design.tree.node.iterators

import cz.vondr.workshop.design.tree.TreeBuilder
import cz.vondr.workshop.design.tree.node.Node
import spock.lang.Specification

import static cz.vondr.workshop.design.tree.node.NodeValue.val

class BreadthNodeIteratorTest extends Specification {
    def "basic iterator test"() {
        given:
        Node tree = new TreeBuilder().buildTreeFromString("1 2 3 4 5 6")

        when:
        Iterator<Node> iterator = new BreadthNodeIterator(tree)

        then:
        (1..6).each {
            assert iterator.hasNext(), "Test failed - next element was expteted. At number '$it'"
            assert val(it) == iterator.next().value
        }
        !iterator.hasNext()
    }
}
