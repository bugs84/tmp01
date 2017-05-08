package cz.vondr.workshop.design.life

import cz.vondr.workshop.design.life.events.Event
import cz.vondr.workshop.design.life.events.EventType
import cz.vondr.workshop.design.life.persons.Person

@Singleton
class Context {
    Set<Person> persons = new HashSet<>()
    Set<Event> events = EventType.values().collect{ new Event(eventType: it)}



}
