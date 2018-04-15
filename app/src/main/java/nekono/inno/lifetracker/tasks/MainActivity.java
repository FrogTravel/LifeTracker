package nekono.inno.lifetracker.tasks;

import android.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import nekono.inno.lifetracker.R;
import nekono.inno.lifetracker.expandableview.Project;
import nekono.inno.lifetracker.expandableview.Task;
import nekono.inno.lifetracker.expandableview.TasksExpandableAdapter;


/**
 * site: https://www.bignerdranch.com/blog/expand-a-recyclerview-in-four-steps/?utm_source=Android+Weekly&utm_campaign=8f0cc3ff1f-Android_Weekly_165&utm_medium=email&utm_term=0_4eb677ad19-8f0cc3ff1f-337834121
 */
public class MainActivity extends AppCompatActivity implements Tasks.View {
    //@BindView(R.id.elapsedTimeTextView) TextView elapsedTimeTextView;
    private Tasks.Presenter presenter;
    private TimerFragment timerFragment;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new TaskPresenter(this);


        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        timerFragment = new TimerFragment();
        // fragmentTransaction.add(R.id.fragment_timer_place, timerFragment);
        fragmentTransaction
                .add(R.id.fragment_timer_place, timerFragment)
                .commit();

        View frag = findViewById(R.id.fragment_timer_place);
        frag.setVisibility(View.GONE);

        presenter.start();
        //ButterKnife.bind(this);

        View view = findViewById(R.id.stopButton);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onStopButton();
            }
        });

        View button = findViewById(R.id.start_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.startEmptyTask();
            }
        });
    }

    @Override
    public void showTasks(@NotNull List<ParentObject> parentObjectList) {
        RecyclerView recyclerView = findViewById(R.id.tasksRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        TasksExpandableAdapter tasksExpandableAdapter = new TasksExpandableAdapter(this, presenter);
        tasksExpandableAdapter.setCustomParentAnimationViewId(R.id.parent_list_item_expand_arrow);
        tasksExpandableAdapter.setParentClickableViewAnimationDefaultDuration();
        tasksExpandableAdapter.setParentAndIconExpandOnClick(true);

        recyclerView.setAdapter(tasksExpandableAdapter);
    }

    @Override
    public void showTimer() {
        View frag = findViewById(R.id.fragment_timer_place);
        frag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onFragmentClick();
            }
        });
        frag.setVisibility(View.VISIBLE);
    }

    @Override
    public void setTimerTime(long elapsedTime) {
        timerFragment.setTextElapsedTime(String.valueOf(elapsedTime));
    }

    @Override
    public void hideAddButton() {
        View view = findViewById(R.id.right_labels);
        view.setVisibility(View.GONE);
    }

    @Override
    public void showStopButton() {
        View view = findViewById(R.id.stopButton);
        view.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideStopButton() {
        View view = findViewById(R.id.stopButton);
        view.setVisibility(View.GONE);
    }

    @Override
    public void hideTimer() {
        View frag = findViewById(R.id.fragment_timer_place);
        frag.setVisibility(View.GONE);
    }

    @Override
    public void showAddButton() {
        View view = findViewById(R.id.right_labels);
        view.setVisibility(View.VISIBLE);

        View button = findViewById(R.id.start_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("StartButton", "1234512345");

                presenter.startEmptyTask();
            }
        });
    }

    public void onPlus(View view) {
        presenter.addTask();
    }

}
