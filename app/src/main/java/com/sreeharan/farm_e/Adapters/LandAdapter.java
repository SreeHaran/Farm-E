package com.sreeharan.farm_e.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sreeharan.farm_e.R;

public class LandAdapter extends RecyclerView.Adapter<LandAdapter.LandViewHolder> {
    final private LandItemClickListener mOnClickListener;
    private int mLandNumber;

    public LandAdapter(int landNumber, LandItemClickListener OnClickListener) {
        mLandNumber = landNumber;
        mOnClickListener = OnClickListener;
    }

    @NonNull
    @Override
    public LandViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.land_item, parent, false);
        return new LandViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LandViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return mLandNumber;
    }

    public interface LandItemClickListener {
        void onLandItemClick(int clickedLandIndex);
    }

    class LandViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView picture;
        TextView location;
        TextView price;
        Button details;

        public LandViewHolder(@NonNull View itemView) {
            super(itemView);

            picture = itemView.findViewById(R.id.land_image);
            location = itemView.findViewById(R.id.land_location);
            price = itemView.findViewById(R.id.land_price);
            itemView.setOnClickListener(this);
        }

        void bind(int listIndex) {
            picture.setImageResource(R.drawable.ic_launcher_background);
            location.setText("Coimbatore");
            price.setText("9000" + " rupees /month");
        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onLandItemClick(clickedPosition);
        }
    }
}
