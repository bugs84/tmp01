package cz.vondr.workshop.design.life

import cz.vondr.workshop.design.life.events.Event
import cz.vondr.workshop.design.life.events.EventType

@Singleton
class Context {
    Set<Event> events = EventType.values().collect{ new Event(eventType: it)}



}
