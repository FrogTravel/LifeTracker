package nekono.inno.lifetracker.tasks;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.HashMap;
import java.util.List;

import nekono.inno.lifetracker.model.Task;

public class TasksByCategoryArrayAdapter extends ArrayAdapter<Task> {
    HashMap<Task, Integer> mIdMap = new HashMap();

    public TasksByCategoryArrayAdapter(Context context, int textViewResourceId,
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
