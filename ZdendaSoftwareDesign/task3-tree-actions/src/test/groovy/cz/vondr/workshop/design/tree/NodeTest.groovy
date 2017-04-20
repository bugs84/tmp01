package cz.vondr.workshop.design.tree

import spock.lang.Specification

class NodeTest extends Specification {

    def "BinaryNode default constructor create empty children"() {
        when:
        def node = new BinaryNode(5)

        then:
        node.value == 5
        !node.left.isPresent()
        !node.right.isPresent()

    }

    def "Node iterator works for BinaryNode"() {
        given:
        Node node = new BinaryNode(0, new BinaryNode(8), new BinaryNode(9))

        when:
        def iterator = node.iterator()

        then:
        iterator.hasNext()
        iterator.next().value == 8
        iterator.hasNext()
        iterator.next().value == 9
        !iterator.hasNext()

    }


}
