package ua.training.driver.model.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Влада on 14.11.2017.
 */
public class DriverLicense implements DriverLicenseDriver {

    private HumanDriverLicense humanDriverLicense;

    public enum Category { A,B,C,D,E}
    private List<Category> categories = new ArrayList<Category>();

    private LocalDate fromDate;
    private LocalDate expires;

    public DriverLicense() {
    }

    public DriverLicense(HumanDriverLicense human, LocalDate expires, List<Category> categories, LocalDate fromDate) {
        this.expires = expires;
        this.categories = categories;
        this.fromDate = fromDate;
    }
    public DriverLicense(LocalDate expires, Category category, LocalDate fromDate) {
        this.expires = expires;
        this.categories.add( category );
        this.fromDate = fromDate;
    }

    @Override
    public List<Category> category() {
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

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
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
        return "DriverLicense{" +
                "categories=" + categories +
                ", fromDate=" + fromDate +
                ", expires=" + expires +
                '}';
    }
}
