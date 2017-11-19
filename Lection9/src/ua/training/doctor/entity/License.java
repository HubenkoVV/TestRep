package ua.training.doctor.entity;

import java.time.LocalDate;
import java.util.List;

import ua.training.doctor.builders.LicenseBuilder;
import ua.training.doctor.service.Doctor.*;

/**
 * Created by Влада on 14.11.2017.
 */
public class License implements DoctorLicense {

    private HumanDoctorLisence human;

    public enum KindOfActivity{
        Dentist, Oculist, Surgeon
    }
    private KindOfActivity category;

    private LocalDate fromDate;
    private LocalDate expires;

    public License(HumanDoctorLisence human,
                   KindOfActivity category,
                   LocalDate fromDate,
                   LocalDate expires) {
        this.human = human;
        this.category = category;
        this.fromDate = fromDate;
        this.expires = expires;
    }
    public License(LicenseBuilder builder){
        human = builder.getHuman();
        category = builder.getCategory();
        fromDate = builder.getFromDate();
        expires = builder.getExpires();
    }

    @Override
    public List<KindOfActivity> category() {
        return null;
    }

    @Override
    public LocalDate fromDate() {
        return null;
    }

    @Override
    public LocalDate expires() {
        return null;
    }

    public HumanDoctorLisence getHuman() {
        return human;
    }

    public void setHuman(HumanDoctorLisence human) {
        this.human = human;
    }

    public KindOfActivity getCategory() {
        return category;
    }

    public void setCategory(KindOfActivity category) {
        this.category = category;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getExpires() {
        return expires;
    }

    public void setExpires(LocalDate expires) {
        this.expires = expires;
    }

    @Override
    public String toString() {
        return "License{" +
                "human=" + human +
                ", category=" + category +
                ", fromDate=" + fromDate +
                ", expires=" + expires +
                '}';
    }

}
