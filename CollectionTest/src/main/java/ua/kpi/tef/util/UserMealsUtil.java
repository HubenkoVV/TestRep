package ua.kpi.tef.util;

import ua.kpi.tef.model.UserMeal;
import ua.kpi.tef.model.UserMealWithExceed;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Stream;

/**
 * GKislin
 * 31.05.2015.
 */
public class UserMealsUtil {
    public static void main(String[] args) {

        List<UserMeal> mealList = Arrays.asList(
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,10,0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,13,0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,20,0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,10,0), "Завтрак", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,13,0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,20,0), "Ужин", 510),
                new UserMeal(LocalDateTime.of(2015, Month.JUNE, 1,10,0), "Завтрак", 200),
                new UserMeal(LocalDateTime.of(2015, Month.JUNE, 1,13,0), "Обед", 1400),
                new UserMeal(LocalDateTime.of(2015, Month.JUNE, 1,20,0), "Ужин", 500)
        );

        List<UserMealWithExceed>mealOfTime = getFilteredWithExceeded(mealList, LocalTime.of(7, 0), LocalTime.of(12,0), 2000);

        if(mealOfTime.size() == 0)
            System.out.println("No such meals");
        else mealOfTime.forEach(System.out::println);
    }

    static List<UserMealWithExceed>  getFilteredWithExceeded(List<UserMeal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        List<UserMealWithExceed> mealOfTime = new ArrayList<>();
        Map<LocalDate, Integer> caloriesOfDay = new HashMap<LocalDate, Integer>();

        mealList.forEach(meal -> caloriesOfDay.merge(meal.getDateTime().toLocalDate(), meal.getCalories(), (a, b) -> a + b));

        Stream<UserMeal> sortedMeal = mealList.stream().filter(meal -> TimeUtil.isBetween(meal.getDateTime().toLocalTime(), startTime, endTime));
        sortedMeal.forEach( mealWithExceed -> mealOfTime.add(new UserMealWithExceed(mealWithExceed.getDateTime(),
                        mealWithExceed.getDescription(), mealWithExceed.getCalories(),
                        (caloriesOfDay.get(mealWithExceed.getDateTime().toLocalDate()) <= caloriesPerDay))));

        return mealOfTime;
    }

}
