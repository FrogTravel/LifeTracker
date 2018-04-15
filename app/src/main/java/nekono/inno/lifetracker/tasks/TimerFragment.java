package nekono.inno.lifetracker.tasks;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import nekono.inno.lifetracker.R;

/**
 * Created by ekaterina on 4/6/18.
 */

public class TimerFragment extends Fragment {
    private TextView elapsedTime;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.timer_fragment, container, false);
        elapsedTime = (TextView) view.findViewById(R.id.elapsedTimeTextView);
        elapsedTime.setText("123456");
        return view;
    }


    public void setTextElapsedTime(String text){

        elapsedTime.setText(text);
    }

}
