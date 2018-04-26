package nekono.inno.lifetracker.utils;

import android.content.Context;
import android.widget.Toast;

public class Message {

    public void showMessage(Context context, CharSequence text, int duration) {
        Toast.makeText(context, text, duration).show();
    }

}
