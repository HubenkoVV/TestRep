package ua.training.doctor.entity;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Влада on 14.11.2017.
 */
public interface DoctorLicense{

    List<License.KindOfActivity> category();
    LocalDate fromDate();
    LocalDate expires();
}
