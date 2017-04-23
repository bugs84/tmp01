package cz.vondr.workshop.design.tree.node.actions

import cz.vondr.workshop.design.tree.node.Node

class ActionFactory {

    private static final Map<String, Closure<Action>> actions = [
            "print": { Iterator<Node> iterator -> new PrintAction(iterator) },
            "+-"   : { Iterator<Node> iterator -> new PlusMinusAction(iterator) },
    ]

    Action createFromString(String actionName, Iterator<Node> iterator) {
        for (def entry : actions.entrySet()) {
            if (entry.key.equalsIgnoreCase(actionName)) {
                return entry.value.call(iterator)
            }
        }

        throw new IllegalArgumentException("No action found for '$actionName'")
    }
}
