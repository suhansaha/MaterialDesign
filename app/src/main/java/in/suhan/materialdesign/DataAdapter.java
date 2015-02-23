package in.suhan.materialdesign;


import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

/**
 * Created by suhan on 16/02/15.
 */
public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    List<Data> data = Collections.emptyList();

    public DataAdapter(Context context, List<Data> data){
        inflater = LayoutInflater.from(context);
        this.data = data;
        this.context = context;
    }
    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.drawer_list_item, viewGroup, false);
        DataViewHolder holder = new DataViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(DataViewHolder dataViewHolder, int i) {
        Data curr = data.get(i);
        dataViewHolder.textView.setText(curr.getTitle());
        dataViewHolder.imageView.setImageResource(curr.getIconId());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void deleteData(int position){
        data.remove(position);
        notifyItemRemoved(position);
    }

    class DataViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imageView;
        TextView textView;
        public DataViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.listIcon);
            textView = (TextView) itemView.findViewById(R.id.listText);
            imageView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText( context, "Deleting item "+getPosition(), Toast.LENGTH_SHORT).show();
            deleteData(getPosition());
        }
    }
}
