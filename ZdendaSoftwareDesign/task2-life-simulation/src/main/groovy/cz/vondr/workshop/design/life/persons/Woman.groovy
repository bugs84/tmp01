package cz.vondr.workshop.design.life.persons

import static cz.vondr.workshop.design.life.persons.Gender.FEMALE

class Woman extends Person {

    Woman(String name) {
        this.gender = FEMALE
        this.name = name
    }

    @Override
    def reactToBirthday(Person birthdaySubject) {
        println "$this says: all the best $birthdaySubject, wish you a wonderful life"
    }

    @Override
    def reactToWedding(Person weddingSubject) {
        println "$this says: yaaay, $weddingSubject is so lucky to be married now"
    }
}
