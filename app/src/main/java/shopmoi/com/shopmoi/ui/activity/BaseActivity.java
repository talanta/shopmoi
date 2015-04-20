package shopmoi.com.shopmoi.ui.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import dagger.ObjectGraph;
import shopmoi.com.shopmoi.di.ActivityModule;
import shopmoi.com.shopmoi.di.ShopApp;

/**
 * Created by machome on 20/04/15.
 */
public abstract class BaseActivity extends ActionBarActivity {

    private ObjectGraph activityScopeGraph;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        injectDependencies();
        injectViews();
    }

    public void inject(Object entityToGetInjected) {
        activityScopeGraph.inject(entityToGetInjected);
    }

    private void injectDependencies() {

        ShopApp app = ((ShopApp) getApplicationContext());
        List<Object> activityScopeModules = (getModules() != null) ? getModules() : new ArrayList<>();
        activityScopeModules.add(new ActivityModule(this));
        activityScopeGraph = app.buildGraphWithAditionalModules(activityScopeModules);
        inject(this);
    }
    private void injectViews() {
        ButterKnife.inject(this);
    }

    protected abstract List<Object> getModules();

}
