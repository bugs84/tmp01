package cz.vondr.workshop.design.life.persons

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
abstract class Person {
    String name
    Gender gender

    abstract reactToBirthday(Person birthdaySubject);

    abstract reactToWedding(Person weddingSubject);

    @Override
    String toString() {
        name
    }
}