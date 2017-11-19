package ua.training.driver.model.entity;

import java.time.LocalDate;

/**
 * Created by Влада on 14.11.2017.
 */
public interface HumanDriver {
    String name();
    LocalDate birth();
    Human.Gender gender();
}
