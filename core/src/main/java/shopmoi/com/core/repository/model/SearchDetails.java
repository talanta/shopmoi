package shopmoi.com.core.repository.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by machome on 02/05/15.
 */
public class SearchDetails {

    @SerializedName("Pagination")
    private Pagination pagination;
    @SerializedName("Keyword")
    private String keyword;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }
}
