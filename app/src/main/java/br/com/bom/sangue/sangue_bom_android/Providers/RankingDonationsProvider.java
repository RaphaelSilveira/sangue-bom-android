package br.com.bom.sangue.sangue_bom_android.Providers;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONObject;

import br.com.bom.sangue.sangue_bom_android.Callbacks.RankingDonationsCallback;
import br.com.bom.sangue.sangue_bom_android.Constants.Endpoints;

/**
 * Created by Raphael on 19/11/2016.
 */
public class RankingDonationsProvider {

    public void getRankingDonations (Context context, final RankingDonationsCallback rankingDonationsCallback) {
        RequestQueue request = Volley.newRequestQueue(context);

        JsonArrayRequest getRequest = new JsonArrayRequest(Request.Method.GET, Endpoints.RANKING_DONATION_GET, null,
            new Response.Listener<JSONArray>()
            {
                @Override
                public void onResponse(JSONArray response) {
                    Log.d("Response", response.toString());
                    rankingDonationsCallback.getRankingDonationsCallback(response.toString());
                }
            },
            new Response.ErrorListener()
            {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.d("Error.Response", error.toString());
                }
            }
        );

        request.add(getRequest);
    }

}
