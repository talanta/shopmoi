package shopmoi.com.core.presenters;

import shopmoi.com.core.di.Navigator;
import shopmoi.com.core.repository.AppSettings;

/**
 * Created by machome on 20/04/15.
 */
public class LandingPresenterImp extends LandingPresenter {

    private final int LANDING_DELAY = 1000;
    private final int NO_DELAY = 0;

    private final AppSettings appSettings;
    private final Navigator navigator;

    public LandingPresenterImp(AppSettings appSettings, Navigator nav) {
        this.appSettings = appSettings;
        this.navigator = nav;
    }


    @Override
    public void initialize() {
        if (!appSettings.isFirstLaunch()) {

            this.navigator.navigateToSearchWithDelay(LANDING_DELAY);
            return;
        }
        this.view.loadLandingAnimation();
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void performFirstSearch(String input) {
        appSettings.setMainSearch(input);
        this.navigator.navigateToSearchWithDelay(NO_DELAY);
    }
}
