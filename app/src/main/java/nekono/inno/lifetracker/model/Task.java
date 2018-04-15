package nekono.inno.lifetracker.model;

import com.orm.SugarRecord;

<<<<<<< HEAD
import java.io.Serializable;
=======
import java.text.SimpleDateFormat;
import java.util.Date;
>>>>>>> charts-activity

public class Task extends SugarRecord implements Serializable{

    String name;
    String category;
    String state;
<<<<<<< HEAD
    String comment;
    Project project = null;

    public Project getProject() {
        return project;
    }

    public Task() {

    }

    public Task(String name, String category, String state, String comment) {
        this.name = name;
        this.category = category;
        this.state = state;
        this.comment = comment;
=======
    String comments;
    String dateStarted;
    String dateCompleted;
    SimpleDateFormat df;
    String timeElapsed;
    Project project = null;

    public Task(){
        df = new SimpleDateFormat("dd-MM-yyyy");
    }

    public Task(String name, String category, String state, String comments, Date started, Date completed, Date timeElapsed) {
        this.name = name;
        this.category = category;
        this.state = state;
        this.comments = comments;
        df = new SimpleDateFormat("dd-MM-yyyy");
        this.dateCompleted = df.format(completed);
        this.timeElapsed = timeElapsed.toString();
        this.dateStarted = df.format(started);
>>>>>>> charts-activity
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

    public Date getTimeElapsed() {
        return new Date(timeElapsed);
    }

    public void setTimeElapsed(Date timeElapsed) {
        this.timeElapsed = timeElapsed.toString();
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

    public String getComment() {
        return comment;
    }

    public void setProject(Project project) {
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

<<<<<<< HEAD

    public void setComment(String comment) {
        this.comment = comment;
=======
    public void setComments(String comments) {
        this.comments = comments;
>>>>>>> charts-activity
        save();
    }
}