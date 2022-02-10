package com.example.knowtech;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class RVAdapterComment extends RecyclerView.Adapter<RVAdapterComment.ViewHolder> {
    private List<Comment> comments;
    private Context context;

    public RVAdapterComment(List<Comment> comments, Context context) {
        this.comments = comments;
        this.context = context;
    }


    @Override
    public RVAdapterComment.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_comment,parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RVAdapterComment.ViewHolder holder, int position) {
        Comment comment = comments.get(position);

        holder.mainComment.setText(comment.comment);
        holder.name.setText(comment.author.firstname + " " + comment.author.lastname);
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    public String formatDate(String toFormat) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date date = formatter.parse(toFormat);
        SimpleDateFormat formatr = new SimpleDateFormat("MMMM dd yyyy");
        return formatr.format(date);
    }

    public String formatTime(String time) throws ParseException{
        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm a");
        String[] val = time.split(":");
        Date d = new Date();
        Date date = new Date(d.getYear(), d.getMonth(),d.getDate(), Integer.parseInt(val[0]),Integer.parseInt(val[1]));
        return formatter.format(date);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView mainComment, name;

        public ViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.commentName);
            mainComment = itemView.findViewById(R.id.mainComment);
        }
    }
}