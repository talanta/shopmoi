package shopmoi.com.shopmoi.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.MenuItemCompat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import shopmoi.com.core.presenters.SearchPresenter;
import shopmoi.com.shopmoi.R;

/**
 * Created by machome on 20/04/15.
 */
public class SearchFragment extends BaseFragment {

    @Inject
    protected SearchPresenter presenter;


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
        initPager();
    }

    protected void initPager(){
        // get search from bundle...
        // then...
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
}
