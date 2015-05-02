package shopmoi.com.shopmoi.utils;

import android.content.res.Resources;
import android.util.TypedValue;

/**
 * Created by machome on 03/05/15.
 */
public class Util {

    public static int dpToPx(Resources res, int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, res.getDisplayMetrics());
    }
}
