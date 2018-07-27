package com.holy.interestingdemo.tabItem;

import android.app.FragmentManager;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.LinearLayout;

import com.holy.interestingdemo.R;
import com.holy.interestingdemo.mainInfo.BaseActivity;
import com.holy.interestingdemo.tabItem.fragments.FindFragment;
import com.holy.interestingdemo.tabItem.fragments.HomeFragment;
import com.holy.interestingdemo.tabItem.fragments.MineFragment;
import com.holy.interestingdemo.tabItem.fragments.mine.dummy.DummyContent;

public class TabViewActivity extends BaseActivity implements MineFragment.OnListFragmentInteractionListener {

    private LinearLayout background;
    private BottomNavigationView navigation;
    private FragmentManager fragmentManager;
    private Fragment[] fragments;
    private HomeFragment homeFragment;
    private FindFragment findFragment;
    private MineFragment mineFragment;
    private int lastShowFragment = 0;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                if (lastShowFragment != 0){
                    switchFragment(lastShowFragment,0);
                    lastShowFragment = 0;
                }
                return true;
            case R.id.navigation_dashboard:
                if (lastShowFragment != 1){
                    switchFragment(lastShowFragment,1);
                    lastShowFragment = 1;
                }
                return true;
            case R.id.navigation_notifications:
                if (lastShowFragment != 2){
                    switchFragment(lastShowFragment,2);
                    lastShowFragment = 2;
                }
                return true;
        }
        return false;
    };


    @Override
    public void toSetContentView() {
        setContentView(R.layout.activity_tab_view);
    }

    @Override
    public void initViews() {
        background = findViewById(R.id.info_layout);
        navigation = findViewById(R.id.navigation);
    }

    @Override
    public void setListener() {
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }


    @Override
    public void doSth() {
        initFragments();
    }

    private void initFragments() {
        homeFragment = HomeFragment.newInstance("10", "1");
        findFragment = FindFragment.newInstance("", "");
        mineFragment = MineFragment.newInstance(1);
        fragments = new Fragment[]{homeFragment,findFragment,mineFragment};
        lastShowFragment = 0;

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.info_layout, homeFragment)
                .show(homeFragment)
                .commit();

    }

    public void switchFragment(int lastIndex, int index) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.hide(fragments[lastIndex]);
        if (!fragments[index].isAdded()) {
            transaction.add(R.id.info_layout, fragments[index]);
        }
        transaction.show(fragments[index]).commitAllowingStateLoss();
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {
        switch (item.position){
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }
}
