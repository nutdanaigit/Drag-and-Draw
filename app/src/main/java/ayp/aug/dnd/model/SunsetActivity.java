package ayp.aug.dnd.model;

import android.support.v4.app.Fragment;

import ayp.aug.dnd.SunsetFragment;
import ayp.aug.dnd.model.SingleFragmentActivity;

/**
 * Created by Nutdanai on 9/1/2016.
 */
public class SunsetActivity extends SingleFragmentActivity {
    @Override
    protected Fragment onCreateFragment() {
        return SunsetFragment.newInstance();
    }
}
