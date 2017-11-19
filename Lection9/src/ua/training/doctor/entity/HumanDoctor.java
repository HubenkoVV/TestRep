package ua.training.doctor.entity;

import java.time.LocalDate;

/**
 * Created by Влада on 14.11.2017.
 */
public interface HumanDoctor {
    String name();
    LocalDate birthday();
    Human.Gender gender();
}
