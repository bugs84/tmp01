package cz.vondr.workshop.design.tree.node.actions

import spock.lang.Specification

class ActionFactoryTest extends Specification {

    def "create plusMinus action works"() {
        when:
        def action = new ActionFactory().createFromString("+-", [].iterator())

        then:
        action instanceof PlusMinusAction
    }

    def "create print action ignore case"() {
        when:
        def action = new ActionFactory().createFromString("PrInT", [].iterator())

        then:
        action instanceof PrintAction
    }

    def "create hand over correct iterator"() {
        def iterator = [].iterator()
        when:
        def action = new ActionFactory().createFromString("print", iterator)

        then:
        System.identityHashCode(iterator) == System.identityHashCode(action.nodeIterator)
    }
}
