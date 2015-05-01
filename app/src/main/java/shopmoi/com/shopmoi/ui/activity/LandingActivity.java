package shopmoi.com.shopmoi.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.otto.Bus;

import java.util.List;

import javax.inject.Inject;

import butterknife.InjectView;
import shopmoi.com.core.presenters.LandingPresenter;
import shopmoi.com.core.views.LandingView;
import shopmoi.com.core.views.View;
import shopmoi.com.shopmoi.R;
import shopmoi.com.shopmoi.ui.adapter.LandingHelpAdapter;


public class LandingActivity extends BaseActivity implements LandingView{

    @InjectView(R.id.headlogo)
    protected ImageView headlogo;
    @InjectView(R.id.inputField)
    protected LinearLayout inputField;
    @InjectView(R.id.itemList)
    protected RecyclerView itemList;


    @Inject
    protected LandingPresenter presenter;

    @Override
    public int getLayoutResourceId() {
        return R.layout.activity_landing;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initLandingHelp();
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

    protected void initLandingHelp(){
        String[] sample = getResources().getStringArray(R.array.sample_search);
        LandingHelpAdapter adapter = new LandingHelpAdapter(sample);
        itemList.setLayoutManager(new StaggeredGridLayoutManager(3, OrientationHelper.HORIZONTAL));
        itemList.setAdapter(adapter);
        adapter.setOnSearchItemClickListener(new LandingHelpAdapter.OnSearchItemClickListener() {
            @Override
            public void onSelected(String item) {
                presenter.performFirstSearch(item);
            }
        });
    }

    @Override
    public void loadLandingAnimation() {

        headlogo.animate()
                .translationYBy(-400)
                .scaleXBy(-0.4f)
                .scaleYBy(-0.4f)
                .setInterpolator(new DecelerateInterpolator())
                .setDuration(1000)
                .setStartDelay(1000).start();

        inputField.animate()
                .alphaBy(1)

                .setInterpolator(new DecelerateInterpolator())
                .setDuration(5000)
                .setStartDelay(2000).start();

    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.destroy();
    }
}
