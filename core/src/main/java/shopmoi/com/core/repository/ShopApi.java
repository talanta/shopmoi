package shopmoi.com.core.repository;

import retrofit.http.Body;
import retrofit.http.POST;
import rx.Observable;
import shopmoi.com.core.repository.model.ProductRequest;
import shopmoi.com.core.repository.model.ProductResult;
import shopmoi.com.core.repository.model.SearchRequest;
import shopmoi.com.core.repository.model.SearchResult;

/**
 * Created by machome on 20/04/15.
 */
public interface ShopApi {

    @POST("/Search")
    Observable<SearchResult> search(@Body SearchRequest request);

    @POST("/GetProduct")
    Observable<ProductResult> getProduct(@Body ProductRequest request);

}
