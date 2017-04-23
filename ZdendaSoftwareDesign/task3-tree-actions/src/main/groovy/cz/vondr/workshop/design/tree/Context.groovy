package cz.vondr.workshop.design.tree

import cz.vondr.workshop.design.tree.node.Node
import cz.vondr.workshop.design.tree.node.actions.Action

@Singleton
class Context {
    Node tree
    Iterator<Node> nodeIterator
    Action action

}
