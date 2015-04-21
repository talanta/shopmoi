package shopmoi.com.core.presenters;

import java.util.ArrayList;
import java.util.List;

import shopmoi.com.core.di.Navigator;
import shopmoi.com.core.repository.ShopApi;
import shopmoi.com.core.repository.model.Product;

/**
 * Created by machome on 20/04/15.
 */
public class SearchPresenterImp extends SearchPresenter {

    private final List<Product> searchProducts;
    private final List<Product> lovedProducts;

    private final Navigator navigator;
    private ShopApi api;

    public SearchPresenterImp(Navigator navigator, ShopApi api) {
        this.navigator = navigator;
        this.searchProducts = new ArrayList<>();
        this.lovedProducts = new ArrayList<>();
        this.api = api;

    }
    @Override
    public void initialize() {
        // load observers...
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void loadContext(String contextTag) {

        switch (contextTag) {
            case SEARCH:
                if (searchProducts.isEmpty()) {
                    // perform search
                }
                navigator.navigateToSearchResults();
                break;
            case WISH_LIST:

                if (lovedProducts.isEmpty()) {
                    // perform loading of saved products.
                }

                navigator.navigateToWishList();
                break;
        }


    }
}
