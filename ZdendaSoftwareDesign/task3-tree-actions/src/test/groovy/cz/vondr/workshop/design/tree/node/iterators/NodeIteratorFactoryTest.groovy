package cz.vondr.workshop.design.tree.node.iterators

import cz.vondr.workshop.design.tree.node.BinaryNode
import spock.lang.Specification

import static cz.vondr.workshop.design.tree.node.NodeValue.val

class NodeIteratorFactoryTest extends Specification {
    def "create depth ignore case"() {
        when:
        def action = new NodeIteratorFactory().createFromString("DepTH", new BinaryNode(val(0)))

        then:
        action instanceof DepthNodeIterator
    }
}
