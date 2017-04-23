package cz.vondr.workshop.design.tree.cmdline

import cz.vondr.workshop.design.tree.Context
import cz.vondr.workshop.design.tree.TreeBuilder
import cz.vondr.workshop.design.tree.node.iterators.BreathNodeIterator
import cz.vondr.workshop.design.tree.node.iterators.DepthNodeIterator

class CmdLineRunner {
    public static final String TRAVERSAL_DEPTH = "depth"
    public static final String TRAVERSAL_BREATH = "breath"
    private Context context = Context.instance

    void start() {
        askForTree()
        askForTraversal()

        //TODO remove this
        context.nodeIterator.each {
            print it.value.number + " "
        }
        println ""

    }


    private void askForTree() {
        println "Enter complete binary tree:"
        String treeString = System.in.newReader().readLine()

        context.tree = new TreeBuilder().buildTreeFromString(treeString)
    }

    private void askForTraversal() {
        println "Enter tree traversal:"
        String inputString = System.in.newReader().readLine()
        if (TRAVERSAL_DEPTH.equalsIgnoreCase(inputString)) {
            context.nodeIterator = new DepthNodeIterator(context.tree)
        } else if (TRAVERSAL_BREATH.equalsIgnoreCase(inputString)) {
            context.nodeIterator = new BreathNodeIterator(context.tree)
        } else {
            throw new IllegalArgumentException("'$inputString' is not allowed input. Allowed inputs are '$TRAVERSAL_DEPTH, $TRAVERSAL_BREATH'")
        }

    }
}
