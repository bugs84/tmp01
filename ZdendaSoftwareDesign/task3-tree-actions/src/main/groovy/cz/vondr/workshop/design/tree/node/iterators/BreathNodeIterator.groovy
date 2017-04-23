package cz.vondr.workshop.design.tree.node.iterators

import cz.vondr.workshop.design.tree.node.Node

class BreathNodeIterator implements Iterator<Node> {
    Queue<Node> nodeQueue = [] as Queue

    BreathNodeIterator(Node node) {
        nodeQueue.add(node)
    }

    @Override
    boolean hasNext() {
        !nodeQueue.isEmpty()
    }

    @Override
    Node next() {
        def node = nodeQueue.poll()
        nodeQueue.addAll node.children
        node
    }
}
