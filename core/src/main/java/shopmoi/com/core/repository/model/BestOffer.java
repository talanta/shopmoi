package shopmoi.com.core.repository.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * Created by machome on 08/05/15.
 */
@Parcel
public class BestOffer {

    @SerializedName("Id")
    private String id;
    @SerializedName("IsAvailable")
    private boolean isAvailable;
    @SerializedName("SalePrice")
    private float salePrice;
    @SerializedName("ProductURL")
    private String productURL;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public float getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(float salePrice) {
        this.salePrice = salePrice;
    }

    public String getProductURL() {
        return productURL;
    }

    public void setProductURL(String productURL) {
        this.productURL = productURL;
    }
}
