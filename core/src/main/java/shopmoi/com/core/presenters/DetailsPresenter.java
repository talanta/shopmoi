package shopmoi.com.core.presenters;

import shopmoi.com.core.repository.model.Product;
import shopmoi.com.core.views.DetailsView;

/**
 * Created by machome on 20/04/15.
 */
public abstract class  DetailsPresenter extends Presenter<DetailsView> {

    protected Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
