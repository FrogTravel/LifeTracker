package nekono.inno.lifetracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Date;

import nekono.inno.lifetracker.model.Model;
import nekono.inno.lifetracker.model.Task;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Task task = new Task("task1", "Category2", "State1", "comments",
                Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), new Date(0));
        setContentView(R.layout.activity_main);
        Model model = new Model();
        Intent intent = new Intent(this, ChartsActivity.class);
        startActivity(intent);
    }
}
