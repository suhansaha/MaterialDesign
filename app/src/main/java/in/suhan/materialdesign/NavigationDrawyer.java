package in.suhan.materialdesign;


import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class NavigationDrawyer extends Fragment {
    private RecyclerView recyclerView;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private DataAdapter dataAdapter;

    public NavigationDrawyer() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_navigation_drawyer, container, false);
        recyclerView = (RecyclerView) layout.findViewById(R.id.drawerList);
        dataAdapter = new DataAdapter(getActivity(),getData());
        recyclerView.setAdapter(dataAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        // Inflate the layout for this fragment
        return layout;
    }

    public static List<Data> getData(){
        List<Data> data = new ArrayList<Data>();
        int[] icon = {R.drawable.ic_next_icon,R.drawable.ic_next_icon,R.drawable.ic_next_icon,R.drawable.ic_next_icon};
        String [] text = {"Menu 1", "Menu 2", "Menu 3", "Menu 4"};

        for (int i = 0; i < 100; i++) {
            Data item = new Data();
            item.setTitle(text[ i % icon.length ]);
            item.setIconId(icon[ i % text.length ]);
            data.add(item);
        }

        return data;
    }

    public void setUp(DrawerLayout drawerLayout, final Toolbar toolBar) {
        mDrawerLayout = drawerLayout;
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(),mDrawerLayout, toolBar, R.string.drawyer_open, R.string.drawyer_close){

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                if(slideOffset<0.6){
                    toolBar.setAlpha(1-slideOffset);
                }
                super.onDrawerSlide(drawerView, slideOffset);
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });

    }
}
