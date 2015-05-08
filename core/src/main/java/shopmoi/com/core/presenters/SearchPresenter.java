package shopmoi.com.core.presenters;

import java.util.List;

import shopmoi.com.core.repository.model.Product;
import shopmoi.com.core.views.SearchResultPart;
import shopmoi.com.core.views.SearchView;

/**
 * Created by machome on 20/04/15.
 */
public abstract class  SearchPresenter extends Presenter<SearchView>{

    protected int selectedItem;
    protected List<Product> products;
    protected boolean isLoading;
    public static final String SEARCH ="search";
    public static final String WISH_LIST = "wishlist";


    protected String currentSearch;

    public abstract void requestInfo();

    public abstract void refresh();

    public abstract void loadContext(String contextTag);

    public abstract void clearUserSettings();

    public boolean getIsLoading() {
        return isLoading;
    }


    public String getCurrentSearch() {
        return currentSearch;
    }

    public List<Product> getProducts(){
        return products;
    }

    public abstract void attachSearchResultPart(SearchResultPart part);

    public abstract void detachSearchResultPart();

    public int getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(int selectedItem) {
        this.selectedItem = selectedItem;
    }
}
