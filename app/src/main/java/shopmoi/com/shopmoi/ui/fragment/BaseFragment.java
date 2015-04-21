package shopmoi.com.shopmoi.ui.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import shopmoi.com.shopmoi.ui.activity.BaseActivity;

/**
 * Created by machome on 20/04/15.
 */
public abstract class BaseFragment extends Fragment {

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        injectDependencies();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        injectViews(view);
    }

    private void injectDependencies() {
        ((BaseActivity) getActivity()).inject(this);
    }

    private void injectViews(View view) {
        ButterKnife.inject(this, view);
    }
}
