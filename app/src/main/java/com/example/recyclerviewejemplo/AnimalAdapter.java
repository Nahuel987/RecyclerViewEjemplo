package com.example.recyclerviewejemplo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.recyclerviewejemplo.model.Animal;

import java.util.ArrayList;
import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.ViewHolder> {


    private LayoutInflater mLayoutInflater;
    private List<Animal> animalList =new ArrayList<>();
    private Context mContext;
    private AdapterView.OnItemClickListener listener;

    public AnimalAdapter(List<Animal> animalList, Context mContext) {
        this.animalList = animalList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        //View view= mLayoutInflater.inflate(R.layout.item_list_animal,parent,false);

        View view= mLayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_animal,parent,false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Animal animal =animalList.get(position);
        holder.textView.setText(animal.getName());

        Glide.with(holder.imageView.getContext())
                .load(animal.getUrl())      //obtiene url
                .centerCrop()               //centra la imagen
                .into(holder.imageView);    //donde se muestra la imagen
    }

    @Override
    public int getItemCount() {
        return animalList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private  ImageView imageView;
        private  TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

             imageView=itemView.findViewById(R.id.imageViewListItem);
             textView=itemView.findViewById(R.id.textViewListItem);

        }



    }//class view holder




}//class animal adapter



