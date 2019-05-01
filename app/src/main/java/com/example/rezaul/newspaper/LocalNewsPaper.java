package com.example.rezaul.newspaper;


import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class LocalNewsPaper extends Fragment {

    private Context context;
    private Spinner spinner;

    private RecyclerView rv;
    private NewspaperAdapter adapter;
    private List<Newspaper_Info> newspaper_infos = new ArrayList<>();
    private LinearLayoutManager layoutManager;
    private GridLayoutManager gridLayoutManager;
    private StaggeredGridLayoutManager sglm;

    public LocalNewsPaper() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_local_news_paper, container, false);


        rv = view.findViewById(R.id.local_RV_id);

     /*   newspaper_infos.add(new Newspaper_Info(R.drawable.news,"reza"));
        newspaper_infos.add(new Newspaper_Info(R.drawable.news_logo," Hasan"));*/
        spinner = view.findViewById(R.id.spinner_id);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {

                    case 0:
                        Toast.makeText(getContext(), "Please Select Your Region", Toast.LENGTH_SHORT).show();
                        break;


                    case 1:
                        newspaper_infos.clear();
                        int size1 = context.getResources().getStringArray(R.array.local_comilla_name).length;
                        final TypedArray testArrayIcon1 = getResources().obtainTypedArray(R.array.local_comilla_logo);
                        String[] name1 = context.getResources().getStringArray(R.array.local_comilla_name);
                        String[] link1 = context.getResources().getStringArray(R.array.local_comilla_link);

                        for (int i = 0; i < size1; i++) {

                            newspaper_infos.add(new Newspaper_Info(testArrayIcon1.getResourceId(i, -1), name1[i], link1[i]));

                        }
                        recycleviewShow();
                        Toast.makeText(getContext(), "Comilla", Toast.LENGTH_SHORT).show();
                        break;


                        case 2:
                        newspaper_infos.clear();
                        int size2 = context.getResources().getStringArray(R.array.local_sylhet_name).length;
                        final TypedArray testArrayIcon2 = getResources().obtainTypedArray(R.array.local_sylhet_logo);
                        String[] name2 = context.getResources().getStringArray(R.array.local_sylhet_name);
                        String[] link2 = context.getResources().getStringArray(R.array.local_sylhet_link);

                        for (int i = 0; i < size2; i++) {

                            newspaper_infos.add(new Newspaper_Info(testArrayIcon2.getResourceId(i, -1), name2[i], link2[i]));

                        }
                        recycleviewShow();
                        Toast.makeText(getContext(), "Sylhet", Toast.LENGTH_SHORT).show();
                        break;


                        case 3:
                        newspaper_infos.clear();
                        int size3 = context.getResources().getStringArray(R.array.local_rajshahi_name).length;
                        final TypedArray testArrayIcon3 = getResources().obtainTypedArray(R.array.local_rajshahi_logo);
                        String[] name3 = context.getResources().getStringArray(R.array.local_rajshahi_name);
                        String[] link3= context.getResources().getStringArray(R.array.local_rajshahi_link);

                        for (int i = 0; i < size3; i++) {
                            newspaper_infos.add(new Newspaper_Info(testArrayIcon3.getResourceId(i, -1), name3[i], link3[i]));
                        }
                        recycleviewShow();
                        Toast.makeText(getContext(), "Rajshahi", Toast.LENGTH_SHORT).show();
                        break;


                        case 4:
                        newspaper_infos.clear();
                        int size4 = context.getResources().getStringArray(R.array.local_khulna_name).length;
                        final TypedArray testArrayIcon4 = getResources().obtainTypedArray(R.array.local_khulna_logo);
                        String[] name4 = context.getResources().getStringArray(R.array.local_khulna_name);
                        String[] link4 = context.getResources().getStringArray(R.array.local_khulna_link);

                        for (int i = 0; i < size4; i++) {
                            newspaper_infos.add(new Newspaper_Info(testArrayIcon4.getResourceId(i, -1), name4[i], link4[i]));
                        }
                        recycleviewShow();
                        Toast.makeText(getContext(), "Khulna", Toast.LENGTH_SHORT).show();
                        break;


                        case 5:
                        newspaper_infos.clear();
                        int size5 = context.getResources().getStringArray(R.array.local_barisal_name).length;
                        final TypedArray testArrayIcon5 = getResources().obtainTypedArray(R.array.local_barisal_logo);
                        String[] name5 = context.getResources().getStringArray(R.array.local_barisal_name);
                        String[] link5 = context.getResources().getStringArray(R.array.local_barisal_link);

                        for (int i = 0; i < size5; i++) {
                            newspaper_infos.add(new Newspaper_Info(testArrayIcon5.getResourceId(i, -1), name5[i], link5[i]));
                        }
                        recycleviewShow();
                        Toast.makeText(getContext(), "Barishal", Toast.LENGTH_SHORT).show();
                        break;

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //  recycleviewShow();


        return view;
    }

    private void recycleviewShow() {

        layoutManager = new LinearLayoutManager(getContext());
        gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        sglm = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        adapter = new NewspaperAdapter(getActivity(), newspaper_infos);
        rv.setLayoutManager(sglm);
        rv.setAdapter(adapter);
    }


}
