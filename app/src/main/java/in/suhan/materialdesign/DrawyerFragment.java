package in.suhan.materialdesign;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;


/**
 * A simple {@link Fragment} subclass.
 */
public class DrawyerFragment extends Fragment {
    private DataAdapter adapter;
    private RecyclerView view;
    private RecyclerView.LayoutManager layoutManager;

    public DrawyerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_navigation_drawyer, container, false);
        view = (RecyclerView) layout.findViewById(R.id.drawerList);

        layoutManager = new LinearLayoutManager(getActivity());
        view.setLayoutManager(layoutManager);
        // Inflate the layout for this fragment
        adapter = new DataAdapter(getActivity(), getData());
        view.setAdapter(adapter);

        return layout;
    }

    private List<Data> getData(){
        String[] text = {"Menu 1", "Menu 2","Menu 3","Menu 4"};
        int [] img = {R.drawable.ic_no1_icon, R.drawable.ic_no2_icon, R.drawable.ic_no3_icon, R.drawable.ic_no4_icon};
        List<Data> data = new ArrayList<Data>();

        for(int i = 0 ; i < 8 ; i++){
            Data item = new Data();
            item.setText(text[i % text.length ]);
            item.setImgSrc(img[i % text.length]);
            data.add(item);
        }
        return data;
    }

}
