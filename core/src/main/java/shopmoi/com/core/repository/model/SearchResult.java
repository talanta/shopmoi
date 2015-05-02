package shopmoi.com.core.repository.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by machome on 20/04/15.
 */
public class SearchResult {

    @SerializedName("ItemCount")
    private int itemCount;
    @SerializedName("PageCount")
    private int pageCount;
    @SerializedName("PageNumber")
    private int pageNumber;
    @SerializedName("Products")
    private List<Product> products;

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
