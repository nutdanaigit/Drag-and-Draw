package ayp.aug.dnd;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;

/**
 * Created by Nutdanai on 9/1/2016.
 */
public class SunsetFragment extends Fragment {
    public static SunsetFragment newInstance() {

        Bundle args = new Bundle();

        SunsetFragment fragment = new SunsetFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private View mSceneView;
    private View mSunView;
    private View mSkyView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sunset,container,false);
        mSceneView =v;
        mSunView = v.findViewById(R.id.sun);
        mSkyView = v.findViewById(R.id.sky);

        mSceneView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startAnimation();
            }
        });
        return v;
    }

    public void startAnimation(){
        float sunYStart = mSunView.getTop();
        float sunHeight = mSunView.getHeight();
        float sunHalfHeight = sunHeight/2;
        float skyYEnd = mSkyView.getHeight();
//        float sunYEnd = skyYEnd - sunHalfHeight; //half sun
        float sunYEnd = skyYEnd;
//        mSunView.setTop();

        //1.
        ObjectAnimator heightAnimator = ObjectAnimator.ofFloat(mSunView,"y",sunYStart,sunYEnd).setDuration(3000);
        heightAnimator.setInterpolator(new AccelerateInterpolator());


        int colorBlueSky = getResources().getColor(R.color.blue_sky);
        int colorSunSetSky = getResources().getColor(R.color.sunset_sky);
        int colorNightSky = getResources().getColor(R.color.night_sky);



        //2.
        ObjectAnimator sunsetAnimator = ObjectAnimator.ofInt(mSkyView,"backgroundColor",colorBlueSky,colorSunSetSky).setDuration(1500);
        sunsetAnimator.setEvaluator(new ArgbEvaluator());


        //3.
        ObjectAnimator nightAnimator;
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            nightAnimator = ObjectAnimator.ofArgb(mSkyView, "backgroundColor", colorSunSetSky, colorNightSky).setDuration(1500);
        }else{
            nightAnimator = ObjectAnimator.ofInt(mSkyView, "backgroundColor", colorSunSetSky, colorNightSky).setDuration(1500);
            nightAnimator.setEvaluator(new ArgbEvaluator());
        }
        AnimatorSet animatorSet = new AnimatorSet();

        //2.2
        ObjectAnimator biggerXSunAnimation = ObjectAnimator.ofFloat(mSunView,"scaleX",1f,1.5f).setDuration(3000);
        ObjectAnimator biggerYSunAnimation = ObjectAnimator.ofFloat(mSunView,"scaleY",1f,1.5f).setDuration(3000);

        animatorSet.play(heightAnimator)
                .with(biggerXSunAnimation)
                .with(biggerYSunAnimation)
                .with(sunsetAnimator)
                .before(nightAnimator);
        animatorSet.start();

//        sunsetAnimator.start();
//        heightAnimator.start();
//        nightAnimator.start();

    }
}
