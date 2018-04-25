package nekono.inno.lifetracker.tasks;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;


import org.jetbrains.annotations.NotNull;

import java.util.List;

import nekono.inno.lifetracker.addtask.NewTaskActivity;
import nekono.inno.lifetracker.R;
import nekono.inno.lifetracker.charts.ChartsActivity;
import nekono.inno.lifetracker.expandableview.TasksExpandableAdapter;
import nekono.inno.lifetracker.menus.CategoryActivity;
import nekono.inno.lifetracker.menus.TaskMenuActivity;

/**
 * site: https://www.bignerdranch.com/blog/expand-a-recyclerview-in-four-steps/?utm_source=Android+Weekly&utm_campaign=8f0cc3ff1f-Android_Weekly_165&utm_medium=email&utm_term=0_4eb677ad19-8f0cc3ff1f-337834121
 */
public class MainActivity extends AppCompatActivity implements Tasks.View {
    //@BindView(R.id.elapsedTimeTextView) TextView elapsedTimeTextView;
    private Tasks.Presenter presenter;
    private TimerFragment timerFragment;
    private FragmentTransaction fragmentTransaction;
    private TasksExpandableAdapter tasksExpandableAdapter;

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
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_charts, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()) {
            case R.id.action_settings:
                startActivity(new Intent(this, ChartsActivity.class));
                break;
            case R.id.action_category:
                Log.d("CCCCCC", "category");
                presenter.categoryClicked();
                break;
        }
        return true;
    }

    @Override
    public void showTasks(@NotNull List<ParentObject> parentObjectList) {
        RecyclerView recyclerView = findViewById(R.id.tasksRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        tasksExpandableAdapter = new TasksExpandableAdapter(this, presenter);
        tasksExpandableAdapter.setCustomParentAnimationViewId(R.id.parent_list_item_expand_arrow);
        tasksExpandableAdapter.setParentClickableViewAnimationDefaultDuration();
        tasksExpandableAdapter.setParentAndIconExpandOnClick(true);

        recyclerView.setAdapter(tasksExpandableAdapter);

    }

    @Override
    public void showTimer() {
        Animation infragment = AnimationUtils.loadAnimation(this, R.anim.timer_in);

        View frag = findViewById(R.id.fragment_timer_place);
        frag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onFragmentClick();
            }
        });
        frag.setVisibility(View.VISIBLE);

        frag.startAnimation(infragment);
    }

    @Override
    public void setTimerTime(String elapsedTime) {
        timerFragment.setTextElapsedTime(elapsedTime);
    }

    @Override
    public void hideAddButton() {
        Animation outbutton = AnimationUtils.loadAnimation(this, R.anim.button_out);

        View view = findViewById(R.id.right_labels);
        view.setVisibility(View.GONE);
        view.startAnimation(outbutton);

    }

    @Override
    public void showStopButton() {
        Animation inbutton = AnimationUtils.loadAnimation(this, R.anim.button_in);
        View view = findViewById(R.id.stopButton);
        view.setVisibility(View.VISIBLE);
        view.startAnimation(inbutton);
    }

    @Override
    public void hideStopButton() {
        Animation outbutton = AnimationUtils.loadAnimation(this, R.anim.button_out);

        View view = findViewById(R.id.stopButton);
        view.setVisibility(View.GONE);
        view.startAnimation(outbutton);

    }

    @Override
    public void hideTimer() {
        Animation outfragment = AnimationUtils.loadAnimation(this, R.anim.timer_out);

        View frag = findViewById(R.id.fragment_timer_place);
        frag.setVisibility(View.GONE);

        frag.startAnimation(outfragment);

    }

    @Override
    public void showAddButton() {
        View view = findViewById(R.id.right_labels);
        view.setVisibility(View.VISIBLE);

        View button = findViewById(R.id.start_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                presenter.startEmptyTask();
            }
        });
    }

    @Override
    public void showAddTask(long time) {
        Intent intent = new Intent(this, NewTaskActivity.class);
        intent.putExtra("time", time);
        startActivity(intent);
    }

    public void onPlus(View view) {
        presenter.addTask();
    }

    @Override
    public void addNewTask(long time){
        Intent intent = new Intent(this, NewTaskActivity.class);
        intent.putExtra("NewTaskTime", time);
        startActivity(intent);
    }

    @Override
    public void showMenuForTask(String taskName, long time){
        Intent intent = new Intent(this, TaskMenuActivity.class);
        intent.putExtra("TaskName", taskName);
        intent.putExtra("Time", time);
        startActivity(intent);
    }

    @Override
    public void setTimerIconToStop() {
        timerFragment.setStopIcon();
    }

    @Override
    public void setTimerIconToPlay() {
        timerFragment.setPlayIcon();
    }

    @Override
    public void setTaskName(String name) {
        timerFragment.setTaskName(name);
    }

    @Override
    public void updateData() {
        tasksExpandableAdapter.notifyDataSetChanged();
    }

    @Override
    public void showCategoryList() {
        Intent intent = new Intent(this, CategoryActivity.class);
        startActivityForResult(intent, 1);//TODO change magic number
    }

    @Override
    public void onResume(){
        super.onResume();
        RecyclerView recyclerView = findViewById(R.id.tasksRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        tasksExpandableAdapter = new TasksExpandableAdapter(this, presenter);
        tasksExpandableAdapter.setCustomParentAnimationViewId(R.id.parent_list_item_expand_arrow);
        tasksExpandableAdapter.setParentClickableViewAnimationDefaultDuration();
        tasksExpandableAdapter.setParentAndIconExpandOnClick(true);

        recyclerView.setAdapter(tasksExpandableAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 1:
                Log.d("ResumeTest", data.getStringExtra("CatName"));

                break;
        }
    }
}
