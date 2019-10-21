package com.example.mehndidesignapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mehndidesignapp.Model.MehndiImages;
import com.example.mehndidesignapp.ViewHolder.ImagesViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class ArmsFragment extends Fragment {

    // Recycler View code
    private DatabaseReference arms_imagesRef;
    private RecyclerView arms_recyclerView;
    RecyclerView.LayoutManager arms_layoutManager;

    public ArmsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_arms, container, false);

        arms_imagesRef = FirebaseDatabase.getInstance().getReference().child("arms");
        // to retrieve text in app offline
        arms_imagesRef.keepSynced(true);


        // Recycler View code
        arms_recyclerView = view.findViewById(R.id.mehndi_recycler_images);
        arms_recyclerView.setHasFixedSize(true);
        arms_layoutManager = new GridLayoutManager(getContext(), 3);
        arms_recyclerView.setLayoutManager(arms_layoutManager);


        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        FirebaseRecyclerOptions<MehndiImages> options =
                new FirebaseRecyclerOptions.Builder<MehndiImages>()
                        .setQuery(arms_imagesRef, MehndiImages.class)
                        .build();

        FirebaseRecyclerAdapter<MehndiImages, ImagesViewHolder> adapter =
                new FirebaseRecyclerAdapter<MehndiImages, ImagesViewHolder>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull final ImagesViewHolder holder, final int position, @NonNull final MehndiImages model) {

                        //Picasso.get().load(model.getG_image()).into(holder.imageView1);
                        // to retrieve image in app offline
                        Picasso.get().load(model.getImage()).networkPolicy(NetworkPolicy.OFFLINE).into(holder.imageView, new Callback() {
                            @Override
                            public void onSuccess() {

                            }

                            @Override
                            public void onError(Exception e) {

                                Picasso.get().load(model.getImage()).into(holder.imageView);
                            }
                        });

                        // set click Listener
                        holder.itemView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                Intent intent = new Intent(getActivity(), ImageViewActivity.class);
                                intent.putExtra("mhndi_img_url", model.getImage());
                                startActivity(intent);

                            }
                        });
                    }


                    @NonNull
                    @Override
                    public ImagesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
                        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mehndi_image_layout, parent, false);
                        ImagesViewHolder holder = new ImagesViewHolder(view);
                        return holder;
                    }
                };
        arms_recyclerView.setAdapter(adapter);
        adapter.startListening();
    }
}
