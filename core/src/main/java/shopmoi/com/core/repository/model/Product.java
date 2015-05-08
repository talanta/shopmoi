package shopmoi.com.core.repository.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by machome on 21/04/15.
 */
public class Product {

    @SerializedName("Name")
    private String name;
    @SerializedName("Brand")
    private String brand;
    @SerializedName("Description")
    private String description;
    @SerializedName("Id")
    private String id;
    @SerializedName("MainImageUrl")
    private String mainImageUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMainImageUrl() {
        return mainImageUrl;
    }

    public void setMainImageUrl(String mainImageUrl) {
        this.mainImageUrl = mainImageUrl;
    }
}
