package shopmoi.com.shopmoi.di;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;

import com.mikepenz.iconics.typeface.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;


import java.util.List;

import javax.inject.Inject;

import shopmoi.com.core.di.ActivityContext;
import shopmoi.com.core.di.Navigator;
import shopmoi.com.shopmoi.R;
import shopmoi.com.shopmoi.ui.activity.NavigationHandler;
import shopmoi.com.shopmoi.ui.activity.SearchActivity;
import shopmoi.com.shopmoi.ui.fragment.SearchFragment;
import shopmoi.com.shopmoi.ui.fragment.WishFragment;

/**
 * Created by machome on 20/04/15.
 */
public class NavigatorImp implements Navigator {

    private final Context activityContext;

    @Inject
    public NavigatorImp(@ActivityContext Context activityContext){
        this.activityContext = activityContext;

        if (activityContext instanceof NavigationHandler)
            buildDrawer((NavigationHandler) activityContext);
    }

    @Override
    public void navigateToSearchWithDelay(int delay) {
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            public void run() {

            Intent detailsActivityIntent = new Intent(activityContext, SearchActivity.class);
            ActivityCompat.startActivity((Activity) activityContext, detailsActivityIntent, new Bundle());
            }
        };
        handler.postDelayed(runnable, delay);
    }

    @Override
    public void navigateToSearchResults() {
        if (! (activityContext instanceof NavigationHandler))
            return;
        Fragment frag = Fragment.instantiate(activityContext, SearchFragment.class.getName());
        ((ActionBarActivity) activityContext).getSupportFragmentManager()
                .beginTransaction()
                .replace(((NavigationHandler) activityContext).getFragmentContainerResId(),frag)
                .commit();
    }

    @Override
    public void navigateToWishList() {
        if (! (activityContext instanceof NavigationHandler))
            return;
        Fragment frag = Fragment.instantiate(activityContext, WishFragment.class.getName());
        ((ActionBarActivity) activityContext).getSupportFragmentManager()
        .beginTransaction()
        .replace(((NavigationHandler) activityContext).getFragmentContainerResId(), frag)
        .commit();
    }

    @Override
    public void forceExit() {
        ((Activity)activityContext).finish();
    }

    protected void buildDrawer(NavigationHandler navigationHandler) {
       final Drawer.Result result =  new Drawer((Activity)activityContext)
                .withToolbar(navigationHandler.getToolbar())
                .withHeader(R.layout.part_header)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName(R.string.drawer_home)
                                .withIcon(FontAwesome.Icon.faw_home)
                                .withIdentifier(1),
                        new PrimaryDrawerItem().withName(R.string.drawer_wish)
                                .withIcon(FontAwesome.Icon.faw_heart)
                                .withIdentifier(2))
               .build();

                result.setOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l, IDrawerItem iDrawerItem) {
                        if (result.getCurrentSelection() == iDrawerItem.getIdentifier())
                            return;

                        switch (iDrawerItem.getIdentifier()) {

                            case 1:
                                navigateToSearchResults();
                                break;
                            case 2:
                                navigateToWishList();
                                break;
                        }
                    }
        });

    }
}
