package com.example.anime;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<ModelClass> list;
    private Context context;
    private RequestOptions options;

    public MyAdapter(List<ModelClass> list, Context context) {
        this.list = list;
        this.context = context;
        options = new RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cardview, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        myViewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, secondActivity.class);
                context.startActivity(intent);
            }
        });
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ModelClass modelClass = list.get(position);
        Glide.with(context).load(list.get(position).getImage()).apply(options).into(holder.imageViewHolder);
        holder.headlineHolder.setText(modelClass.getHeadline());
        holder.studioHolder.setText(modelClass.getStudio());
        holder.categoryHolder.setText(modelClass.getCategory());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewHolder;
        TextView headlineHolder, categoryHolder, studioHolder;
        LinearLayout linearLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.edtCardLinearLayout);
            imageViewHolder = itemView.findViewById(R.id.edtCardImageView);
            headlineHolder = itemView.findViewById(R.id.edtCardHeadline);
            categoryHolder = itemView.findViewById(R.id.edtCardCategory);
            studioHolder = itemView.findViewById(R.id.edtCardStudioName);
        }
    }
}
