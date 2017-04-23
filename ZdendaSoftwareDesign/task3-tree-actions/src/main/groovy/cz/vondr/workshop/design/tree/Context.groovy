package cz.vondr.workshop.design.tree

import cz.vondr.workshop.design.tree.node.Node

@Singleton
class Context {
    Node tree
    Iterator<Node> nodeIterator

}
