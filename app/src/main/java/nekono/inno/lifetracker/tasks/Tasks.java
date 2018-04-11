package nekono.inno.lifetracker.tasks;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import java.util.List;

/**
 * Created by ekaterina on 4/11/18.
 */

public interface Tasks {
    interface View{
        void showTasks(List<ParentObject> parentObjectList);
    }

    interface Presenter{

    }
}
