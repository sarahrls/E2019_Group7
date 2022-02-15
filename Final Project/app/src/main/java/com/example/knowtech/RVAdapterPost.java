package com.example.knowtech;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class RVAdapterPost extends RecyclerView.Adapter<RVAdapterPost.ViewHolder> {

    private List<Post> postList;
    private Context context;
    private Tool TOOL;

    public RVAdapterPost(List<Post> postList, Context context) {
        this.postList = postList;
        this.context = context;
        TOOL = new Tool(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_postlayout,parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Post post = postList.get(position);

        holder.name.setText(post.user.firstname + " " + post.user.lastname);
        holder.title.setText(post.title);
        holder.description.setText(post.description);

        //setHeartedUI(holder, post.isHearted);
        holder.adapter = new RVAdapterComment(post.comments, context);
        holder.recyclerView.setLayoutManager(holder.linearLayoutManager);
        holder.recyclerView.setAdapter(holder.adapter);



        holder.sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String comment = holder.comment.getText().toString();

                holder.comment.setText("");

                post.Comment(comment, new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        JSONObject object = null;
                        try {
                            object = new JSONObject(response);
                            TOOL.ToastText(object.getString("message"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }


    @Override

    public int getItemCount() {
        return postList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView, sendBtn;
        TextView name, title, comment;
        EditText description;

        RecyclerView recyclerView;
        LinearLayoutManager linearLayoutManager;
        RVAdapterComment adapter;

        public ViewHolder(View itemView) {
            super(itemView);
            linearLayoutManager = new LinearLayoutManager(itemView.getContext());
            recyclerView = itemView.findViewById(R.id.commentRecycleView);
            cardView = itemView.findViewById(R.id.anAnnouncementCard);
            name = itemView.findViewById(R.id.anName);
            title = itemView.findViewById(R.id.anTitle);
            description = itemView.findViewById(R.id.anDescription);
            sendBtn = itemView.findViewById(R.id.announcementSend);
            comment = itemView.findViewById(R.id.announcementText);
        }
    }
}