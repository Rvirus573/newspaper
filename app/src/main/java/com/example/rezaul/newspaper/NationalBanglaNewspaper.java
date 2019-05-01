package com.example.rezaul.newspaper;


import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class NationalBanglaNewspaper extends Fragment {
    Toolbar toolbar;
    private Context context;

    private RecyclerView rv;
    private NewspaperAdapter adapter;
    private List<Newspaper_Info> newspaper_infos = new ArrayList<>();
    private LinearLayoutManager layoutManager;
    private GridLayoutManager gridLayoutManager;
    private StaggeredGridLayoutManager sglm;







    public NationalBanglaNewspaper() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_national_bangla_newspaper, container, false);

        rv = view.findViewById(R.id.national_RV_id);

     /*   newspaper_infos.add(new Newspaper_Info(R.drawable.news,"reza"));
        newspaper_infos.add(new Newspaper_Info(R.drawable.news_logo," Hasan"));*/

        int size = context.getResources().getStringArray(R.array.bangla_news_name).length;
        final TypedArray testArrayIcon = getResources().obtainTypedArray(R.array.bangla_news_logo);
        String[] name = context.getResources().getStringArray(R.array.bangla_news_name);
        String[] link = context.getResources().getStringArray(R.array.bangla_news_link);
        newspaper_infos.clear();
        for (int i = 0 ; i<27;i++)
        {

            newspaper_infos.add(new Newspaper_Info(testArrayIcon.getResourceId(i, -1),name[i],link[i]));

        }
//        adapter.updateList(newspaper_infos);





        layoutManager = new LinearLayoutManager(getContext());
        gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        sglm = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        adapter = new NewspaperAdapter(getActivity(), newspaper_infos);
        rv.setLayoutManager(sglm);
        rv.setAdapter(adapter);
     //   rv.clearOnScrollListeners();
     //   rv.setLayoutManager(new LinearLayoutManager(getContext()));





        return view;
    }

}
