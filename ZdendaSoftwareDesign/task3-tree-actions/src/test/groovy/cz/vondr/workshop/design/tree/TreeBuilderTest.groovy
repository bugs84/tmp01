package cz.vondr.workshop.design.tree

import cz.vondr.workshop.design.tree.node.BinaryNode
import cz.vondr.workshop.design.tree.node.Node
import spock.lang.Specification

import static cz.vondr.workshop.design.tree.node.NodeValue.val
import static java.util.Optional.of

class TreeBuilderTest extends Specification {
    def "createTreeFromString"() {
        def (n1, n2, n3, n4) =  (1..4).collect { new BinaryNode(val(it)) }
        n1
        n1.left = of(n2); n1.right = of(n3)
        n2.left = of(n4)
        Node expectedNode = n1

        given:
        def builder = new TreeBuilder()

        when:
        def createdNode = builder.buildTreeFromString("1 2 3 4")

        then:
        createdNode == expectedNode
    }
}
