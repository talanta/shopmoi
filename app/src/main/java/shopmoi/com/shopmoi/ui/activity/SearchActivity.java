package shopmoi.com.shopmoi.ui.activity;

import java.util.List;

import javax.inject.Inject;

import shopmoi.com.core.presenter.LandingPresenter;
import shopmoi.com.core.presenter.SearchPresenter;
import shopmoi.com.core.view.SearchView;

/**
 * Created by machome on 20/04/15.
 */
public class SearchActivity extends BaseActivity implements SearchView {

    @Inject
    protected SearchPresenter presenter;

    @Override
    protected List<Object> getModules() {
        return null;
    }
}
