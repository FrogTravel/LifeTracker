package nekono.inno.lifetracker.tasks

import android.util.Log
import com.bignerdranch.expandablerecyclerview.Model.ParentObject
import nekono.inno.lifetracker.CountUpTimer
import nekono.inno.lifetracker.model.Model

/**
 * Created by ekaterina on 4/6/18.
 */

class TaskPresenter(val view: Tasks.View) : Tasks.Presenter{
    private var isRunning = false
    private lateinit var timer: CountUpTimer
    private var time: Long = 0
    private var model = Model()

    override fun start(){
        view.hideStopButton()
        view.showTasks(model.parentObjectProject)
        timer = object : CountUpTimer(1000) {
            override fun onTick(elapsedTime: Long) {
                time += 1000

                view.setTimerTime(toSeconds(time))//TODO transform to norm time view
            }
        }
    }

    override fun startEmptyTask() {
        if(!isRunning) {
            view.showTimer()


            timer.start()
            isRunning = true

            view.hideAddButton()
            view.showStopButton()
        }

    }

    override fun addTask() {
        view.showAddTask()
    }

    private fun toSeconds(time: Long) = time/1000

    override fun getParentItemList(): List<ParentObject> = model.projects

    override fun longTaskClick(){
        Log.d("ClickTest", "Long task Click")
    }

    override fun longProjectClick(){
        Log.d("ClickTest", "Long Project Click")

    }

    override fun onClickTask() {
        Log.d("ClickTest", "task Click")
    }

    override fun onFragmentClick() {
        if(isRunning){
            timer.stop()
        }else{
            timer.start()
        }
        isRunning = !isRunning
    }

    override fun onStopButton() {
        Log.d("ClickTest", "task Click")

        view.hideTimer()
        view.hideStopButton()
        view.showAddButton()

        timer.stop()
        isRunning = false

        //TODO add this empty task
    }
}
