package cz.vondr.workshop.design.life.persons

import static cz.vondr.workshop.design.life.persons.Gender.FEMALE
import static cz.vondr.workshop.design.life.persons.Gender.MALE

class PersonsFactory {

    static Person create(Gender gender, String name) {

        switch (gender) {
            case MALE:
                return new Man(name)
            case FEMALE:
                return new Woman(name)

            default: throw new IllegalArgumentException(gender as String)
        }
    }
}
