package nekono.inno.lifetracker.tasks;

import android.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import nekono.inno.lifetracker.R;
import nekono.inno.lifetracker.expandableview.Project;
import nekono.inno.lifetracker.expandableview.Task;
import nekono.inno.lifetracker.expandableview.TasksExpandableAdapter;


/**
 * site: https://www.bignerdranch.com/blog/expand-a-recyclerview-in-four-steps/?utm_source=Android+Weekly&utm_campaign=8f0cc3ff1f-Android_Weekly_165&utm_medium=email&utm_term=0_4eb677ad19-8f0cc3ff1f-337834121
 */
public class MainActivity extends AppCompatActivity implements Tasks.View{
    private Tasks.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new TaskPresenter(this);


        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        TimerFragment timerFragment = new TimerFragment();
        fragmentTransaction.add(R.id.fragment_timer_place, timerFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void showTasks(@NotNull List<ParentObject> parentObjectList) {
        RecyclerView recyclerView = findViewById(R.id.tasksRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        TasksExpandableAdapter tasksExpandableAdapter = new TasksExpandableAdapter(this, parentObjectList);
        tasksExpandableAdapter.setCustomParentAnimationViewId(R.id.parent_list_item_expand_arrow);
        tasksExpandableAdapter.setParentClickableViewAnimationDefaultDuration();
        tasksExpandableAdapter.setParentAndIconExpandOnClick(true);

        recyclerView.setAdapter(tasksExpandableAdapter);
    }
}
