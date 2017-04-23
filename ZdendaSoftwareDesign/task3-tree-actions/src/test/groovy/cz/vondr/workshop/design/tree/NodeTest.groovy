package cz.vondr.workshop.design.tree

import cz.vondr.workshop.design.tree.node.BinaryNode
import cz.vondr.workshop.design.tree.node.Node
import spock.lang.Specification

import static cz.vondr.workshop.design.tree.node.NodeValue.val

class NodeTest extends Specification {

    def "BinaryNode default constructor create empty children"() {
        when:
        def node = new BinaryNode(val(5))

        then:
        node.value == val(5)
        !node.left.isPresent()
        !node.right.isPresent()

    }

    def "Node return all children works for BinaryNode"() {
        given:
        Node node = new BinaryNode(val(0), new BinaryNode(val(8)), new BinaryNode(val(9)))

        when:
        List<Node> children = node.children

        then:
        children.size() == 2
        children[0].value == val(8)
        children[1].value == val(9)
    }

    def "Node with one childen returns only one child"() {
        given:
        Node node = new BinaryNode(val(0), new BinaryNode(val(8)))

        when:
        List<Node> children = node.children

        then:
        children.size() == 1
        children[0].value == val(8)
    }


}
