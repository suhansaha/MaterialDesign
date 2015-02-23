package in.suhan.materialdesign;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


/**
 * Created by ssaha8 on 17/02/2015.
 */
public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataAdapterHolder> {
    private List<Data> data;
    private Context context;

    public DataAdapter(Context context, List<Data> data){
        this.context = context;
        this.data = data;
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
        public void onClick(View v) {
            deleteData(getPosition());
        }
    }
}
