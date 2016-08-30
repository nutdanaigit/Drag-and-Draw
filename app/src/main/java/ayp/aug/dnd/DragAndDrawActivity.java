package ayp.aug.dnd;

import android.support.v4.app.Fragment;

/**
 * Created by Nutdanai on 8/30/2016.
 */
public class DragAndDrawActivity extends SingleFragmentActivity {

    @Override
    protected Fragment onCreateFragment() {
        return DragAndDrawFragment.newInstance();
    }
}
