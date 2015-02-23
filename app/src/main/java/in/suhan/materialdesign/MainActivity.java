package in.suhan.materialdesign;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.v7.widget.Toolbar;
import android.view.ViewAnimationUtils;

import java.util.ArrayList;
import java.util.List;

import in.suhan.materialdesign.SlidingTabLayout.SlidingTabLayout;


public class MainActivity extends ActionBarActivity {
    private Toolbar toolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private ViewPager mViewPager;
    private SlidingTabLayout mSlidingTabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // enable transitions
        //getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar,R.string.drawer_open,R.string.drawer_closed){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        final List<SlidePagerItem> mtabs = new ArrayList<SlidePagerItem>();
        mtabs.add(new SlidePagerItem("Tab 1", Color.BLUE, Color.GRAY));
        mtabs.add(new SlidePagerItem("Tab 2", Color.RED, Color.GRAY));
        mtabs.add(new SlidePagerItem("Tab 3", Color.YELLOW, Color.GRAY));

        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(new SlidePagerAdapter(getSupportFragmentManager()));

        mSlidingTabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tabs);
        mSlidingTabLayout.setViewPager(mViewPager);

        mSlidingTabLayout.setCustomTabColorizer(new SlidingTabLayout.TabColorizer(){
            @Override
            public int getIndicatorColor(int position) {
                return mtabs.get(position%3).getIndicatorColor();
            }

            @Override
            public int getDividerColor(int position) {
                return 0;
            }

        });

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
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
            Log.d("MaterialDesign", "Settings Button clicked");
            return true;
        }
        if(id == R.id.navigate){
            Log.d("MaterialDesign", "Navigate Button clicked");
            Intent intent = new Intent(this, SecondScreen.class);
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
        }

        return super.onOptionsItemSelected(item);
    }

    public void onSomeButtonClicked(View view) {
        Log.d("MaterialDesign", "Button Clicked!");
    }

    private boolean viewState = true;
    public void revealView(View v){
        Log.d("MaterialAnimationLog","ButtonClicked");
        Animator anim;
        final View view = findViewById(R.id.card_view);

        int cx = (view.getLeft()+view.getRight())/2;
        int cy = (view.getTop()+view.getBottom())/2;

        int finalRadius = Math.max(view.getWidth(), view.getHeight());

        if(viewState) {
            anim = ViewAnimationUtils.createCircularReveal(view, cx, cy, finalRadius, 0);

            anim.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    view.setVisibility(View.INVISIBLE);
                }
            });

            viewState = false;
        }else {
            anim = ViewAnimationUtils.createCircularReveal(view, cx, cy, 0, finalRadius);
            view.setVisibility(View.VISIBLE);
            viewState = true;
        }
        anim.start();
    }
}
