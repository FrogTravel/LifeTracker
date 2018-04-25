package nekono.inno.lifetracker.menus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import nekono.inno.lifetracker.R;
import nekono.inno.lifetracker.model.Model;
import nekono.inno.lifetracker.model.Task;
import nekono.inno.lifetracker.tasks.MainActivity;

public class CategoryActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_layout);


        Model model = new Model();
        ArrayList<String> list = model.getCategories();


        ListView listView = findViewById(R.id.listView);
        StableArrayAdapter stableArrayAdapter = new StableArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(stableArrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                final String item = (String) parent.getItemAtPosition(position);

                finishCategory(item);
            }

        });
    }

    private void finishCategory(String categoryName){
        Intent intent = new Intent();
        intent.putExtra("CatName", categoryName);
        setResult(1, intent);
        this.finish();
    }

    private class StableArrayAdapter extends ArrayAdapter<String> {

        HashMap<String, Integer> mIdMap = new HashMap();

        public StableArrayAdapter(Context context, int textViewResourceId,
                                  List<String> objects) {
            super(context, textViewResourceId, objects);
            for (int i = 0; i < objects.size(); ++i) {
                mIdMap.put(objects.get(i), i);
            }
        }

        @Override
        public long getItemId(int position) {
            String item = getItem(position);
            return mIdMap.get(item);
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

    }
}


