package nekono.inno.lifetracker.tasks;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import java.util.List;

/**
 * Created by ekaterina on 4/11/18.
 */

public interface Tasks {
    interface View{
        void showTasks(List<ParentObject> parentObjectList);
        void showTimer();
        void setTimerTime(long elapsedTime);
        void hideAddButton();
        void showStopButton();
        void hideStopButton();
        void hideTimer();
        void showAddButton();
        void showAddTask();
    }

    interface Presenter{
        void addTask();
        void startEmptyTask();
        List<ParentObject> getParentItemList();
        void longTaskClick();
        void longProjectClick();
        void start();
        void onClickTask();
        void onFragmentClick();
        void onStopButton();
    }
}
