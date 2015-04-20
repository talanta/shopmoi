package shopmoi.com.shopmoi.di;

import android.content.SharedPreferences;

import shopmoi.com.core.repository.AppSettings;
import shopmoi.com.shopmoi.BuildConfig;

/**
 * Created by machome on 20/04/15.
 */
public class AppSettingsImp implements AppSettings {

    private final SharedPreferences preferences;

    public AppSettingsImp(SharedPreferences preferences) {
        this.preferences = preferences;
    }
    @Override
    public String getApiEndpoint() {
        return BuildConfig.API_HOST;
    }

    @Override
    public boolean isFirstLaunch() {
        return false;
    }
}
