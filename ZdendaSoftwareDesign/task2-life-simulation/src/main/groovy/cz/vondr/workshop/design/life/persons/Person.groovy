package cz.vondr.workshop.design.life.persons

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString


@EqualsAndHashCode
@ToString
abstract class Person {
    String name
    Gender gender

}