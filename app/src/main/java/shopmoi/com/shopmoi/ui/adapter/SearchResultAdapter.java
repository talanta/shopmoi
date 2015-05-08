package shopmoi.com.shopmoi.ui.adapter;

import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import org.w3c.dom.Text;

import java.util.Collections;
import java.util.List;

import shopmoi.com.core.repository.model.Product;
import shopmoi.com.shopmoi.R;
import shopmoi.com.shopmoi.views.OutlineContainer;

/**
 * Created by machome on 03/05/15.
 */
public class SearchResultAdapter extends PagerAdapter {

    private List<Product> products = Collections.emptyList();

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {

        if (!(view instanceof OutlineContainer))
            return view == o;
        return ((OutlineContainer) view).getChildAt(0) == o;
    }

    public void updateProducts(List<Product> list) {
        products = list;
        notifyDataSetChanged();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        View view = getView(inflater, container, position);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    protected View getView(LayoutInflater inflater, ViewGroup container, int position) {
        View root = inflater.inflate(R.layout.item_pager, null);

        Product item = products.get(position);
        TextView name = (TextView) root.findViewById(R.id.txt_name);
        TextView price = (TextView) root.findViewById(R.id.txt_price);
        SimpleDraweeView pic = (SimpleDraweeView) root.findViewById(R.id.product_picture);

        pic.setImageURI(Uri.parse(item.getMainImageUrl()));
        name.setText(item.getName());
        price.setText(""+ item.getBestOffer().getSalePrice());

        return root;
    }
}
