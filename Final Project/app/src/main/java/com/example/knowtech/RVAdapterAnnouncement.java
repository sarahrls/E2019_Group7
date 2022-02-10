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

public class RVAdapterAnnouncement extends RecyclerView.Adapter<RVAdapterAnnouncement.ViewHolder> {

    private List<Announcement> announcementList;
    private Context context;
    private Tool TOOL;

    public RVAdapterAnnouncement(List<Announcement> announcementList, Context context) {
        this.announcementList = announcementList;
        this.context = context;
        TOOL = new Tool(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.add_post,parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Announcement announcement = announcementList.get(position);

        holder.name.setText(announcement.admin.firstname + " " + announcement.admin.lastname);
        holder.title.setText(announcement.title);
        holder.description.setText(announcement.description);

        setHeartedUI(holder, announcement.isHearted);
        holder.adapter = new RVAdapterComment(announcement.comments, context);
        holder.recyclerView.setLayoutManager(holder.linearLayoutManager);
        holder.recyclerView.setAdapter(holder.adapter);



        holder.sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String comment = holder.comment.getText().toString();

                holder.comment.setText("");

                announcement.Comment(comment, new Response.Listener<String>(){
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

    public void setHeartedUI(ViewHolder holder, Boolean bool) {
        holder.heartBtn.setBackgroundColor(Color.parseColor(bool ? "#C82927" : "#F0F2F5"));
        holder.heartDrawable.getBackground().setColorFilter(Color.parseColor(bool ? "#ffffff" : "#65676B"), PorterDuff.Mode.SRC_IN);
    }

    @Override

    public int getItemCount() {
        return announcementList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView, heartBtn, sendBtn;
        TextView name, title, comment;
        EditText description;
        RelativeLayout heartDrawable;
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
            heartBtn = itemView.findViewById(R.id.anouncementHeart);
            heartDrawable = itemView.findViewById(R.id.announcementHeartdrawable);
            sendBtn = itemView.findViewById(R.id.announcementSend);
            comment = itemView.findViewById(R.id.announcementText);
        }
    }
}