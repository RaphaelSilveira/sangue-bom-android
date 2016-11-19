package br.com.bom.sangue.sangue_bom_android.Providers;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import br.com.bom.sangue.sangue_bom_android.Callbacks.BloodDonatorCallback;
import br.com.bom.sangue.sangue_bom_android.Constants.Endpoints;
import br.com.bom.sangue.sangue_bom_android.Entities.BloodDonator;

/**
 * Created by Raphael on 14/11/2016.
 */
public class BloodDonatorProvider {

    public BloodDonator findOneByCpf (String cpf, Context context, final BloodDonatorCallback bloodDonatorCallback) {
        RequestQueue request = Volley.newRequestQueue(context);

        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, Endpoints.BLOOD_DONATOR_FIND_ONE_BY_CPF + cpf, null,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("Response", response.toString());
                        bloodDonatorCallback.findOneByCpfCallback();
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

        return null;
    }
}
