package shopmoi.com.core.repository;

/**
 * Created by machome on 20/04/15.
 */
public interface AppSettings {

    String getApiEndpoint();

    boolean isFirstLaunch();
}
