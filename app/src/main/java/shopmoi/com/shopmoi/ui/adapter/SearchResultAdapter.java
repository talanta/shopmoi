package shopmoi.com.shopmoi.ui.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Collections;
import java.util.List;

import shopmoi.com.core.repository.model.Product;
import shopmoi.com.shopmoi.R;

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
        return false;
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
        //super.destroyItem(container, position, object);
    }

    protected View getView(LayoutInflater inflater, ViewGroup container, int position) {
        View root = inflater.inflate(R.layout.item_pager, null);

        Product item = products.get(position);
        TextView name = (TextView)root.findViewById(R.id.txt_name);
        name.setText(item.getName());

        return root;
    }
}
