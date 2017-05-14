package cz.vondr.workshop.design.life.persons

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import static cz.vondr.workshop.design.life.persons.Gender.FEMALE

@EqualsAndHashCode
@ToString
class Woman extends Person {

    Woman(String name) {
        this.gender = FEMALE
        this.name = name
    }
    
}
