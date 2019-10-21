package com.example.mehndidesignapp.ViewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.mehndidesignapp.Interface.ItemClickListener;
import com.example.mehndidesignapp.R;

public class ImagesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public ImageView imageView;
    public ItemClickListener listener;

    public ImagesViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = (ImageView) itemView.findViewById(R.id.mehndi_image1);
    }

    public void setItemClickListener(ItemClickListener listener){
        this.listener = listener;

    }

    @Override
    public void onClick(View v) {
        listener.onClick(v ,getAdapterPosition(), false);
    }
}
