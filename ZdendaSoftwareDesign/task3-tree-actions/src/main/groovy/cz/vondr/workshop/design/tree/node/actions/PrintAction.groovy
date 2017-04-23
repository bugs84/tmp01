package cz.vondr.workshop.design.tree.node.actions

import cz.vondr.workshop.design.tree.node.Node


class PrintAction implements Action {

    private Iterator<Node> nodeIterator

    PrintAction(Iterator<Node> nodeIterator) {
        this.nodeIterator = nodeIterator

    }

    @Override
    void perform() {
        nodeIterator.each { Node node ->
            print node.value.number
            if (nodeIterator.hasNext()) print " "
        }
        println ""
    }
}
