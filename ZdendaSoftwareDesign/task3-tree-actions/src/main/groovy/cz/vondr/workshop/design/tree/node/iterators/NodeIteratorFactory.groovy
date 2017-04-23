package cz.vondr.workshop.design.tree.node.iterators

import cz.vondr.workshop.design.tree.node.Node

class NodeIteratorFactory {
    private static final Map<String, Closure<Iterator<Node>>> nodeIterators = [
            "breadth": { Node node -> new BreadthNodeIterator(node) },
            "depth"  : { Node node -> new DepthNodeIterator(node) },
    ]

    Iterator<Node> createFromString(String string, Node node) {
        for (def entry : nodeIterators.entrySet()) {
            if (entry.key.equalsIgnoreCase(string)) {
                return entry.value.call(node)
            }
        }
        throw new IllegalArgumentException("No NodeIterator found for '$string'")
    }
}
