package shopmoi.com.core.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import shopmoi.com.core.presenters.DetailsPresenter;
import shopmoi.com.core.presenters.DetailsPresenterImp;
import shopmoi.com.core.presenters.LandingPresenter;
import shopmoi.com.core.presenters.LandingPresenterImp;
import shopmoi.com.core.presenters.SearchPresenter;
import shopmoi.com.core.presenters.SearchPresenterImp;
import shopmoi.com.core.repository.AppSettings;
import shopmoi.com.core.repository.ShopApi;

/**
 * Created by machome on 20/04/15.
 */
@Module(
        complete = false,
        library = true
)
public class PresenterModule {

        @Provides
        @Singleton
        protected LandingPresenter providesLandingPresenter(AppSettings appSettings, Navigator navigator) {
                return  new LandingPresenterImp(appSettings, navigator);
        }
        @Provides
        @Singleton
        protected SearchPresenter providesSearchPresenter(Navigator navigator, AppSettings settings, ShopApi api) {
                return  new SearchPresenterImp(navigator, settings, api);
        }

        @Provides
        @Singleton
        protected DetailsPresenter providesDetailsPresenter() {
                return  new DetailsPresenterImp();
        }
}
