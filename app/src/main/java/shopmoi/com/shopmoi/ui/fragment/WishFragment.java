package shopmoi.com.shopmoi.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import javax.inject.Inject;

import shopmoi.com.core.presenters.SearchPresenter;
import shopmoi.com.shopmoi.R;

/**
 * Created by machome on 20/04/15.
 */
public class WishFragment extends BaseFragment {

    @Inject
    protected SearchPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_wishlist, container, false);
    }
}
