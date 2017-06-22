package cz.vondr.workshop.design.life.events

import cz.vondr.workshop.design.life.persons.Person

enum EventType {
    BIRTHDAY("birthday", { Person interested, Person eventSubject ->
        interested.reactToBirthday(eventSubject)
    }),
    WEDDING("wedding", { Person interested, Person eventSubject ->
        interested.reactToWedding(eventSubject)
    }),
    ;
    String eventName
    Closure eventHandler

    EventType(String eventName, Closure eventHandler) {
        this.eventName = eventName
        this.eventHandler = eventHandler
    }

    static EventType fromString(String eventName) {
        values().find { it.eventName.equalsIgnoreCase eventName }
    }

    void handleEvent(Person interestedPerson, Person eventSubject) {
        eventHandler.call(interestedPerson, eventSubject)
    }

}
