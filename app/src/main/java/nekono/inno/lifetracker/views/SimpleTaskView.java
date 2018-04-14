package nekono.inno.lifetracker.views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import nekono.inno.lifetracker.R;
import nekono.inno.lifetracker.model.Task;

public class SimpleTaskView extends RelativeLayout {

    private TextView title, subTitle;
    private ImageView icon;


    public SimpleTaskView(Context context) {
        super(context);
    }

    public SimpleTaskView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SimpleTaskView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public SimpleTaskView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        initViews();
    }

    private void initViews() {
        title = findViewById(R.id.simple_task_title);
        subTitle = findViewById(R.id.simple_task_subtitle);
        icon = findViewById(R.id.simple_task_icon);
    }

    public void populate(Task task) {
        title.setText(task.getName());
        subTitle.setText(task.getComment());
    }
}
