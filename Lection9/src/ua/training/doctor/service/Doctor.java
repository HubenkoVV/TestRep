package ua.training.doctor.service;

import ua.training.doctor.entity.DoctorLicense;
import ua.training.doctor.entity.HumanDoctor;
import ua.training.doctor.entity.HumanDoctorLisence;

/**
 * Created by Влада on 14.11.2017.
 */
public class Doctor {
    private HumanDoctor doctor;
    private DoctorLicense license;

    public Doctor(HumanDoctor doctor, DoctorLicense license) {
        this.doctor = doctor;
        this.license = license;
    }

    public HumanDoctor getDoctor() {
        return doctor;
    }

    public void setDoctor(HumanDoctor doctor) {
        this.doctor = doctor;
    }

    public DoctorLicense getLicense() {
        return license;
    }

    public void setLicense(DoctorLicense license) {
        this.license = license;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctor=" + doctor +
                ", license=" + license +
                '}';
    }
}
