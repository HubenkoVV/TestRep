package ua.training.driver.model.service;

import ua.training.driver.model.entity.DriverLicenseDriver;
import ua.training.driver.model.entity.HumanDriver;

/**
 * Created by Влада on 14.11.2017.
 */
public class Driver {
    private HumanDriver humanDriver;
    private DriverLicenseDriver driverLicenseDriver;

    public Driver(HumanDriver humanDriver, DriverLicenseDriver driverLicenseDriver) {
        this.humanDriver = humanDriver;
        this.driverLicenseDriver = driverLicenseDriver;
    }

    public HumanDriver getHumanDriver() {
        return humanDriver;
    }

    public void setHumanDriver(HumanDriver humanDriver) {
        this.humanDriver = humanDriver;
    }

    public DriverLicenseDriver getDriverLicenseDriver() {
        return driverLicenseDriver;
    }

    public void setDriverLicenseDriver(DriverLicenseDriver driverLicenseDriver) {
        this.driverLicenseDriver = driverLicenseDriver;
    }
}
