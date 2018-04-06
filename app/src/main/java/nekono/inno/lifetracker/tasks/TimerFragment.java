package nekono.inno.lifetracker.tasks;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nekono.inno.lifetracker.R;

/**
 * Created by ekaterina on 4/6/18.
 */

public class TimerFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.timer_fragment, container, false);
    }
}
