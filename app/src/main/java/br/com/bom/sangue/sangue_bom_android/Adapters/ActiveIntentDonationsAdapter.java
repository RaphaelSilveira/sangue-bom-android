package br.com.bom.sangue.sangue_bom_android.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.bom.sangue.sangue_bom_android.Entities.IntentDonation;
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
        IntentDonation intentDonation = intentDonations.get(position);

        holder.bloodDonator.setText(intentDonation.getBloodDonator().getName());
    }

    @Override
    public int getItemCount() {
        return intentDonations.size();
    }

    public static class ActiveintentDonationsViewHolder extends RecyclerView.ViewHolder {
        public TextView bloodDonator;

        public ActiveintentDonationsViewHolder(View view) {
            super(view);

            bloodDonator = (TextView) view.findViewById(R.id.blood_donator_active);
        }
    }
}

