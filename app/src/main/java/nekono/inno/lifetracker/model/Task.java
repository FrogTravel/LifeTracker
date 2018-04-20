package nekono.inno.lifetracker.model;

import com.orm.SugarRecord;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Task extends SugarRecord{

    String name;
    String category;
    String state;
    String comments;
    String dateStarted;
    String dateCompleted;
    SimpleDateFormat df;
    long timeElapsed;
    Project project = null;

    public Task(){
        df = new SimpleDateFormat("dd-MM-yyyy");
    }

    public Task(String name, String category, String state, String comments, Date started, Date completed, Duration timeElapsed) {
        this.name = name;
        this.category = category;
        this.state = state;
        this.comments = comments;
        df = new SimpleDateFormat("dd-MM-yyyy");
        this.dateCompleted = df.format(completed);
        this.timeElapsed = timeElapsed.getSeconds();
        this.dateStarted = df.format(started);
        save();
    }

    public Date getDateStarted() {
        try {
            return df.parse(dateCompleted);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setDateStarted(Date dateStarted) {
        this.dateStarted = df.format(dateStarted);
    }

    public Date getDateCompleted() {
        try {
            return df.parse(dateCompleted);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setDateCompleted(Date dateCompleted) {
        this.dateCompleted = df.format(dateCompleted);
    }

    public Project getProject() {
        return project;
    }

    public Duration getTimeElapsed() {
        return Duration.ofSeconds(timeElapsed);
    }

    public void setTimeElapsed(Duration timeElapsed) {
        this.timeElapsed = timeElapsed.getSeconds();
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getState() {
        return state;
    }

    public String getComments() {
        return comments;
    }

    public void setProject(Project project){
        this.project = project;
        save();
    }

    public void setName(String name) {
        this.name = name;
        save();
    }

    public void setCategory(String category) {
        this.category = category;
        save();
    }

    public void setState(String state) {
        this.state = state;
        save();
    }

    public void setComments(String comments) {
        this.comments = comments;
        save();
    }
}