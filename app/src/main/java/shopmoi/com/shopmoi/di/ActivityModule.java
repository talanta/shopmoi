package shopmoi.com.shopmoi.di;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;

import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import shopmoi.com.core.di.ActivityContext;
import shopmoi.com.core.di.Navigator;
import shopmoi.com.core.di.PresenterModule;
import shopmoi.com.shopmoi.ui.activity.DetailsActivity;
import shopmoi.com.shopmoi.ui.activity.LandingActivity;
import shopmoi.com.shopmoi.ui.activity.SearchActivity;
import shopmoi.com.shopmoi.ui.fragment.SearchFragment;
import shopmoi.com.shopmoi.ui.fragment.WishFragment;

/**
 * Created by machome on 20/04/15.
 */
@Module(
        includes = {
                PresenterModule.class,
        },
        injects = {
                LandingActivity.class,
                SearchActivity.class,
                DetailsActivity.class,
                SearchFragment.class,
                WishFragment.class,
        },
        complete = false,
        library = true
)
public class ActivityModule {

    private final ActionBarActivity activityContext;
    public ActivityModule(ActionBarActivity context){
        this.activityContext = context;

    }

    @Provides
    @ActivityContext
    Context provideActivityContext() {
        return activityContext;
    }
    @Provides
    @Singleton
    Navigator providesNavigator() {

        return new NavigatorImp(activityContext);
    }

}
