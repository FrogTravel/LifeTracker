package nekono.inno.lifetracker;

import android.content.Context;
import android.widget.AdapterView;
import android.widget.TextView;

public interface NewEditTaskInterface {

    interface View {

        void setItems();
    }

    interface Presenter {

        void onPlayPressed(Context context);

        void onItemSelected(int position, AdapterView<?> parent);

        void onAddPressed(TextView taskName, TextView category, TextView project, TextView comments, Context context);
    }
}
