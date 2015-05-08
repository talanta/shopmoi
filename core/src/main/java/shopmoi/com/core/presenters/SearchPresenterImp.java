package shopmoi.com.core.presenters;

import java.util.ArrayList;
import java.util.List;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import shopmoi.com.core.di.Navigator;
import shopmoi.com.core.repository.AppSettings;
import shopmoi.com.core.repository.ShopApi;
import shopmoi.com.core.repository.model.Pagination;
import shopmoi.com.core.repository.model.Product;
import shopmoi.com.core.repository.model.SearchDetails;
import shopmoi.com.core.repository.model.SearchRequest;
import shopmoi.com.core.repository.model.SearchResult;
import shopmoi.com.core.views.SearchResultPart;

/**
 * Created by machome on 20/04/15.
 */
public class SearchPresenterImp extends SearchPresenter {

    private final List<Product> searchProducts;
    private final List<Product> lovedProducts;

    private final AppSettings appSettings;
    private final Navigator navigator;
    private ShopApi api;
    private Observer<SearchResult> searchResultObserver;
    private Subscription searchSubscription;
    private SearchResultPart searchResultPart;

    public SearchPresenterImp(Navigator navigator, AppSettings settings, ShopApi api) {
        this.navigator = navigator;
        this.searchProducts = new ArrayList<>();
        this.lovedProducts = new ArrayList<>();
        this.api = api;
        this.appSettings = settings;

    }



    @Override
    public void initialize() {
        currentSearch = appSettings.getMainSearch();
        buildSearchObserver();
        refresh();
    }

    public void refresh() {
        if (searchSubscription != null) {
            searchSubscription.unsubscribe();
            searchSubscription = null;
        }
        isLoading = true;
        searchSubscription = api.search(buildRequest())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(searchResultObserver);
    }

    private void buildSearchObserver(){
      //  Obser
        searchResultObserver = new Observer<SearchResult>() {
            @Override
            public void onCompleted() {
                isLoading = false;
                searchResultPart.loadingFinish();
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(SearchResult searchResult) {
                products = searchResult.getProducts();
                searchResultPart.loadingFinish();
              //  searchResult.getProducts()
            }
        };
    }

    private SearchRequest buildRequest() {
        SearchDetails details = new SearchDetails();
        Pagination pagination = new Pagination();
        pagination.setItemsPerPage(20);
        pagination.setPageNumber(1);
        details.setKeyword(currentSearch);
        details.setPagination(pagination);

        return new SearchRequest(details);
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

    @Override
    public void clearUserSettings() {
        this.appSettings.clear();
        this.navigator.forceExit();
    }

    @Override
    public void attachSearchResultPart(SearchResultPart part) {
        searchResultPart = part;
    }

    @Override
    public void detachSearchResultPart() {
        searchResultPart = null;
    }
}
