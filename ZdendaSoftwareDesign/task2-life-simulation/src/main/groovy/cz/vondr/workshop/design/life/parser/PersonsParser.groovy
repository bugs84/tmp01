package cz.vondr.workshop.design.life.parser

import cz.vondr.workshop.design.life.Context
import cz.vondr.workshop.design.life.persons.Gender
import cz.vondr.workshop.design.life.persons.PersonsFactory

class PersonsParser {
    private Context context = Context.instance

// input e.g.    F:Alice,M:Bob,M:Charlie,F:Daisy
    void parse(String personsInput) {
        def personStringList = personsInput.split(",")
        personStringList.each { personString ->
            def split = personString.split(":")
            Gender gender = Gender.fromId(split[0])
            String name = split[1]
            def person = PersonsFactory.create(gender, name)
            context.persons.add(person)
        }
    }
}
