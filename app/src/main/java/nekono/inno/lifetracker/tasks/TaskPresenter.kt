package nekono.inno.lifetracker.tasks

import nekono.inno.lifetracker.TaskHelperTemp

/**
 * Created by ekaterina on 4/6/18.
 */

class TaskPresenter(val view: Tasks.View) : Tasks.Presenter{
    val helper = TaskHelperTemp()

    init {
        view.showTasks(helper.generateTasks())
    }
}
