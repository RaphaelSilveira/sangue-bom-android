package br.com.bom.sangue.sangue_bom_android.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.bom.sangue.sangue_bom_android.Entities.BloodDonator;
import br.com.bom.sangue.sangue_bom_android.R;

/**
 * Created by Raphael on 19/11/2016.
 */
public class RankingDonationAdapter extends RecyclerView.Adapter<RankingDonationAdapter.RankingDonationViewHolder> {

    private List<BloodDonator> bloodDonators;
    private Context context;

    public RankingDonationAdapter (List<BloodDonator> bloodDonators, Context context) {
        this.bloodDonators = bloodDonators;
        this.context = context;
    }

    @Override
    public RankingDonationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemRankingDonation = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_ranking_donations, parent,false);
        return new RankingDonationViewHolder(itemRankingDonation);
    }

    @Override
    public void onBindViewHolder(RankingDonationViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class RankingDonationViewHolder extends RecyclerView.ViewHolder {
        public TextView login, reposUrl;

        public RankingDonationViewHolder(View view) {
            super(view);
            login = (TextView) view.findViewById(R.id.login);
            //reposUrl = (TextView) view.findViewById(R.id.repos_url);
        }
    }
}
