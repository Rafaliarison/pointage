package org.example;

import lombok.Getter;
import java.util.logging.Logger;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
@Getter
public class Calendar {
    Set<LocalDate> publicDays;

    private static final Logger logger = Logger.getLogger(Calendar.class.getName());

    public Calendar(Set<LocalDate> publicDaus) {
        this.publicDays = publicDaus;
    }

    public void calendar(int month, int year){
        Set<LocalDate> publicDays = new HashSet<>();

        publicDays.add(LocalDate.of(year, month, 17));
        publicDays.add(LocalDate.of(year, month, 25));
        publicDays.add(LocalDate.of(year, month, 26));

        LocalDate date = LocalDate.of(year, month, 1);
        LocalDate endOfMonth = date.withDayOfMonth(date.lengthOfMonth());

        while(!date.isAfter(endOfMonth)) {
            DayOfWeek dayOfWeek = date.getDayOfWeek();
            if (publicDays.contains(date)) {
                logger.info(date + " - Public day");
            } else {
                if (dayOfWeek != DayOfWeek.SATURDAY && dayOfWeek != DayOfWeek.SUNDAY) {
                    logger.info(date + " - Normal working day");
                } else {
                    logger.info(date + " - Working day");
                }
            }
            date = date.plusDays(1);
        }
    }
}
