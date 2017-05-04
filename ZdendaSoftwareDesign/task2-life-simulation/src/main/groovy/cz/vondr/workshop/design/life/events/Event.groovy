package cz.vondr.workshop.design.life.events

import cz.vondr.workshop.design.life.persons.Person

class Event {
    EventType eventType



    Set<Person> interestedPersons = [] as Set

    void addInterestedPerson(Person person) {
        interestedPersons.add(person)
    }

}
