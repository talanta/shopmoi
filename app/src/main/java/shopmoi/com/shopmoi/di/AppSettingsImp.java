package shopmoi.com.shopmoi.di;

import android.content.SharedPreferences;

import shopmoi.com.core.repository.AppSettings;
import shopmoi.com.shopmoi.BuildConfig;

/**
 * Created by machome on 20/04/15.
 */
public class AppSettingsImp implements AppSettings {

    private static final String FIRST_LAUNCH = "FIRST_LAUNCH";
    private static final String MAIN_SEARCH = "MAIN_SEARCH";

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
        return preferences.getBoolean(FIRST_LAUNCH, true);
    }

    @Override
    public void setMainSearch(String search) {

        preferences.edit().putBoolean(FIRST_LAUNCH, false).commit();
        preferences.edit().putString(MAIN_SEARCH, search).commit();
    }

    @Override
    public String getMainSearch() {
        return preferences.getString(MAIN_SEARCH, "oooo");
    }


    @Override
    public void clear() {
        preferences.edit().clear().commit();
    }
}
