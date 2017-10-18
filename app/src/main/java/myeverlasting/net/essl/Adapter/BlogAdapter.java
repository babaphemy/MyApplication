package myeverlasting.net.essl.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import myeverlasting.net.essl.AblogActivity;
import myeverlasting.net.essl.model.Blog;
import myeverlasting.net.essl.R;

/**
 * Created by babafemi on 10/10/2017.
 */

public class BlogAdapter extends RecyclerView.Adapter<BlogAdapter.BlogHolder> {
    private static String LOG_TAG="BlogAdapter";
    private static ArrayList<Blog> blogs;
    private static blogClickListener blogClickListener;
    private Context mcontext;

    public static class BlogHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView title,intro;
        ImageView thumb;


        public BlogHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.txtBlogTitle);
            intro = (TextView) itemView.findViewById(R.id.txtBlogIntro);
            thumb = (ImageView) itemView.findViewById(R.id.blogImg);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.i(LOG_TAG, "row clicked!");
                    Intent in = new Intent(view.getContext(), AblogActivity.class);
                    Bundle bb = new Bundle();
                    bb.putString("blog",blogs.get(getAdapterPosition()).getTitle());
                    bb.putString("bfile", blogs.get(getAdapterPosition()).getFile());
                    bb.putString("btext", blogs.get(getAdapterPosition()).getMessage());
                    in.putExtras(bb);
                    view.getContext().startActivity(in);
                }
            });
        }

        @Override
        public void onClick(View view) {
            blogClickListener.onItemClick(getAdapterPosition(), view);
            Log.i(LOG_TAG,getAdapterPosition() + " blog item clicked!!!!");


        }
    }

    public BlogAdapter(Context mcontext, ArrayList<Blog> bls) {
        this.mcontext = mcontext;
        blogs = bls;
    }

    @Override
    public BlogHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.blog_item,parent,false);
        BlogHolder bh = new BlogHolder(view);
        return bh;
    }

    @Override
    public void onBindViewHolder(BlogHolder holder, int position) {
        holder.title.setText(blogs.get(position).getTitle());
        holder.intro.setText(blogs.get(position).getIntro());
        Glide.with(mcontext).load(blogs.get(position).getFile()).into(holder.thumb);


    }

    @Override
    public int getItemCount() {
        return blogs.size();
    }



    public interface blogClickListener{
        public void onItemClick(int position, View v);

    }
}
