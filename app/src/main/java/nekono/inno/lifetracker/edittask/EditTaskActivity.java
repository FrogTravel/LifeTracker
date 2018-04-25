package nekono.inno.lifetracker.edittask;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

import nekono.inno.lifetracker.R;
import nekono.inno.lifetracker.addtask.NewEditTaskInterface;
import nekono.inno.lifetracker.addtask.NewTaskPresenter;
import nekono.inno.lifetracker.model.Model;
import nekono.inno.lifetracker.model.Project;
import nekono.inno.lifetracker.model.Task;

public class EditTaskActivity extends AppCompatActivity implements View.OnClickListener, NewEditTaskInterface.View, AdapterView.OnItemSelectedListener {

    private TextView name;
    private TextView category;
    private TextView project;
    private TextView comments;
    private Spinner states;

    private Button addButton;
    private FloatingActionButton playButton;

    private NewEditTaskInterface.Presenter presenter;

    private String taskName;
    private long time;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_task);

        taskName = getIntent().getStringExtra("task_name");
        time = getIntent().getLongExtra("time", 0);

        Model model = new Model();
        Task task = new Task();
        List<Task> tasks = model.getTasks();
        for (int i = 0; i < tasks.size(); i++) {
            if((tasks.get(i).getName() != null) && (tasks.get(i).getName().equals(name))) {
                task = tasks.get(i);
            }
        }

        name = findViewById(R.id.taskName);
        category = findViewById(R.id.category);
        project = findViewById(R.id.project);
        comments = findViewById(R.id.comments);
        states = findViewById(R.id.states);
        addButton = findViewById(R.id.addButton);
        playButton = findViewById(R.id.playButton);

        name.setText(taskName);
        category.setText(task.getCategory());
        project.setText(task.getProject().getName());
        comments.setText(task.getComments());

        addButton.setOnClickListener(this);
        playButton.setOnClickListener(this);
        states.setOnItemSelectedListener(this);

        presenter = new NewTaskPresenter(this);
    }

    public void setItems() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.states, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        states.setAdapter(adapter);
    }

    @Override
    public void close() {
        this.finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addButton:
                presenter.onAddPressed(name, category, project, comments, this, taskName, time);
                break;
            case R.id.playButton:
                presenter.onPlayPressed(this);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        presenter.onItemSelected(position, parent);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}
