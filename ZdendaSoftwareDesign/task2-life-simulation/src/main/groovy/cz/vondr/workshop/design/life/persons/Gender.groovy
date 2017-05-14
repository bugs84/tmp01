package cz.vondr.workshop.design.life.persons

enum Gender {
    MALE("M"),
    FEMALE("F"),
    ;

    String id;

    Gender(String id) {
        this.id = id
    }

    static Gender fromId(String id) {
        for (Gender gender : values()) {
            if (gender.id.equalsIgnoreCase(id))
                return gender
        }

        throw new IllegalStateException(id)
    }
}