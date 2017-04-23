package cz.vondr.workshop.design.tree.node.iterators

import cz.vondr.workshop.design.tree.node.Node

class DepthNodeIterator implements Iterator<Node> {

    Node node
    Iterator<Node> depthNodeIterator = [].iterator()
    Iterator<Node> childrenIterator


    DepthNodeIterator(Node node) {
        this.node = node
        childrenIterator = node.children.iterator()
    }

    @Override
    boolean hasNext() {
        node != null || depthNodeIterator.hasNext() || childrenIterator.hasNext()
    }

    @Override
    Node next() {

        if (node != null) {
            Node result = node
            node = null
            return result
        }
        if (depthNodeIterator.hasNext()) {
            return depthNodeIterator.next()
        }
        def child = childrenIterator.next()
        depthNodeIterator = new DepthNodeIterator(child)
        return depthNodeIterator.next()
    }
}
