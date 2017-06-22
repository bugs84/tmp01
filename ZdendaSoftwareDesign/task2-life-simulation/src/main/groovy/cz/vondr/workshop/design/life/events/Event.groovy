package cz.vondr.workshop.design.life.events

import cz.vondr.workshop.design.life.persons.Person

class Event {
    EventType eventType

    Set<Person> interestedPersons = [] as Set

    void addInterestedPerson(Person person) {
        interestedPersons << person
    }

    void eventOccurred(Person subjectOfEvent) {
        interestedPersons.each { interested ->
            if (interested != subjectOfEvent) {
                eventType.handleEvent(interested, subjectOfEvent)
            }
        }
    }


}
