package shopmoi.com.core.repository;

import retrofit.http.Body;
import retrofit.http.POST;
import shopmoi.com.core.repository.model.SearchRequest;
import shopmoi.com.core.repository.model.SearchResult;

/**
 * Created by machome on 20/04/15.
 */
public interface ShopApi {

    @POST("/Search")
    SearchResult Search(@Body SearchRequest request);


}
