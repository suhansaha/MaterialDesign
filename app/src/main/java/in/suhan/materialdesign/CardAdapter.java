package in.suhan.materialdesign;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by suhan on 17/02/15.
 */
public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardAdapterHolder> {
    private Context context;
    private LayoutInflater inflater;
    private List<Data> dataList = Collections.emptyList();

    public CardAdapter(Context context, List<Data> dataList) {
        inflater = LayoutInflater.from(context);
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public CardAdapterHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.card_list_item, viewGroup, false);
        return new CardAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(CardAdapterHolder viewHolder, int position) {
        Data item = dataList.get(position);
        viewHolder.textView.setText(item.getText());
        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inScaled = false;
        Resources res = context.getResources();
        viewHolder.imageView.setImageBitmap( BitmapFactory.decodeResource(res, item.getImgSrc(), opts));
                
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
