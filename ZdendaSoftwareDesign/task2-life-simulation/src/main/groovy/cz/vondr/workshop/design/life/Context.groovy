package cz.vondr.workshop.design.life

import cz.vondr.workshop.design.life.persons.Person

@Singleton
class Context {
    Set<Person> persons = new HashSet<>()
}
