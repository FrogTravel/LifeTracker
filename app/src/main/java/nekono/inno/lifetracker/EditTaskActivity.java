package nekono.inno.lifetracker;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class EditTaskActivity extends AppCompatActivity implements View.OnClickListener, NewEditTaskInterface.View, AdapterView.OnItemSelectedListener {

    private TextView taskName;
    private TextView category;
    private TextView project;
    private TextView comments;
    private Spinner states;

    private Button addButton;
    private FloatingActionButton playButton;

    private NewEditTaskInterface.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_task);

        taskName = findViewById(R.id.taskName);
        category = findViewById(R.id.category);
        project = findViewById(R.id.project);
        comments = findViewById(R.id.comments);
        states = findViewById(R.id.states);
        addButton = findViewById(R.id.addButton);
        playButton = findViewById(R.id.playButton);

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
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addButton:
                presenter.onAddPressed(taskName, category, project, comments, this);
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
