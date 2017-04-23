package cz.vondr.workshop.design.tree.cmdline

import cz.vondr.workshop.design.tree.Context
import cz.vondr.workshop.design.tree.TreeBuilder
import cz.vondr.workshop.design.tree.node.actions.ActionFactory
import cz.vondr.workshop.design.tree.node.iterators.NodeIteratorFactory

class CmdLineRunner {

    private Context context = Context.instance
    private BufferedReader input

    CmdLineRunner(InputStream input = System.in) {
        this.input = input.newReader()
    }

    void start() {
        askForTree()
        askForTraversal()
        askForAction()
        context.action.perform()
    }

    private void askForTree() {
        println "Enter complete binary tree:"
        String treeString = input.readLine()

        context.tree = new TreeBuilder().buildTreeFromString(treeString)
    }

    private void askForTraversal() {
        println "Enter tree traversal:"
        String inputString = input.readLine()
        context.nodeIterator = new NodeIteratorFactory().createFromString(inputString, context.tree)
    }

    private void askForAction() {
        println "Enter action:"
        String inputString = input.readLine()
        context.action = new ActionFactory().createFromString(inputString, context.nodeIterator)
    }

}
