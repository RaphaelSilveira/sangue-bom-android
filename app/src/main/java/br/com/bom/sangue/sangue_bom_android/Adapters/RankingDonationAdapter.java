package br.com.bom.sangue.sangue_bom_android.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.bom.sangue.sangue_bom_android.Entities.BloodDonator;
import br.com.bom.sangue.sangue_bom_android.Entities.RankingDonations;
import br.com.bom.sangue.sangue_bom_android.R;

/**
 * Created by Raphael on 19/11/2016.
 */
public class RankingDonationAdapter extends RecyclerView.Adapter<RankingDonationAdapter.RankingDonationViewHolder> {

    private List<RankingDonations> rankingDonationses;
    private Context context;

    public RankingDonationAdapter (List<RankingDonations> rankingDonationses, Context context) {
        this.rankingDonationses = rankingDonationses;
        this.context = context;
    }

    @Override
    public RankingDonationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemRankingDonation = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_ranking_donations, parent,false);
        return new RankingDonationViewHolder(itemRankingDonation);
    }

    @Override
    public void onBindViewHolder(RankingDonationViewHolder holder, int position) {
        RankingDonations rankingDonations = rankingDonationses.get(position);

        holder.bloodDonator.setText(rankingDonations.getBloodDonator());
        holder.numberDonations.setText(rankingDonations.getNumberDonations());
    }

    @Override
    public int getItemCount() {
        return rankingDonationses.size();
    }

    public static class RankingDonationViewHolder extends RecyclerView.ViewHolder {
        public TextView bloodDonator, numberDonations;

        public RankingDonationViewHolder(View view) {
            super(view);
            bloodDonator = (TextView) view.findViewById(R.id.blood_donator);
            numberDonations = (TextView) view.findViewById(R.id.number_donations);
        }
    }
}
