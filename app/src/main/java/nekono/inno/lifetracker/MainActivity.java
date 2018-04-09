package nekono.inno.lifetracker;

import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import nekono.inno.lifetracker.model.Model;
import nekono.inno.lifetracker.model.Task;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Task task = new Task("task1", "Category1", "State1", "comments");
        setContentView(R.layout.activity_main);
        Model model = new Model();
        Log.d("orm",Integer.toString(model.getTasks().size()));
    }
}
