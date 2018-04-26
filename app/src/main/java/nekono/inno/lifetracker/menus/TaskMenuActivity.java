package nekono.inno.lifetracker.menus;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import nekono.inno.lifetracker.R;
import nekono.inno.lifetracker.edittask.EditTaskActivity;
import nekono.inno.lifetracker.model.Model;

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
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.delete_confirm)
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // FIRE ZE MISSILES!
                        Model.getTasksByName(taskName).get(0).delete();
                        finishActivity();
                    }
                })
                .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        finishActivity();
                    }
                }).create().show();

    }

    public void onPen(View view){
        Intent intent = new Intent(this, EditTaskActivity.class);
        intent.putExtra("task_name", taskName);
        intent.putExtra("time", time);

        this.finish();

        startActivity(intent);
    }

    public void finishActivity(){
        this.finish();
    }

}