package nekono.inno.lifetracker.tasks

import nekono.inno.lifetracker.CountUpTimer
import nekono.inno.lifetracker.TaskHelperTemp

/**
 * Created by ekaterina on 4/6/18.
 */

class TaskPresenter(val view: Tasks.View) : Tasks.Presenter{
    val helper = TaskHelperTemp()

    init {
        view.showTasks(helper.generateTasks())
    }

    override fun startEmptyTask() {
        view.showTimer()
        val timer = object : CountUpTimer(1000) {
            override fun onTick(elapsedTime: Long) {
                view.setTimerTime(toSeconds(elapsedTime))//TODO transform to norm time view
            }
        }

        timer.start()

    }

    override fun addTask() {
        TODO("Alina's code call here")
    }

    private fun toSeconds(time: Long) = time/1000
}
