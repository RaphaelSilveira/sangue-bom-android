package br.com.bom.sangue.sangue_bom_android.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;

import org.w3c.dom.Text;

import java.util.List;
import java.util.StringTokenizer;

import br.com.bom.sangue.sangue_bom_android.Activitys.DetailsIntentDonationActivity;
import br.com.bom.sangue.sangue_bom_android.Entities.IntentDonation;
import br.com.bom.sangue.sangue_bom_android.Entities.Telephone;
import br.com.bom.sangue.sangue_bom_android.R;

/**
 * Created by Raphael on 22/11/2016.
 */
public class ActiveIntentDonationsAdapter extends RecyclerView.Adapter<ActiveIntentDonationsAdapter.ActiveintentDonationsViewHolder> {

    private List<IntentDonation> intentDonations;
    private Context context;

    public ActiveIntentDonationsAdapter ( List<IntentDonation> intentDonations, Context context) {
        this.intentDonations = intentDonations;
        this.context = context;
    }

    @Override
    public ActiveintentDonationsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemActiveIntentDonation = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_active_intent_donations, parent, false);
        return new ActiveintentDonationsViewHolder(itemActiveIntentDonation);
    }

    @Override
    public void onBindViewHolder(ActiveintentDonationsViewHolder holder, int position) {
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

    public static class ActiveintentDonationsViewHolder extends RecyclerView.ViewHolder {
        public TextView bloodDonator;
        public TextView bloodType;
        public TextView neighborhood;
        public TextView telephone;

        public ActiveintentDonationsViewHolder(View view) {
            super(view);

            bloodDonator = (TextView) view.findViewById(R.id.blood_donator_active);
            bloodType =  (TextView) view.findViewById(R.id.blood_type_active);
            neighborhood = (TextView) view.findViewById(R.id.neighborhood_active);
            telephone = (TextView) view.findViewById(R.id.telephone_active);
        }
    }

    private void openDetails (IntentDonation intentDonation) {
        Intent intent = new Intent(context, DetailsIntentDonationActivity.class);

        Gson gson = new Gson();
        String intentDonationJson = gson.toJson(intentDonation);

        intent.putExtra("EXTRA_INTENT_DONATION", intentDonationJson);

        context.startActivity(intent);
    }
}

