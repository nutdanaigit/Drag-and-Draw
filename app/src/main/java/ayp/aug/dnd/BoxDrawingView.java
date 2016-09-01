package ayp.aug.dnd;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nutdanai on 8/30/2016.
 */
public class BoxDrawingView extends View {
    private static final String TAG = "BoxDrawingView";

    private Box mCurrentBox;
    private List<Box> mBowList = new ArrayList<>();
    private Paint mBackgroudPaint;
    private Paint mBoxPaint;


    public BoxDrawingView(Context context) {
        this(context, null);
    }

    public BoxDrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mBoxPaint = new Paint();
        mBoxPaint.setColor(0x22ff0000);

        mBackgroudPaint = new Paint();
        mBackgroudPaint.setColor(0xfff8efe0);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        //Canvas ผ้าใบ ถุงวาดภาพ
        canvas.drawPaint(mBackgroudPaint);
        for (Box box : mBowList) {
            float left = Math.min(box.getStart().x, box.getEnd().x);
            float top = Math.min(box.getStart().y, box.getEnd().y);
            float right = Math.max(box.getStart().x, box.getEnd().x);
            float bottom = Math.max(box.getStart().y, box.getEnd().y);

            canvas.drawRect(left, top, right, bottom, mBoxPaint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        PointF currentPoint = new PointF(event.getX(), event.getY());
        String action = "NO";
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE: //กำลังกดแล้วเคลื่อนที่
                action = "ACTION_MOVE";
                if (mCurrentBox != null) {
                    mCurrentBox.setEnd(currentPoint);
                    invalidate(); //force to validate สั่งให้วาด view ตัวเองใหม่
                    logBox(mCurrentBox);
                }
                break;
            case MotionEvent.ACTION_DOWN: //กด touch
                action = "ACTION_DOWN";
                mCurrentBox = new Box();
                mCurrentBox.setStart(currentPoint);
                mBowList.add(mCurrentBox);
                break;
            case MotionEvent.ACTION_UP:
                action = "ACTION_UP";
                mCurrentBox = null;
                break;
            case MotionEvent.ACTION_CANCEL:
                action = "ACTION_CANCEL";
                mCurrentBox = null;
                break;
        }
        Log.i(TAG, "Action = " + action + ",at XY = " + currentPoint.x + "," + currentPoint.y);
        return true;
    }

    private void logBox(Box box) {
        if (box != null) {
            Log.d(TAG, "CurrentBox: "
                    + box.toString()
                    + ", Start = " + box.getStart()
                    + ", end = " + box.getEnd());
        }

    }
}
