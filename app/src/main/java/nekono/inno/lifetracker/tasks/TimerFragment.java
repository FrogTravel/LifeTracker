package nekono.inno.lifetracker.tasks;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import nekono.inno.lifetracker.R;

/**
 * Created by ekaterina on 4/6/18.
 */

public class TimerFragment extends Fragment {
    private TextView elapsedTime;
    private ImageView stopIconImageView;
    private TextView taskNameTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.timer_fragment, container, false);
        elapsedTime = (TextView) view.findViewById(R.id.elapsedTimeTextView);
        taskNameTextView = view.findViewById(R.id.taskNameTextView);
        stopIconImageView = view.findViewById(R.id.imageButton);
        elapsedTime.setText("123456");
        return view;
    }


    public void setTextElapsedTime(String text) {
        elapsedTime.setText(text);
    }

    public void setStopIcon(){
        stopIconImageView.setImageResource(R.drawable.ic_pause);
    }

    public void setPlayIcon(){
        stopIconImageView.setImageResource(R.drawable.ic_start);
    }

    public void setTaskName(String name){
        taskNameTextView.setText(name);
    }
}
