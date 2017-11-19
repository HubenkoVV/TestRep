package ua.training.doctor.builders;

import ua.training.doctor.entity.HumanDoctorLisence;
import ua.training.doctor.entity.License;

import java.time.LocalDate;

/**
 * Created by Влада on 15.11.2017.
 */
public class LicenseBuilder {
    private HumanDoctorLisence human;
    private License.KindOfActivity category;
    private LocalDate fromDate;
    private LocalDate expires;

    public HumanDoctorLisence getHuman() {
        return human;
    }

    public License.KindOfActivity getCategory() {
        return category;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public LocalDate getExpires() {
        return expires;
    }

    public LicenseBuilder() {
    }

    public LicenseBuilder human(HumanDoctorLisence val) {
        human = val;
        return this;
    }

    public LicenseBuilder category(License.KindOfActivity val) {
        category = val;
        return this;
    }

    public LicenseBuilder fromDate(LocalDate val) {
        fromDate = val;
        return this;
    }

    public LicenseBuilder expires(LocalDate val) {
        expires = val;
        return this;
    }

    public License build() {
        return new License(this);
    }
}
