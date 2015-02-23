package in.suhan.materialdesign;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ssaha8 on 18/02/2015.
 */
public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardAdapterHolder> {
    private Context context;
    private LayoutInflater inflater;
    private List<Data> dataList;

    public CardAdapter(Context context, List<Data> dataList) {
        this.context = context;
        this.dataList = dataList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public CardAdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.card_list_item,parent,false);
        return new CardAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(CardAdapterHolder holder, int position) {
        Data item = dataList.get(position);
        holder.textView.setText(item.getText());
        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inScaled = false;
        holder.imageView.setImageBitmap(BitmapFactory.decodeResource(context.getResources(), item.getImgSrc(), opts));

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class CardAdapterHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView textView;
        public CardAdapterHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.card_img);
            textView = (TextView) itemView.findViewById(R.id.card_txt);
        }
    }
}
