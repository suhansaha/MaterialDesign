package in.suhan.materialdesign;


import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataAdapterHolder> {
    private Context context;
    private LayoutInflater inflater;
    private List<Data> data = Collections.emptyList();

    public DataAdapter(Context context, List<Data> data){
        inflater = LayoutInflater.from(context);
        this.data = data;
        this.context = context;
    }
    @Override
    public DataAdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.drawyer_list_item,parent,false);
        DataAdapterHolder dataAdapterHolder = new DataAdapterHolder(view);
        //Log.d("materialDesign", "OnCreateViewHolder");
        return dataAdapterHolder;
    }

    @Override
    public void onBindViewHolder(DataAdapterHolder holder, int position) {
        holder.textView.setText(data.get(position).getText());
        holder.imageView.setImageResource(data.get(position).getImgSrc());
        //Log.d("materialDesign", "OnBindViewHolder");
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void deleteData(int position){
        data.remove(position);
        notifyItemRemoved(position);
    }

    public class DataAdapterHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView imageView;
        private ImageView imageViewDelete;
        private TextView textView;
        public DataAdapterHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            textView = (TextView) itemView.findViewById(R.id.textView);
            imageViewDelete = (ImageView) itemView.findViewById(R.id.imageViewDelete);
            imageViewDelete.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText( context, "Deleting item "+getPosition(), Toast.LENGTH_SHORT).show();
            deleteData(getPosition());
        }
    }
}
