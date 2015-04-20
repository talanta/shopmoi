package shopmoi.com.shopmoi.ui.activity;

import java.util.List;

import javax.inject.Inject;

import shopmoi.com.core.presenter.DetailsPresenter;
import shopmoi.com.core.presenter.LandingPresenter;
import shopmoi.com.core.view.DetailsView;

/**
 * Created by machome on 20/04/15.
 */
public class DetailsActivity extends BaseActivity implements DetailsView {

    @Inject
    protected DetailsPresenter presenter;


    @Override
    protected List<Object> getModules() {
        return null;
    }
}
