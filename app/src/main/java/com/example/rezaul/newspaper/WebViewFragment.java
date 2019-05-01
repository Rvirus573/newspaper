package com.example.rezaul.newspaper;


import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuBuilder;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import android.widget.Toolbar;


/**
 * A simple {@link Fragment} subclass.
 */
public class WebViewFragment extends Fragment {

    private WebView webView;
    private Context context;
    String link;
    private Toolbar toolbarTab;
   // private TabLayout tabLayout;
    private FragmentManager manager;
    public  Menu pinMenuItem;

    public WebViewFragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;


    }




    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_web_view, container, false);


        webView = view.findViewById(R.id.webView_id);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());

       /* ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setIcon(R.drawable.home_icon);
*/





        Bundle bundle = this.getArguments();
        if (bundle != null) {
            link= bundle.getString("link");
          String  name= bundle.getString("name").trim();

            Toast.makeText(getContext(), name, Toast.LENGTH_LONG).show();
        }


        webView.loadUrl(link);



        Activity obj = (MainActivity) getActivity();

        ((MainActivity) obj).visibleFBMenu(true);
        webViewClient.onPageStarted(webView,link,null);

        return view;
    }


    private WebViewClient webViewClient = new WebViewClient(){


        @Override
        public void doUpdateVisitedHistory(WebView view, String url, boolean isReload) {

            String title = view.getTitle();//getTitle
            super.doUpdateVisitedHistory(view, url, isReload);
            ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(title);
        }

    };





    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        pinMenuItem = menu;

    }



    public boolean canGoBack() {
        return webView.canGoBack();
    }

    public void goBack() {
        webView.goBack();
    }


    public WebView getWebView()
    {
        return webView;
    }

    public WebViewFragment webViewFragment(){

        return this;
    }
}


