package cz.vondr.workshop.design.life.persons

import static cz.vondr.workshop.design.life.persons.Gender.MALE

class Man extends Person {

    Man(String name) {
        this.gender = MALE
        this.name = name
    }

    @Override
    def reactToBirthday(Person birthdaySubject) {
        println "$this says: oops $birthdaySubject has a birthday, one more step to the grave"
    }

    @Override
    def reactToWedding(Person weddingSubject) {
        println "$this says: poor $weddingSubject, the freedom is gone"
    }
}
