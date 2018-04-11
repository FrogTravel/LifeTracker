package nekono.inno.lifetracker

import com.bignerdranch.expandablerecyclerview.Model.ParentObject
import nekono.inno.lifetracker.expandableview.Project
import nekono.inno.lifetracker.expandableview.Task
import java.util.ArrayList

/**
 * Created by ekaterina on 4/6/18.
 */

class TaskHelperTemp{
    fun generateTasks(): List<ParentObject>{
        val task1 = Task("Task 1")
        val task2 = Task("Task 2")
        val task3 = Task("Task 3")
        val task4 = Task("Task 4")
        val task5 = Task("Task 5")
        val task6 = Task("Task 6")

        val project = Project()
        project.name = "Project1"
        project.description = "Some Description"

        val tasks1 = ArrayList<Any>()
        tasks1.add(task1)
        tasks1.add(task2)
        tasks1.add(task3)

        project.childObjectList = tasks1

        val tasks2 = ArrayList<Any>()
        tasks2.add(task4)
        tasks2.add(task5)
        tasks2.add(task6)


        val project2 = Project()
        project2.name = "Project2"
        project2.description = "Some Description"


        project2.childObjectList = tasks2

        val parentObjects = ArrayList<ParentObject>()
        parentObjects.add(project)
        parentObjects.add(project2)
        return parentObjects
    }
}
