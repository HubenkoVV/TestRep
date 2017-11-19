package ua.training.driver.model.entity;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Влада on 14.11.2017.
 */
public interface DriverLicenseDriver {
    List<DriverLicense.Category> category();
    LocalDate fromDate();
    LocalDate expires();
}
