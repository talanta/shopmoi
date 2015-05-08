package shopmoi.com.core.di;

import shopmoi.com.core.repository.model.Product;

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

    void navigateToDetails(Product product);

    void forceExit();
}
