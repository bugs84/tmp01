package cz.vondr.workshop.design.tree

trait Node implements Iterable<Node> {
    int value
}

class BinaryNode implements Node {
    Optional<Node> left
    Optional<Node> right

    BinaryNode(int value, Node left = null, Node right = null) {
        this.value = value
        this.left = Optional.ofNullable(left)
        this.right = Optional.ofNullable(right)
    }

    @Override
    Iterator<Node> iterator() {
        return [left, right].findAll { it.isPresent() }.collect { it.get() }.asImmutable().iterator()
    }

}
