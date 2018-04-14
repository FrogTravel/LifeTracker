package nekono.inno.lifetracker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import nekono.inno.lifetracker.model.Task;

public class TaskActionActivity extends AppCompatActivity {

    private static final String TASK_EXTRA_KEY = "TASK_EXTRA";

    public static void startActivity(Context context, Task task) {
        Intent intent = new Intent(context, TaskActionActivity.class);
        intent.putExtra(TASK_EXTRA_KEY, task);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_action_view);

        Task task = (Task) getIntent().getSerializableExtra(TASK_EXTRA_KEY);
        Toast.makeText(this, task.getName(), Toast.LENGTH_SHORT).show();
    }
}
