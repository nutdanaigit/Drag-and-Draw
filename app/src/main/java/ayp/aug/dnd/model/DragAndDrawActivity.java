package ayp.aug.dnd.model;

import android.support.v4.app.Fragment;

import ayp.aug.dnd.DragAndDrawFragment;

/**
 * Created by Nutdanai on 8/30/2016.
 */
public class DragAndDrawActivity extends SingleFragmentActivity {

    @Override
    protected Fragment onCreateFragment() {
        return DragAndDrawFragment.newInstance();
    }
}
