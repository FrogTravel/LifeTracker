package nekono.inno.lifetracker.menus;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.HashMap;
import java.util.List;

import nekono.inno.lifetracker.R;
import nekono.inno.lifetracker.model.Task;

public class CategoryActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//
//
//        ListView listView = findViewById(R.id.listView);
//        StableArrayAdapter stableArrayAdapter = new StableArrayAdapter(this, R.layout.list_task_item, );
    }


    private class StableArrayAdapter extends ArrayAdapter<Task> {

        HashMap<Task, Integer> mIdMap = new HashMap();

        public StableArrayAdapter(Context context, int textViewResourceId,
                                  List<Task> objects) {
            super(context, textViewResourceId, objects);
            for (int i = 0; i < objects.size(); ++i) {
                mIdMap.put(objects.get(i), i);
            }
        }

        @Override
        public long getItemId(int position) {
            Task item = getItem(position);
            return mIdMap.get(item);
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

    }
}


