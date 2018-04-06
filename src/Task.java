public class Task {
    String name;
    String category;
    String state;
    String project;
    String comments;

    public Task(String name, String category, String state, String project, String comments) {
        this.name = name;
        this.category = category;
        this.state = state;
        this.project = project;
        this.comments = comments;
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

    public String getProject() {
        return project;
    }

    public String getComments() {
        return comments;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}