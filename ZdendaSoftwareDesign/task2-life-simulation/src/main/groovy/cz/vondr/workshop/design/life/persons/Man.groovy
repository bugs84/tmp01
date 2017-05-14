package cz.vondr.workshop.design.life.persons

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import static cz.vondr.workshop.design.life.persons.Gender.MALE

@EqualsAndHashCode
@ToString
class Man extends Person {

    Man(String name) {
        this.gender = MALE
        this.name = name
    }
    
}
