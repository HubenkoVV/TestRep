package ua.training.doctor;

import ua.training.doctor.builders.HumanBuilder;
import ua.training.doctor.builders.LicenseBuilder;
import ua.training.doctor.entity.*;
import ua.training.doctor.service.Doctor;

import java.time.LocalDate;

/**
 * Created by Влада on 14.11.2017.
 */
public class Main {
    public static void main(String[] args) {
        Human john = new HumanBuilder().
                name("John").
                birthDate(LocalDate.now()).
                gender(Human.Gender.MALE).
                bloodGroup(Human.BloodGroup.FOURTH).
                build();
        System.out.println(john);

        License johnLicence = new LicenseBuilder()
                .human(john)
                .category(License.KindOfActivity.Surgeon)
                .fromDate(LocalDate.now())
                .expires(LocalDate.now().plusDays(365))
                .build();
        System.out.println(johnLicence);

        Doctor johnDoctor = new Doctor(john, johnLicence);
        System.out.println(johnDoctor);
        johnDoctor = null;
    }
}
