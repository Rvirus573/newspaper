package com.example.rezaul.newspaper;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, Home.GoToNationalNewsPaper,
        Home.GoTOEnglishNewsPaper, Home.GoToOnlinelNewsPaper, Home.GoToLocallNewsPaper,Home.GoToWebView, NewspaperAdapter.GoToWebViewFragment,InternationalNewspaper.GoToInternational
                {

    private FragmentManager manager;

    private TabLayout tabLayout;
    private ViewPager viewPager;

    public  Menu pinMenuItem;


   // private WebViewFragment webViewFragment;


    public void visibleFBMenu(boolean isVisible)
    {
     pinMenuItem.findItem(R.id.forward_id).setVisible(isVisible);
     pinMenuItem.findItem(R.id.backward_id).setVisible(isVisible);
     pinMenuItem.findItem(R.id.refreshtmenu_id).setVisible(isVisible);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //tab & viewpager

        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.icon1).setText("Bangla"));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.icon1).setText("English"));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.icon1).setText("Online"));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.icon1).setText("Local"));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.icon1).setText("International"));
        tabLayout.setSelectedTabIndicatorColor(Color.WHITE);
        tabLayout.setTabTextColors(Color.WHITE, Color.YELLOW);

        TabPagerAdapter tabPagerAdapter =
                new TabPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(tabPagerAdapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        //tab & viewpager Close




        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

      //  homeFragment();

       // splashFragment();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

     /*   final ActionBar ab = getSupportActionBar();
        if (ab != null)
        {
            ab.setDisplayHomeAsUpEnabled(false);
        }*/

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



    }




    class TabPagerAdapter extends FragmentPagerAdapter {
        private int tabCount;
        public TabPagerAdapter(FragmentManager fm, int tabCount) {
            super(fm);
            this.tabCount = tabCount;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                   // getSupportActionBar().setTitle("Bangla Newspaper");

                 return  new NationalBanglaNewspaper() ;

                case 1:
                  //  getSupportActionBar().setTitle("English Newspaper");

                    return  new EnglishNewsPaper() ;

                case 2:
                  //  getSupportActionBar().setTitle("Online Newspaper");
                    return  new OnlineNewspaper() ;

                    case 3:
                    //    getSupportActionBar().setTitle("Local Newspaper");
                        return  new LocalNewsPaper() ;

                        case 4:
                         //   getSupportActionBar().setTitle("International Newspaper");
                    return  new InternationalNewspaper() ;


            }
            return null;
        }

        @Override
        public int getCount()
        {

            return tabCount;
        }
    }


    @Override
    public void onBackPressed() {


            WebViewFragment fragment = (WebViewFragment)
                    getSupportFragmentManager().findFragmentById(R.id.fragmentContainer);
        if (fragment.getWebView().canGoBack())
        {

            fragment.getWebView().goBack();
        }
        else {
            exitAPP();
        }



        }



    @Override
                public boolean onCreateOptionsMenu(Menu menu) {
                    // Inflate the menu; this adds items to the action bar if it is present.
                    getMenuInflater().inflate(R.menu.main, menu);
                    pinMenuItem = menu;

        visibleFBMenu(false);
                    return true;
                }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();



        //noinspection SimplifiableIfStatement
        if (id == R.id.refreshtmenu_id) {

            WebViewFragment fragment = (WebViewFragment)
                    getSupportFragmentManager().findFragmentById(R.id.fragmentContainer);

            fragment.getWebView().reload();


            Toast.makeText(this, "Reafresh", Toast.LENGTH_SHORT).show();

                   } else if (id == R.id.rateit_menu_id) {
            Toast.makeText(this, "Rate it", Toast.LENGTH_SHORT).show();
            return true;
        }

        else if (id == R.id.exitmenu_id) {
            exitAPP();
        }
        else if (id == R.id.backward_id) {
            WebViewFragment fragment = (WebViewFragment)
                    getSupportFragmentManager().findFragmentById(R.id.fragmentContainer);
            if (fragment.getWebView().canGoBack())
            {
                fragment.getWebView().goBack();



            }
            else {

                onNavigationItemSelected(item);
            }

            Toast.makeText(this, " Back", Toast.LENGTH_SHORT).show();
            return true;
        }
         else if (id == R.id.forward_id) {
            WebViewFragment fragment1 = (WebViewFragment)
                    getSupportFragmentManager().findFragmentById(R.id.fragmentContainer);

            if (fragment1.getWebView().canGoForward()) {
                fragment1.getWebView().goForward();
            } /*
            else {
                super.onBackPressed();
            }
            */

            Toast.makeText(this, " forward", Toast.LENGTH_SHORT).show();
            return true;
        }





        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        try{removeAllFragments(getSupportFragmentManager());}
        catch(Exception e){}

        if (id == R.id.national_News_id) {
             viewPager.setCurrentItem(0);
        } else if (id == R.id.english_news_id) {
          ///  Toast.makeText(this, "dfdsffsfds", Toast.LENGTH_SHORT).show();
           viewPager.setCurrentItem(1);
        } else if (id == R.id.online_news_id) {
           viewPager.setCurrentItem(2);
        } else if (id == R.id.local_news_id) {
            viewPager.setCurrentItem(3);
        }else if (id == R.id.international_news_id) {
            viewPager.setCurrentItem(4);
        } else if (id == R.id.rate_id) {

        } else if (id == R.id.exit_id) {
            exitAPP();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


                    private  void removeAllFragments(FragmentManager fragmentManager) {
                        WebViewFragment fragment = (WebViewFragment)
                              fragmentManager.findFragmentById(R.id.fragmentContainer);

                        if(fragment!=null){

                            fragmentManager.beginTransaction().remove(fragment).commit();

                            tabLayout.setVisibility(View.VISIBLE);
                            visibleFBMenu(false);

                        }




                    }


    @Override
    public void OnNationalNews() {
        manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        NationalBanglaNewspaper nationalBanglaNewspaper = new NationalBanglaNewspaper();
        ft.replace(R.id.fragmentContainer, nationalBanglaNewspaper);
     //   getSupportActionBar().setTitle("National Bangla Newspaper");
        ft.addToBackStack(null);
getSupportActionBar().show();
        ft.commit();
}



    @Override
    public void OnEnglishNews() {
        manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        EnglishNewsPaper englishNewsPaper = new EnglishNewsPaper();
        ft.replace(R.id.fragmentContainer, englishNewsPaper);
     //   getSupportActionBar().setTitle("English Newspaper");
        ft.addToBackStack(null);
        ft.commit();

    }

    @Override
    public void OnOnlinelNews() {
        manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        OnlineNewspaper onlineNewspaper = new OnlineNewspaper();
        ft.replace(R.id.fragmentContainer, onlineNewspaper);
     //   getSupportActionBar().setTitle("Online Newspaper");
        ft.addToBackStack(null);
        ft.commit();

    }

    @Override
    public void OnLocalNews() {
        manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        LocalNewsPaper localNewsPaper = new LocalNewsPaper();
        ft.replace(R.id.fragmentContainer, localNewsPaper);
      //  getSupportActionBar().setTitle("Local Newspaper");
        ft.addToBackStack(null);
        ft.commit();

    }

    @Override
    public void OnInternational() {
        manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        InternationalNewspaper internationalNewspaper = new InternationalNewspaper();
        ft.replace(R.id.fragmentContainer, internationalNewspaper);
      //  getSupportActionBar().setTitle("International Newspaper");
        ft.addToBackStack(null);
        ft.commit();

    }




    @Override
    public void OnWebView() {
        manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        WebViewFragment webViewFragment = new WebViewFragment();
        ft.replace(R.id.fragmentContainer, webViewFragment);

        getSupportActionBar().setTitle("Website");
       // ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public void OnWebViewFragment(Fragment fragment) {
        manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.replace(R.id.fragmentContainer, fragment);
        getSupportActionBar().setTitle("       Newspaper");
     //   getSupportActionBar()..setDrawerIndicatorEnabled(false);
        tabLayout.setVisibility(View.GONE);


      //  ft.addToBackStack(null);
        ft.commit();
    }



    private void exitAPP() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Exit Application?");
        alertDialogBuilder
                .setMessage("Click yes to exit!")
                .setCancelable(false)
                .setPositiveButton("Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                moveTaskToBack(true);
                                android.os.Process.killProcess(android.os.Process.myPid());
                                System.exit(1);
                            }
                        })

                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

                    interface DrawerLocker{
                        public void setDrawerLocked(boolean shouldLock);
                    }

}
