package shopmoi.com.shopmoi.ui.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;
import shopmoi.com.core.presenters.SearchPresenter;
import shopmoi.com.core.views.SearchResultPart;
import shopmoi.com.shopmoi.R;
import shopmoi.com.shopmoi.ui.adapter.SearchResultAdapter;
import shopmoi.com.shopmoi.views.JazzyViewPager;

/**
 * Created by machome on 20/04/15.
 */
public class SearchFragment extends BaseFragment implements SearchResultPart {

    private ProgressDialog progress;
    @Bind(R.id.pager)
    protected JazzyViewPager pager;
    @Bind(R.id.search_view)
    protected SearchView searchView;
    @Inject
    protected SearchPresenter presenter;

//    @Bind(R.id.fab_refresh)
//    FloatingActionButton fabRefresh;
    @Bind(R.id.fab_love)
    FloatingActionButton fabLove;
    @Bind(R.id.txt_price)
    TextView txtPrice;


    protected SearchResultAdapter adapter = new SearchResultAdapter();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        progress = new ProgressDialog(getActivity());
        progress.setIndeterminate(true);


        fabLove.setImageDrawable(new IconicsDrawable(getActivity(),
                FontAwesome.Icon.faw_heart).colorRes(android.R.color.white));
//        fabRefresh.setImageDrawable(new IconicsDrawable(getActivity(),
//                GoogleMaterial.Icon.gmd_refresh).colorRes(android.R.color.white));

        initPager();
        initSearch();
        initLoad();
    }


    protected void initLoad() {
        if (presenter.getIsLoading()) {
            progress.show();
            return;
        }
        adapter.updateProducts(presenter.getProducts());
        // pager.setCurrentItem(presenter.getSelectedItem());
    }

    protected void initPager() {
        pager.setTransitionEffect(JazzyViewPager.TransitionEffect.Stack);
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                presenter.setSelectedItem(position);
                updateCurrentItem();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        pager.setAdapter(adapter);
    }

    protected void initSearch() {
        searchView.setQuery(presenter.getCurrentSearch(), false);
        //searchView.onActionViewExpanded();
        searchView.setIconifiedByDefault(false);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        MenuItem actionItem = menu.add(0, R.id.menu_clear, 0, "clear");
        actionItem.setIcon(android.R.drawable.ic_menu_info_details);
        MenuItemCompat.setShowAsAction(actionItem, MenuItemCompat.SHOW_AS_ACTION_NEVER);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_clear) {

            presenter.clearUserSettings();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.attachSearchResultPart(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.detachSearchResultPart();
    }

    @Override
    public void loadingFinish() {
        // load result..
        progress.dismiss();
        adapter.updateProducts(presenter.getProducts());
        updateCurrentItem();
    }

//    @OnClick(R.id.fab_refresh)
//    protected void onRefresh() {
//        presenter.refresh();
//        if (presenter.getIsLoading()) {
//            progress.show();
//        }
//    }

    @OnClick(R.id.btn_info)
    protected void onInfo() {
        presenter.requestInfo();
    }


    protected void updateCurrentItem() {
        txtPrice.setText(presenter.getSelectedItem().getBestOffer().getSalePrice() + " €");
    }

}
