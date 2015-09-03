package shopmoi.com.shopmoi.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rey.material.widget.Button;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import shopmoi.com.shopmoi.R;

/**
 * Created by machome on 22/04/15.
 */
public class LandingHelpAdapter extends RecyclerView.Adapter<LandingHelpAdapter.SearchItemHolder> {

    private final List<String> items = new ArrayList<String>();
    private OnSearchItemClickListener listener;

    public LandingHelpAdapter(String[] help) {

        for (int i = 0; i < help.length; i++) {
            items.add(help[i]);
        }
    }

    public void setOnSearchItemClickListener(OnSearchItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public LandingHelpAdapter.SearchItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View modelView = inflater.inflate(R.layout.item_landing_search,
                parent, false);
        return new SearchItemHolder(modelView);
    }

    @Override
    public void onBindViewHolder(LandingHelpAdapter.SearchItemHolder holder, int position) {
        final String itm = items.get(position);
        holder.itemBtn.setText(itm);

        holder.itemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener == null)
                    return;
                listener.onSelected(itm);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public interface OnSearchItemClickListener {

        void onSelected(String item);
    }

    public class SearchItemHolder extends BaseViewHolder {

        @Bind(R.id.itemBtn)
        protected Button itemBtn;

        public SearchItemHolder(View itemView) {
            super(itemView);
        }
    }
}
