package shopmoi.com.core.presenters;

import shopmoi.com.core.views.SearchView;

/**
 * Created by machome on 20/04/15.
 */
public abstract class  SearchPresenter extends Presenter<SearchView>{

    public static final String SEARCH ="search";
    public static final String WISH_LIST = "wishlist";


    protected String currentSearch;

    public abstract void loadContext(String contextTag);

    public abstract void clearUserSettings();

    public String getCurrentSearch() {
        return currentSearch;
    }
}
