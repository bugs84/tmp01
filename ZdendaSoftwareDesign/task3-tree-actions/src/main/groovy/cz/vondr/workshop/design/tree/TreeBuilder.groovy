package cz.vondr.workshop.design.tree

import cz.vondr.workshop.design.tree.node.BinaryNode
import cz.vondr.workshop.design.tree.node.Node

import static cz.vondr.workshop.design.tree.node.NodeValue.val

class TreeBuilder {

    Node buildTreeFromString(String string) {
        List<Integer> values = parseString(string)
        BinaryNode rootNode = prepareRootNode(values)

        def queue = [] as Queue<Node>
        queue << rootNode
        values.each { value ->
            def newNode = new BinaryNode(val(value))
            queue << newNode
            Node notFullNode = obtainNotFullNode(queue)
            notFullNode.addChild(newNode)
        }
        rootNode
    }

    private BinaryNode prepareRootNode(List<Integer> values) {
        def firstValue = values.removeAt(0)
        def rootNode = new BinaryNode(val(firstValue))
        rootNode
    }

    private List<Integer> parseString(String string) {
        List<Integer> values = string.split(" ").collect { it.toInteger() }
        values
    }

    private Node obtainNotFullNode(Queue<Node> queue) {
        def node = queue.peek()
        while (node.isFull()) {
            queue.poll()
            node = queue.peek()
        }
        node
    }

}
