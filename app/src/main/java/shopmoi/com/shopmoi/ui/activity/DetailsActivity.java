package shopmoi.com.shopmoi.ui.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;

import org.parceler.Parcels;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
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
    @Bind(R.id.backdrop)
    protected SimpleDraweeView backdrop;
    @Bind(R.id.txt_description)
    protected TextView txtDescription;
    @Bind(R.id.collapsing_toolbar)
    protected CollapsingToolbarLayout collapsingToolbar;

    @Bind(R.id.btn_cart)
    protected FloatingActionButton btnCart;

    @Override
    protected int getToolbarResourceId() {
        return R.id.toolbar;
    }

    @Override
    public int getLayoutResourceId() { return R.layout.activity_details; }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Product item = Parcels.unwrap(getIntent().getExtras().getParcelable(EXTRA));
        this.initPresenter(item);
        this.initViews(item);
    }

    protected void initPresenter(Product item) {

        this.presenter.setView(this);
        this.presenter.setProduct(item);
        this.presenter.initialize();
    }

    protected void initViews(Product item) {
        backdrop.setImageURI(Uri.parse(item.getMainImageUrl()));
        txtDescription.setText(item.getDescription());
        collapsingToolbar.setTitle(item.getName());
        btnCart.setImageDrawable(new IconicsDrawable(this, FontAwesome.Icon.faw_shopping_cart));
    }

    @Override
    protected List<Object> getModules() {
        return null;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
