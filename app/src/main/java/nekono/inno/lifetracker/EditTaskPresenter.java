package nekono.inno.lifetracker;

public class EditTaskPresenter implements EditTaskPresentInterface {

    private EditTaskView editTaskView;

    public EditTaskPresenter(EditTaskView editTaskView) {
        this.editTaskView = editTaskView;
    }

    @Override
    public void onButtonClicked() {

    }

    @Override
    public void onItemSelected(int position) {
        //TODO set a state to task in db
    }
}
