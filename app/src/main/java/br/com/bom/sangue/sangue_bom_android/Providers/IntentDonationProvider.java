package br.com.bom.sangue.sangue_bom_android.Providers;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import br.com.bom.sangue.sangue_bom_android.Callbacks.ActiveIntentDonationsCallback;
import br.com.bom.sangue.sangue_bom_android.Callbacks.GrantIntentDonationsCallback;
import br.com.bom.sangue.sangue_bom_android.Callbacks.IntentDonationCallback;
import br.com.bom.sangue.sangue_bom_android.Constants.Endpoints;
import br.com.bom.sangue.sangue_bom_android.Entities.IntentDonation;

/**
 * Created by Raphael on 13/11/2016.
 */
public class IntentDonationProvider {

    public void create (IntentDonation intentDonation, Context context, final IntentDonationCallback intentDonationCallback) throws JSONException {
        RequestQueue request = Volley.newRequestQueue(context);

        Gson gson = new Gson();
        String intentDonationJson = gson.toJson(intentDonation);
        JSONObject intentDonationObject = new JSONObject(intentDonationJson);

        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.POST, Endpoints.INTENT_DONATION_CREATE_DONATOR, intentDonationObject,
            new Response.Listener<JSONObject>()
            {
                @Override
                public void onResponse(JSONObject response) {
                    Log.d("Response", response.toString());
                    intentDonationCallback.success();
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

    public void update (IntentDonation intentDonation, Context context, final IntentDonationCallback intentDonationCallback) throws JSONException {
        RequestQueue request = Volley.newRequestQueue(context);

        Gson gson = new Gson();
        String intentDonationJson = gson.toJson(intentDonation);
        JSONObject intentDonationObject = new JSONObject(intentDonationJson);

        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.POST, Endpoints.INTENT_DONATION_UPDATE_DONATOR, intentDonationObject,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("Response", response.toString());
                        intentDonationCallback.success();
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

    public void findAll (Context context, final ActiveIntentDonationsCallback activeIntentDonationsCallback) throws JSONException {
        RequestQueue request = Volley.newRequestQueue(context);

        JsonArrayRequest getRequest = new JsonArrayRequest(Request.Method.GET, Endpoints.INTENT_DONATION_FIND_ALL, null,
            new Response.Listener<JSONArray>()
            {
                @Override
                public void onResponse(JSONArray response) {
                    Log.d("Response", response.toString());
                    activeIntentDonationsCallback.findAllIntentDonations(response.toString());
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

    public void findAllGrant (Context context, final GrantIntentDonationsCallback grantIntentDonationsCallback) throws JSONException {
        RequestQueue request = Volley.newRequestQueue(context);

        JsonArrayRequest getRequest = new JsonArrayRequest(Request.Method.GET, Endpoints.INTENT_DONATION_FIND_ALL_GRANT, null,
            new Response.Listener<JSONArray>()
            {
                @Override
                public void onResponse(JSONArray response) {
                    Log.d("Response", response.toString());
                    grantIntentDonationsCallback.findAllIntentDonations(response.toString());
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

    public void setGrantDate (IntentDonation intentDonation, Context context, final IntentDonationCallback intentDonationCallback) throws JSONException {
        RequestQueue request = Volley.newRequestQueue(context);

        Gson gson = new Gson();
        String intentDonationJson = gson.toJson(intentDonation);
        JSONObject intentDonationObject = new JSONObject(intentDonationJson);

        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.PUT, Endpoints.INTENT_DONATION_SET_GRANT_DATE + intentDonation.getId(), intentDonationObject,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("Response", response.toString());
                        intentDonationCallback.success();
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
