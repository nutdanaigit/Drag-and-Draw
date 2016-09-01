package ayp.aug.dnd;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Nutdanai on 8/30/2016.
 */
public class DragAndDrawFragment extends Fragment {

    public static DragAndDrawFragment newInstance() {

        Bundle args = new Bundle();
        DragAndDrawFragment fragment = new DragAndDrawFragment();
        fragment.setArguments(args);
        return fragment;
    }

    ///////
    BoxDrawingView mBoxDrawing;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_point_finger, container, false);
//        mBoxDrawing = (BoxDrawingView) v.findViewById(R.id.box_drawing_view);
        return v;
    }
}
