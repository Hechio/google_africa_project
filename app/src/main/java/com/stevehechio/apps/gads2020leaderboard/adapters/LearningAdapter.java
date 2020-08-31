package com.stevehechio.apps.gads2020leaderboard.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.stevehechio.apps.gads2020leaderboard.R;
import com.stevehechio.apps.gads2020leaderboard.models.HoursObject;

import java.util.List;

public class LearningAdapter extends RecyclerView.Adapter<LearningAdapter.LearningHolder> {
    private List<HoursObject> hoursObjects;
    private Context context;

    public LearningAdapter(Context context) {
        this.context = context;
    }

    public void setHoursObjects(List<HoursObject> hoursObjects) {
        this.hoursObjects = hoursObjects;
    }

    @NonNull
    @Override
    public LearningHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_leaders, parent, false);
        return new LearningHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LearningHolder holder, int position) {
        HoursObject object = hoursObjects.get(position);
        String badge = object.getBadgeUrl();
        Glide.with(context).load(badge).into(holder.imageView);
        holder.textViewName.setText(object.getName());
        String status = object.getHour() + " learning hours, "+ object.getCountry();
        holder.textViewStatus.setText(status);
    }

    @Override
    public int getItemCount() {
        return hoursObjects==null ? 0 : hoursObjects.size();
    }

    class LearningHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textViewName, textViewStatus;
        public LearningHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_badge);
            textViewName = itemView.findViewById(R.id.tv_name);
            textViewStatus = itemView.findViewById(R.id.tv_status);
        }
    }
}
