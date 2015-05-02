package shopmoi.com.core.repository.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by machome on 02/05/15.
 */
public class Pagination {

    @SerializedName("ItemsPerPage")
    private int itemsPerPage;
    @SerializedName("PageNumber")
    private int pageNumber;

    public int getItemsPerPage() {
        return itemsPerPage;
    }

    public void setItemsPerPage(int itemsPerPage) {
        this.itemsPerPage = itemsPerPage;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
}
