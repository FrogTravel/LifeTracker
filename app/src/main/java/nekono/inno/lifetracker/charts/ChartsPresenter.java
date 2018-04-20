package nekono.inno.lifetracker.charts;

import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;

import java.util.Date;
import java.util.HashMap;

import nekono.inno.lifetracker.model.Model;
import nekono.inno.lifetracker.model.Task;

public class ChartsPresenter {
    public static HashMap<String, Integer> getTaskCountByCategory() {
        HashMap<String, Integer> dictionary = new HashMap<>();
        for (Task task :
                Model.getTasks()) {
            if (dictionary.containsKey(task.getCategory())) {
                dictionary.put(task.getCategory(), dictionary.get(task.getCategory()) + 1);
            } else {
                dictionary.put(task.getCategory(), 1);
            }
        }
        return dictionary;
    }

    public static HashMap<Integer, Integer> getTasksCompletedThisWeek() {
        HashMap<Integer, Integer> completed = new HashMap<>();
        Calendar cal = Calendar.getInstance();
        for (int i = 0; i < 7; i++) {
            completed.put(i, 0);
        }
        for (Task task :
                (new Model()).getTasks()) {
            if (isDateInCurrentWeek(task.getDateCompleted())) {
                cal.setTime(task.getDateCompleted());
                completed.put(cal.get(Calendar.DAY_OF_WEEK), completed.get(cal.get(Calendar.DAY_OF_WEEK)));
            }
        }
        return completed;
    }

    public static boolean isDateInCurrentWeek(Date date) {
        Calendar currentCalendar = Calendar.getInstance();
        int week = currentCalendar.get(Calendar.WEEK_OF_YEAR);
        int year = currentCalendar.get(Calendar.YEAR);
        Calendar targetCalendar = Calendar.getInstance();
        targetCalendar.setTime(date);
        int targetWeek = targetCalendar.get(Calendar.WEEK_OF_YEAR);
        int targetYear = targetCalendar.get(Calendar.YEAR);
        return week == targetWeek && year == targetYear;
    }

    private static boolean compareDates(Date date1, Date date2) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(date1).equals(sdf.format(date2));
    }
}
