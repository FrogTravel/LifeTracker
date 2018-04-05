package nekono.inno.lifetracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import java.util.ArrayList;
import java.util.List;

import nekono.inno.lifetracker.expandableview.Project;
import nekono.inno.lifetracker.expandableview.Task;
import nekono.inno.lifetracker.expandableview.TasksExpandableAdapter;


/**
 * site: https://www.bignerdranch.com/blog/expand-a-recyclerview-in-four-steps/?utm_source=Android+Weekly&utm_campaign=8f0cc3ff1f-Android_Weekly_165&utm_medium=email&utm_term=0_4eb677ad19-8f0cc3ff1f-337834121
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.tasksRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Task task1 = new Task("Task 1");
        Task task2 = new Task("Task 2");
        Task task3 = new Task("Task 3");
        Task task4 = new Task("Task 4");
        Task task5 = new Task("Task 5");
        Task task6 = new Task("Task 6");

        Project project = new Project();
        project.setName("Project1");
        project.setDescription("Some Description");

        List<Object> tasks1 = new ArrayList<>();
        tasks1.add(task1);
        tasks1.add(task2);
        tasks1.add(task3);

        project.setChildObjectList(tasks1);

        List<Object> tasks2 = new ArrayList<>();
        tasks2.add(task4);
        tasks2.add(task5);
        tasks2.add(task6);


        Project project2 = new Project();
        project2.setName("Project2");
        project2.setDescription("Some Description");


        project2.setChildObjectList(tasks2);



        List<ParentObject> parentObjects = new ArrayList<>();
        parentObjects.add(project);
        parentObjects.add(project2);

        TasksExpandableAdapter tasksExpandableAdapter = new TasksExpandableAdapter(this, parentObjects);
        tasksExpandableAdapter.setCustomParentAnimationViewId(R.id.parent_list_item_expand_arrow);
        tasksExpandableAdapter.setParentClickableViewAnimationDefaultDuration();
        tasksExpandableAdapter.setParentAndIconExpandOnClick(true);

        recyclerView.setAdapter(tasksExpandableAdapter);

    }
}
