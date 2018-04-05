import java.util.ArrayList;

public class All {
    ArrayList<Project> projects;
    ArrayList<Task> tasks;
    ArrayList<Item> all;

    public All() {
        projects = new ArrayList<Project>();
        tasks = new ArrayList<Task>();
        all = new ArrayList<Item>();
    }

    public void addProject(Project project) {
        projects.add(project);
        all.add(project);
    }

    public void addTask(Task task) {
        tasks.add(task);
        all.add(task);
    }

    public void addItem(Item item) {
        all.add(item);
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public ArrayList<Item> getAllItems() {
        return all;
    }
}