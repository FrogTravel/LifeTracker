import java.util.ArrayList;

public class Project implements Item {
    String name;
    ArrayList<Task> tasks;

    public Project(String name, ArrayList tasks) {
        this.name = name;
        this.tasks = tasks;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public boolean isContains(Task task) {
        return tasks.contains(task);
    }
}