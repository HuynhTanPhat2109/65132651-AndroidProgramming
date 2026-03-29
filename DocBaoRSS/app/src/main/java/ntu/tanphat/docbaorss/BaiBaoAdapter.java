package ntu.tanphat.docbaorss;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;

import java.util.List;

public class BaiBaoAdapter extends RecyclerView.Adapter<BaiBaoAdapter.ViewHolder> {

    List<BaiBaoItem> list;
    Context context;

    public BaiBaoAdapter(Context context, List<BaiBaoItem> list) {
        this.context = context;
        this.list = list;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView title, date, desc;

        public ViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            title = itemView.findViewById(R.id.title);
            date = itemView.findViewById(R.id.date);
            desc = itemView.findViewById(R.id.desc);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        BaiBaoItem item = list.get(position);

        holder.title.setText(item.title);
        holder.date.setText(item.pubDate);
        holder.desc.setText(item.description);

        Glide.with(context)
                .load(item.getImage())
                .placeholder(R.drawable.rss_tam)
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
