package ayp.aug.dnd;

import android.graphics.PointF;

/**
 * Created by Nutdanai on 8/30/2016.
 */
public class Box {
    PointF mStart;
    PointF mEnd;

    public PointF getStart() {return mStart;}
    public PointF getEnd() {return mEnd;}

    public void setStart(PointF mStart) {this.mStart = mStart;}
    public void setEnd(PointF mEnd) {this.mEnd = mEnd;}
}
