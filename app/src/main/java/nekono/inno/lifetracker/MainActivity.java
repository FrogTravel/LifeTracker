package nekono.inno.lifetracker;

import android.content.Intent;
<<<<<<< HEAD
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
<<<<<<< HEAD
import android.view.View;
=======
import android.support.v7.widget.RecyclerView;
=======
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Date;
>>>>>>> charts-activity

import nekono.inno.lifetracker.model.Model;
>>>>>>> refs/remotes/origin/master

public class MainActivity extends AppCompatActivity {

    private RecyclerView tasksRecycler;
    private TasksAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD
=======
        Task task = new Task("task1", "Category2", "State1", "comments",
                Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), new Date(0));
>>>>>>> charts-activity
        setContentView(R.layout.activity_main);

        tasksRecycler = findViewById(R.id.tasks_recycler);


        adapter = new TasksAdapter();

        tasksRecycler.setAdapter(adapter);

        Model model = new Model();
<<<<<<< HEAD

        adapter.tasks = model.getTasks();
        adapter.notifyDataSetChanged();
    }

<<<<<<< HEAD
    public void onClickk(View view){
        Intent intent = new Intent(this, EditTask.class);
=======
        Intent intent = new Intent(this, ChartsActivity.class);
>>>>>>> charts-activity
        startActivity(intent);
    }
=======
>>>>>>> refs/remotes/origin/master
}
