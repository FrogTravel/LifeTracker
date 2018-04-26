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
        void setTimerTime(String elapsedTime);
        void hideAddButton();
        void showStopButton();
        void hideStopButton();
        void hideTimer();
        void showAddButton();
        void showMenuForTask(String taskName, long time);
        void setTimerIconToStop();
        void setTimerIconToPlay();
        void setTaskName(String name);
        void updateData();
        void showCategoryList();
        void saveTask(long time, String name);
        void showAddingEmptyTask(long time);
        void showCategory(String categoryName);
    }

    interface Presenter{
        void addTask();
        void startEmptyTask();
        List<ParentObject> getParentItemList();
        void longTaskClick(String taskName);
        void longProjectClick();
        void start();
        void onClickTask(String taskName);
        void onFragmentClick();
        void onStopButton();
        void categoryClicked();
        void startTask(String taskName);
    }
}
