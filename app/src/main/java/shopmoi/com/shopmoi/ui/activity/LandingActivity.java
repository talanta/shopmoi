package shopmoi.com.shopmoi.ui.activity;

import android.os.Bundle;

import java.util.List;

import javax.inject.Inject;

import shopmoi.com.core.presenters.LandingPresenter;
import shopmoi.com.core.views.LandingView;
import shopmoi.com.shopmoi.R;


public class LandingActivity extends BaseActivity implements LandingView{

    @Inject
    protected LandingPresenter presenter;

    @Override
    public int getLayoutResourceId() {
        return R.layout.activity_landing;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initPresenter();
    }

    protected void initPresenter() {
        presenter.setView(this);
        presenter.initialize();
    }
    @Override
    protected List<Object> getModules() {
        return null;
    }

    @Override
    public void loadLandingAnimation() {

    }
}
