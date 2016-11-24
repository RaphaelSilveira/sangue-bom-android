package br.com.bom.sangue.sangue_bom_android.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;

import br.com.bom.sangue.sangue_bom_android.Activitys.DetailsIntentDonationActivity;
import br.com.bom.sangue.sangue_bom_android.Activitys.GrantDetailsIntentsActivity;
import br.com.bom.sangue.sangue_bom_android.Entities.IntentDonation;
import br.com.bom.sangue.sangue_bom_android.Entities.Telephone;
import br.com.bom.sangue.sangue_bom_android.R;

/**
 * Created by raphael on 24/11/16.
 */

public class GrantIntentDonationsAdapter extends  RecyclerView.Adapter<GrantIntentDonationsAdapter.GrantIntentDonationsViewHolder> {

    private List<IntentDonation> intentDonations;
    private Context context;

    public GrantIntentDonationsAdapter ( List<IntentDonation> intentDonations, Context context) {
        this.intentDonations = intentDonations;
        this.context = context;
    }

    @Override
    public GrantIntentDonationsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemGrantIntentDonation = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_grant_intent_donations, parent, false);
        return new GrantIntentDonationsAdapter.GrantIntentDonationsViewHolder(itemGrantIntentDonation);
    }

    @Override
    public void onBindViewHolder(GrantIntentDonationsViewHolder holder, int position) {
        final IntentDonation intentDonation = intentDonations.get(position);

        holder.bloodDonator.setText(intentDonation.getBloodDonator().getNickname());

        String bloodType = intentDonation.getBloodDonator().getBloodType() + intentDonation.getBloodDonator().getBloodFactor();
        holder.bloodType.setText(bloodType);

        holder.neighborhood.setText(intentDonation.getBloodDonator().getAddress().getNeighborhood());

        Telephone telephone = intentDonation.getBloodDonator().getTelephone();
        String formatedTelephone = "(" + telephone.getDdd() + ") " + telephone.getNumber();
        holder.telephone.setText(formatedTelephone);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetails(intentDonation);
            }
        });
    }

    @Override
    public int getItemCount() {
        return intentDonations.size();
    }

    public static class GrantIntentDonationsViewHolder extends RecyclerView.ViewHolder {
        public TextView bloodDonator;
        public TextView bloodType;
        public TextView neighborhood;
        public TextView telephone;

        public GrantIntentDonationsViewHolder(View view) {
            super(view);

            bloodDonator = (TextView) view.findViewById(R.id.blood_donator_grant);
            bloodType =  (TextView) view.findViewById(R.id.blood_type_grant);
            neighborhood = (TextView) view.findViewById(R.id.neighborhood_grant);
            telephone = (TextView) view.findViewById(R.id.telephone_grant);
        }
    }

    private void openDetails(IntentDonation intentDonation) {
        Intent intent = new Intent(context, GrantDetailsIntentsActivity.class);

        Gson gson = new Gson();
        String intentDonationJson = gson.toJson(intentDonation);

        intent.putExtra("EXTRA_INTENT_DONATION", intentDonationJson);

        context.startActivity(intent);
    }
}
