package com.example.instaclone;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instaclone.data.PostItem;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PostListAdapter extends RecyclerView.Adapter<PostListAdapter.ViewHolder> {
    private List<PostItem> postList;



    public PostListAdapter(List<PostItem>list){
        this.postList=list;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(parent.getContext());
        View ListItem =inflater.inflate(R.layout.item_news,parent,false);
        ViewHolder viewHolder = new ViewHolder(ListItem);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final PostItem item = postList.get(position);
        holder.comment_text.setText("View all "+ item.getCommentCount()+ "comments");
        holder.like_text.setText(item.getLikeCount()+"Likes");
        holder.description_text.setText(item.getUserName()+ " "+ item.getDescription());
        holder.profile_text.setText(item.getUserName());
        Picasso.with(holder.itemView.getContext()).load(item.getProfileImage()).into(holder.profile_image);
        Picasso.with(holder.itemView.getContext()).load(item.getPostImage()).into(holder.main_image);


    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView profile_image;
        public ImageView main_image;
        public TextView like_text;
        public TextView description_text;
        public TextView comment_text;
        public TextView profile_text;

        public ViewHolder(View itemView){
            super(itemView);
            this.profile_image=(ImageView) itemView.findViewById(R.id.profile_image);
            this.main_image=(ImageView) itemView.findViewById(R.id.main_image);
            this.like_text=(TextView) itemView.findViewById(R.id.like_text);
            this.description_text=(TextView) itemView.findViewById(R.id.decription_text);
            this.comment_text=(TextView) itemView.findViewById(R.id.comment_text);
            this.profile_text=(TextView) itemView.findViewById(R.id.profile_text);


        }



    }
}
