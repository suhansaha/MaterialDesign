package in.suhan.materialdesign;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import in.suhan.materialdesign.SlidingTabLayout.SlidingTabLayout;


public class MainActivity extends ActionBarActivity {
    private SlidingTabLayout mSlidingTabLayout;
    private SlidingAdapter mSlidingAdapter;
    private ViewPager mViewPager;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_appbar);

        toolbar = (Toolbar)findViewById(R.id.appBar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        NavigationDrawyer drawyerFragment = (NavigationDrawyer)
                getSupportFragmentManager().findFragmentById(R.id.app_drawyer);

        drawyerFragment.setUp((DrawerLayout)findViewById(R.id.drawyer_layout), toolbar);

        String [] tabList = getResources().getStringArray(R.array.TabList);

        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mSlidingTabLayout = (SlidingTabLayout) findViewById(R.id.sliding_layout);

        mViewPager.setAdapter(new SlidingAdapter(getSupportFragmentManager(), tabList));
        mSlidingTabLayout.setViewPager(mViewPager);

        mSlidingTabLayout.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.accentColor);
            }

            @Override
            public int getDividerColor(int position) {
                return 0;
            }
        });
        mSlidingTabLayout.setBackgroundColor(getResources().getColor(R.color.primaryColor));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            Toast.makeText(getApplicationContext(),"Hello Settings",Toast.LENGTH_SHORT).show();
            return true;
        }

        if(id == R.id.navigate){
            startActivity(new Intent(this, SubActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
