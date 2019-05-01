package com.example.rezaul.newspaper;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment {

    private AppCompatButton nationalNewsBtn,englishNewsBtn,onlineNewsBtn,localNewsBtn;
    private Context context;
    private GoToNationalNewsPaper listenerNational;
    private GoTOEnglishNewsPaper listenerEnglish;
    private GoToOnlinelNewsPaper listenerOnline;
    private GoToLocallNewsPaper listenerLocal;
    private GoToWebView listenerWebview;

    private Button button;


    public Home() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;
        listenerNational = (GoToNationalNewsPaper) context;
        listenerEnglish= (GoTOEnglishNewsPaper) context;
        listenerOnline= (GoToOnlinelNewsPaper) context;
        listenerLocal= (GoToLocallNewsPaper) context;
        listenerWebview= (GoToWebView) context;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);

        nationalNewsBtn=view.findViewById(R.id.national_News_BTN_id);
        englishNewsBtn=view.findViewById(R.id.english_News_BTN_id);
        onlineNewsBtn=view.findViewById(R.id.online_News_BTN_id);
        localNewsBtn=view.findViewById(R.id.local_News_BTN_id);



        button=view.findViewById(R.id.webview_BTN_id);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listenerWebview.OnWebView();
            }
        });






        national_News_BTN_Listener();
        english_News_BTN_Listener();
        online_News_BTN_Listener();
        local_News_BTN_Listener();


        return view;
    }


    private void national_News_BTN_Listener()
    {

        nationalNewsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                listenerNational.OnNationalNews();
            }
        });

    }

   private void english_News_BTN_Listener()
    {

        englishNewsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              listenerEnglish.OnEnglishNews();
            }
        });

    }

   private void online_News_BTN_Listener()
    {

        onlineNewsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             listenerOnline.OnOnlinelNews();
            }
        });

    }

   private void local_News_BTN_Listener()
    {

        localNewsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              listenerLocal.OnLocalNews();
            }
        });

    }


    interface GoToNationalNewsPaper
    {
        void OnNationalNews();
    }

      interface GoTOEnglishNewsPaper
    {
        void OnEnglishNews();
    }

      interface GoToOnlinelNewsPaper
    {
        void OnOnlinelNews();
    }

      interface GoToLocallNewsPaper
    {
        void OnLocalNews();
    }

    interface GoToWebView
    {
        void OnWebView();
    }




}
