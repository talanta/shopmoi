package shopmoi.com.shopmoi.di;

import android.content.Context;

import shopmoi.com.core.di.ActivityContext;
import shopmoi.com.core.di.Navigator;

/**
 * Created by machome on 20/04/15.
 */
public class NavigatorImp implements Navigator {

    private final Context activityContext;

    public NavigatorImp(@ActivityContext Context activityContext){
        this.activityContext = activityContext;
    }
}
