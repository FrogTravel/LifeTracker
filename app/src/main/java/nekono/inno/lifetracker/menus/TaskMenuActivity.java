package nekono.inno.lifetracker.menus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import nekono.inno.lifetracker.R;
import nekono.inno.lifetracker.edittask.EditTaskActivity;

public class TaskMenuActivity extends AppCompatActivity {
    private String taskName;
    private long time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.menu_for_task);

        time = getIntent().getLongExtra("Time",0);
        taskName = getIntent().getStringExtra("TaskName");

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

    }


    public void onTrash(View view){

    }

    public void onLabel(View view){

    }

    public void onPen(View view){
        Intent intent = new Intent(this, EditTaskActivity.class);
        intent.putExtra("task_name", taskName);
        intent.putExtra("time", time);

        this.finish();

        startActivity(intent);
    }

}