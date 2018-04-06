import java.util.ArrayList;

public class All {
    ArrayList<Project> projects;
    ArrayList<Task> tasks;
    ArrayList<Object> all;

    public All() {
        projects = new ArrayList<Project>();
        tasks = new ArrayList<Task>();
        all = new ArrayList<Object>();
    }

    public void addProject(Project project) {
        projects.add(project);
        all.add(project);
    }

    public void addTask(Task task) {
        tasks.add(task);
        all.add(task);
    }

    public void addItem(Object item) {
        all.add(item);
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public ArrayList<Object> getAllItems() {
        return all;
    }
}