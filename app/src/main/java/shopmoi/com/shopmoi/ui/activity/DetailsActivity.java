package shopmoi.com.shopmoi.ui.activity;

import android.os.Bundle;

import org.parceler.Parcels;

import java.util.List;

import javax.inject.Inject;

import shopmoi.com.core.presenters.DetailsPresenter;
import shopmoi.com.core.repository.model.Product;
import shopmoi.com.core.views.DetailsView;
import shopmoi.com.shopmoi.R;

/**
 * Created by machome on 20/04/15.
 */
public class DetailsActivity extends BaseActivity implements DetailsView {

    public static final String EXTRA = "extra";
    @Inject
    protected DetailsPresenter presenter;

    @Override
    public int getLayoutResourceId() { return R.layout.activity_details; }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.initPresenter();
    }

    protected void initPresenter() {
        Product item = Parcels.unwrap(getIntent().getExtras().getParcelable(EXTRA));
        this.presenter.setView(this);
        this.presenter.setProduct(item);
        this.presenter.initialize();
    }

    @Override
    protected List<Object> getModules() {
        return null;
    }
}
