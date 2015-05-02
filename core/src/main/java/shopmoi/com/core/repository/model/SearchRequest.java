package shopmoi.com.core.repository.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by machome on 20/04/15.
 */
public class SearchRequest {

    @SerializedName("ApiKey")
    private String apiKey;
    @SerializedName("SearchRequest")
    private SearchDetails searchRequest;

    public SearchRequest(){
    }

    public SearchRequest(SearchDetails details) {
        apiKey = "88d0a923-abe4-44c0-849b-bf93cf7dacfe";
        searchRequest = details;
    }


    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public SearchDetails getSearchRequest() {
        return searchRequest;
    }

    public void setSearchRequest(SearchDetails searchRequest) {
        this.searchRequest = searchRequest;
    }
}
