package in.suhan.materialdesign;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;


public class SecondScreen extends ActionBarActivity {
    private CardAdapter mCardAdapter;
    private RecyclerView mRecyclerView;

    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mRecyclerView = (RecyclerView) findViewById(R.id.card_list);
        mCardAdapter = new CardAdapter(this, getData());
        mRecyclerView.setAdapter(mCardAdapter);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private List<Data> getData(){
        List<Data> dataList = new ArrayList<Data>();
        String[] txt = {"Snowy Bridge", "Sunrise","Sunset","Christmas Market","Roses"};
        int[] pic = {R.drawable.photo1, R.drawable.photo2, R.drawable.photo3, R.drawable.photo4, R.drawable.photo5};

        for(int i = 0; i < 5 ; i++){
            Data item = new  Data();
            item.setImgSrc(pic[i]);
            item.setText(txt[i]);
            dataList.add(item);
        }
        return dataList;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
