package nekono.inno.lifetracker.addtask;

import android.content.Context;
import android.widget.AdapterView;
import android.widget.TextView;

public interface NewEditTaskInterface {

    interface View {

        void setItems();
        void close();
        void startTimer();
    }

    interface Presenter {

        void onPlayPressed(TextView taskName, TextView category, TextView project, TextView comments, Context context, String name, long time);

        void onItemSelected(int posonAddPressedition, AdapterView<?> parent);

        void onAddPressed(TextView name, TextView category, TextView project, TextView comments, Context context, String taskName, long time);

        void addAllInfo(TextView name, TextView category, TextView project, TextView comments, Context context, String taskName, long time);
    }
}
