package shopmoi.com.core.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import shopmoi.com.core.presenter.DetailsPresenter;
import shopmoi.com.core.presenter.DetailsPresenterImp;
import shopmoi.com.core.presenter.LandingPresenter;
import shopmoi.com.core.presenter.LandingPresenterImp;
import shopmoi.com.core.presenter.SearchPresenter;
import shopmoi.com.core.presenter.SearchPresenterImp;

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
        protected LandingPresenter providesLandingPresenter() {
                return  new LandingPresenterImp();
        }
        @Provides
        @Singleton
        protected SearchPresenter providesSearchPresenter() {
                return  new SearchPresenterImp();
        }

        @Provides
        @Singleton
        protected DetailsPresenter providesDetailsPresenter() {
                return  new DetailsPresenterImp();
        }
}
