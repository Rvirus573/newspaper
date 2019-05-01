package com.example.rezaul.newspaper;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class NewspaperAdapter extends RecyclerView.Adapter<NewspaperAdapter.NewspaperViewHolder> {


    private Context context;
    private GoToWebViewFragment listenerWebview;
    private List<Newspaper_Info> newspaper_info;





    public NewspaperAdapter(Context context, List<Newspaper_Info> newspaper_info) {
        this.context = context;
        this.newspaper_info = newspaper_info;
        listenerWebview= (GoToWebViewFragment) context;
    }




    @NonNull
    @Override
    public NewspaperViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

       View view = LayoutInflater.from(context).inflate(R.layout.newspaper_row, viewGroup, false);


        return new NewspaperViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull NewspaperViewHolder holder,final int position) {

      /*  Drawable d = context.getResources().getDrawable(newspaper_info.get(position).getPic());
        holder.imageView.setImageDrawable(d);*/
        holder.imageView.setImageResource(newspaper_info.get(position).getPic());
        holder.nameTV.setText(newspaper_info.get(position).getName());
      //  holder.nameTV.setText(String.valueOf(newspaper_info.get(position).getPic()));

       // String link= newspaper_info.get(position).getLink();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name= newspaper_info.get(position).getName();
                String link= newspaper_info.get(position).getLink();
                WebViewFragment webViewFragment = new WebViewFragment();
                Bundle bundle = new Bundle();
                bundle.putString("name",name);
                bundle.putString("link",link);
                webViewFragment.setArguments(bundle);

                listenerWebview.OnWebViewFragment(webViewFragment);


              //  Toast.makeText(context, "pos: "+position, Toast.LENGTH_SHORT).show();
               // Toast.makeText(context, "Link: "+link, Toast.LENGTH_SHORT).show();


            }
        });


    }



    @Override
    public int getItemCount() {
        return newspaper_info.size();
    }


    public void updateList(List<Newspaper_Info> newspaper_info){

        this.newspaper_info = newspaper_info;
        notifyDataSetChanged();
    }



    class NewspaperViewHolder extends RecyclerView.ViewHolder{

         TextView nameTV;
       ImageView imageView;

        public NewspaperViewHolder(@NonNull View itemView)
        {
            super(itemView);
            nameTV=(TextView) itemView.findViewById(R.id.name_id);
            imageView= (ImageView) itemView.findViewById(R.id.image_id);

        }
    }



    interface GoToWebViewFragment
    {

        void OnWebViewFragment(Fragment fragment);

    }



}
