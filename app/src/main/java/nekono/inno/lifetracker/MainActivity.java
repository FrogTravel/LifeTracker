package nekono.inno.lifetracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import nekono.inno.lifetracker.model.Model;

public class MainActivity extends AppCompatActivity {

    private RecyclerView tasksRecycler;
    private TasksAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tasksRecycler = findViewById(R.id.tasks_recycler);


        adapter = new TasksAdapter();

        tasksRecycler.setAdapter(adapter);

        Model model = new Model();

        adapter.tasks = model.getTasks();
        adapter.notifyDataSetChanged();
    }

}
