package shopmoi.com.shopmoi.ui.activity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import javax.inject.Inject;

import shopmoi.com.core.presenter.LandingPresenter;
import shopmoi.com.core.view.LandingView;
import shopmoi.com.shopmoi.R;


public class LandingActivity extends BaseActivity implements LandingView{

    @Inject
    protected LandingPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
    }

    @Override
    protected List<Object> getModules() {
        return null;
    }
}
