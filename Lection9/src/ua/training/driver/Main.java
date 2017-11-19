package ua.training.driver;

import ua.training.driver.model.entity.DriverLicense;
import ua.training.driver.model.entity.Human;
import ua.training.driver.model.service.Driver;

import java.time.LocalDate;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Human human = new Human("Billy", LocalDate.of(1998, 11, 11), Human.Gender.MALE, Human.BloodGroup.FIRST);

        DriverLicense driverLicense = new DriverLicense(human, LocalDate.of(2020, 12,12), Arrays.asList(DriverLicense.Category.A, DriverLicense.Category.B), LocalDate.of(2014,11,14));

        Driver ourHumanDriver = new Driver(human,driverLicense);
        System.out.println(ourHumanDriver.getHumanDriver().name());
    }
}
