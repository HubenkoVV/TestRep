package ua.training.doctor.builders;

import ua.training.doctor.entity.Human;

import java.time.LocalDate;

/**
 * Created by Влада on 15.11.2017.
 */
public class HumanBuilder {
    private String name;
    private LocalDate birthDate;
    private Human.Gender gender;
    private Human.BloodGroup bloodGroup;

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Human.Gender getGender() {
        return gender;
    }

    public Human.BloodGroup getBloodGroup() {
        return bloodGroup;
    }


    public HumanBuilder() {
    }

    public HumanBuilder name(String val) {
        name = val;
        return this;
    }

    public HumanBuilder birthDate(LocalDate val) {
        birthDate = val;
        return this;
    }

    public HumanBuilder gender(Human.Gender val) {
        gender = val;
        return this;
    }

    public HumanBuilder bloodGroup(Human.BloodGroup val) {
        bloodGroup = val;
        return this;
    }

    public Human build() {
        return new Human(this);
    }
}
