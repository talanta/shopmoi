package shopmoi.com.shopmoi.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import java.util.List;

import javax.inject.Inject;

import butterknife.InjectView;
import shopmoi.com.core.presenters.SearchPresenter;
import shopmoi.com.core.views.SearchView;
import shopmoi.com.shopmoi.R;

/**
 * Created by machome on 20/04/15.
 */
public class SearchActivity extends BaseActivity implements SearchView, NavigationHandler {

    @Inject
    protected SearchPresenter presenter;


    @Override
    public int getLayoutResourceId() { return R.layout.activity_search; }

    @Override
    protected int getToolbarResourceId() {
        return R.id.toolbar;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.initPresenter();
        if (null == savedInstanceState) {
            presenter.loadContext(SearchPresenter.SEARCH);
        }
    }

    protected void initPresenter() {
        this.presenter.setView(this);
        this.presenter.initialize();
    }

    @Override
    protected List<Object> getModules() {
        return null;
    }

    @Override
    public int getFragmentContainerResId() {
        return R.id.container;
    }
}
