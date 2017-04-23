package cz.vondr.workshop.design.tree.cmdline

import cz.vondr.workshop.design.tree.Context
import cz.vondr.workshop.design.tree.TreeBuilder
import cz.vondr.workshop.design.tree.node.actions.PlusMinusAction
import cz.vondr.workshop.design.tree.node.actions.PrintAction
import cz.vondr.workshop.design.tree.node.iterators.BreadthNodeIterator
import cz.vondr.workshop.design.tree.node.iterators.DepthNodeIterator

class CmdLineRunner {
    public static final String TRAVERSAL_DEPTH = "depth"
    public static final String TRAVERSAL_BREADTH = "breadth"
    public static final String ACTION_PRINT = "print"
    public static final String ACTION_PLUSMINUS = "+-"

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
        if (TRAVERSAL_DEPTH.equalsIgnoreCase(inputString)) {
            context.nodeIterator = new DepthNodeIterator(context.tree)
        } else if (TRAVERSAL_BREADTH.equalsIgnoreCase(inputString)) {
            context.nodeIterator = new BreadthNodeIterator(context.tree)
        } else {
            throw new IllegalArgumentException("'$inputString' is not allowed input. Allowed inputs are '$TRAVERSAL_DEPTH, $TRAVERSAL_BREADTH'")
        }
    }

    private void askForAction() {
        println "Enter action:"
        String inputString = input.readLine()

        if (ACTION_PRINT.equalsIgnoreCase(inputString)) {
            context.action = new PrintAction(context.nodeIterator)
        } else if (ACTION_PLUSMINUS.equalsIgnoreCase(inputString)) {
            context.action = new PlusMinusAction(context.nodeIterator) 
        } else {
            throw new IllegalArgumentException("'$inputString' is not allowed input. Allowed inputs are '$ACTION_PRINT, $ACTION_PLUSMINUS'")
        }

    }

}
