package nekono.inno.lifetracker;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.widget.TextView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import nekono.inno.lifetracker.addtask.NewEditTaskInterface;
import nekono.inno.lifetracker.addtask.NewTaskPresenter;
import nekono.inno.lifetracker.model.Model;
import nekono.inno.lifetracker.model.Project;
import nekono.inno.lifetracker.model.Task;
import nekono.inno.lifetracker.utils.Message;

import static org.junit.Assert.*;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class TaskInstrumentedTest {
    private Context context;
    private final String TEST_PROJECT_NAME = "Test project";

    private Project getTestProject () {
        Model model = new Model();
        List<Project> projects = model.getProjects();
        Project testProject = null;

        for (Project project : projects) {
            if (project.getName().equals(TEST_PROJECT_NAME)) {
                testProject = project;
            }
        }

        return testProject;
    }

    @Before
    public void init() {
        context = InstrumentationRegistry.getTargetContext();
    }

    @After
    public void cleanUp() {
        Project project = getTestProject();
        List<Task> tasks = project.getTasks();
        for (Task task : tasks) {
            task.delete();
        }
        project.delete();
    }

    @Test
    public void test_empty_task_name_Untitled() {
        Message message = mock(Message.class);
        doNothing().when(message).showMessage(isA(Context.class), anyString(), anyInt());

        NewTaskPresenter presenter = new NewTaskPresenter(new NewEditTaskInterface.View() {
            @Override
            public void setItems() {

            }

            @Override
            public void close() {

            }
        });

        String testTaskName = "";

        TextView taskNameTextView = new TextView(context);
        taskNameTextView.setText(testTaskName);
        TextView categoryTextView = new TextView(context);
        categoryTextView.setText("");
        TextView projectTextView = new TextView(context);
        projectTextView.setText(TEST_PROJECT_NAME);
        TextView commentsTextView = new TextView(context);
        commentsTextView.setText("");

        presenter.onAddPressed(taskNameTextView, categoryTextView, projectTextView,
                commentsTextView, context, testTaskName, message);

        Project testProject = getTestProject();


        List<Task> tasks = testProject.getTasks();

        Task test_task = tasks.get(0);
        assertEquals(test_task.getName(), "Untitled");
    }
}

