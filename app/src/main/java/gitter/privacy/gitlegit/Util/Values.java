package gitter.privacy.gitlegit.Util;

import android.content.Context;

/**
 * Created by jahmale_c on 21/06/2017.
 */

public class Values {

    public static float pixelsToSp(Context context, float px) {
        float scaledDensity = context.getResources().getDisplayMetrics().scaledDensity;
        return px/scaledDensity;
    }

}
