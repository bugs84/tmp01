package cz.vondr.workshop.design.tree.node.actions

import cz.vondr.workshop.design.tree.node.Node

class PlusMinusAction implements Action {

    Iterator<Node> nodeIterator

    PlusMinusAction(Iterator<Node> nodeIterator) {
        this.nodeIterator = nodeIterator
    }

    @Override
    void perform() {
        int result = 0
        nodeIterator.eachWithIndex { Node node, index ->
            result += node.value.number * (-1)**index
        }
        println "=$result"
    }
}