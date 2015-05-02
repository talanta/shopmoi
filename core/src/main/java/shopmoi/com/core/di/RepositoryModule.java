package shopmoi.com.core.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.android.AndroidLog;
import shopmoi.com.core.repository.AppSettings;

/**
 * Created by machome on 20/04/15.
 */
@Module(
        complete = false,
        library = true
)
public class RepositoryModule {


        @Provides
        @Singleton
        RestAdapter provideRestAdapter(AppSettings appSettings) {

                String endpoint = appSettings.getApiEndpoint();

                RestAdapter adapter = new RestAdapter.Builder()
                        .setEndpoint(endpoint)
                        .setLogLevel(RestAdapter.LogLevel.FULL)
                        .setLog(new AndroidLog("Retrofit"))
                        .build();
                return adapter;
        }
}
