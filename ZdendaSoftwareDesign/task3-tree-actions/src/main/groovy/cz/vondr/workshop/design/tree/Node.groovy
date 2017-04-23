package cz.vondr.workshop.design.tree

import groovy.transform.EqualsAndHashCode

import static java.util.Optional.of

trait Node {
    NodeValue value

    abstract List<Node> getChildren()

    abstract void addChild(Node node)

    abstract boolean isFull()
}

@EqualsAndHashCode
class NodeValue {
    int number

    static val(int number) {
        new NodeValue(number: number)
    }

    @Override
    String toString() {
        number
    }
}

@EqualsAndHashCode
class BinaryNode implements Node {
    Optional<Node> left
    Optional<Node> right

    BinaryNode(NodeValue value, Node left = null, Node right = null) {
        this.value = value
        this.left = Optional.ofNullable(left)
        this.right = Optional.ofNullable(right)
    }

    @Override
    List<Node> getChildren() {
        [left, right].findAll { it.isPresent() }.collect { it.get() }.asImmutable()
    }

    @Override
    void addChild(Node node) {
        if (!left.isPresent()) {
            left = of(node)
            return
        }
        if (!right.isPresent()) {
            right = of(node)
            return
        }
        throw new IllegalStateException("Node is full. Cannot add child.")
    }

    @Override
    boolean isFull() {
        left.isPresent() && right.isPresent()
    }

    @Override
    String toString() {
        def result = new StringBuilder()
        def queue = [this] as Queue<Node>
        while (!queue.isEmpty()) {
            def node = queue.poll()
            result << node.value << ' '
            queue.addAll(node.children)
        }
        result.toString()
    }


}
