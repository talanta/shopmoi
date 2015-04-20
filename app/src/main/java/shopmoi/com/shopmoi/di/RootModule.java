package shopmoi.com.shopmoi.di;

import android.content.Context;

import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.ObjectGraph;
import dagger.Provides;
import shopmoi.com.core.di.RepositoryModule;

/**
 * Created by machome on 20/04/15.
 */
@Module(
        includes = { RepositoryModule.class },
        injects = { ShopApp.class },
        library = true
)
public class RootModule {

    private final Context context;

    public RootModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public Bus provideBusEvent() {
        return new Bus();
    }
}
