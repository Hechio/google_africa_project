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
import com.stevehechio.apps.gads2020leaderboard.models.SkillsObject;

import java.util.List;

public class SkillIQAdapter extends RecyclerView.Adapter<SkillIQAdapter.SkillHolder> {
    private List<SkillsObject> skillsObjects;
    private Context context;

    public SkillIQAdapter(Context context) {
        this.context = context;
    }

    public void setSkillsObjects(List<SkillsObject> skillsObjects) {
        this.skillsObjects = skillsObjects;
    }

    @NonNull
    @Override
    public SkillHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_leaders, parent, false);
        return new SkillHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SkillHolder holder, int position) {
        SkillsObject object = skillsObjects.get(position);
        String badge = object.getBadgeUrl();
        Glide.with(context).load(badge).into(holder.imageView);
        holder.textViewName.setText(object.getName());
        String status = object.getScore() + " skill IQ Score, "+ object.getCountry();
        holder.textViewStatus.setText(status);
    }

    @Override
    public int getItemCount() {
        return skillsObjects==null ? 0 : skillsObjects.size();
    }

    class SkillHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textViewName, textViewStatus;
        public SkillHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_badge);
            textViewName = itemView.findViewById(R.id.tv_name);
            textViewStatus = itemView.findViewById(R.id.tv_status);
        }
    }
}
