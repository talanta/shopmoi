package shopmoi.com.core.di;

/**
 * Created by machome on 20/04/15.
 */
public interface Navigator {

    /*
    DELAY = 0 (infinite)
     */
    void navigateToSearchWithDelay(int delay);

    void navigateToSearchResults();

    void navigateToWishList();

    void forceExit();
}
