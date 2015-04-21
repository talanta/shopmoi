package shopmoi.com.shopmoi.di;

import android.content.Context;
import android.content.SharedPreferences;

import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.ObjectGraph;
import dagger.Provides;
import retrofit.RestAdapter;
import shopmoi.com.core.di.RepositoryModule;
import shopmoi.com.core.repository.AppSettings;
import shopmoi.com.core.repository.ShopApi;

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

    @Provides
    @Singleton
    public AppSettings providesAppSettings() {
        SharedPreferences pref = context.getSharedPreferences("preferences", Context.MODE_PRIVATE);
        return new AppSettingsImp(pref);
    }

    @Provides
    @Singleton
    public ShopApi provedesShopApi(AppSettings appSettings) {

        RestAdapter a = new RestAdapter.Builder()
                .setEndpoint(appSettings.getApiEndpoint())
                .build();

        return  a.create(ShopApi.class);
    }
}
