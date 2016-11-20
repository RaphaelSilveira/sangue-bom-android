package br.com.bom.sangue.sangue_bom_android.Providers;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import br.com.bom.sangue.sangue_bom_android.Callbacks.LoginCallback;
import br.com.bom.sangue.sangue_bom_android.Constants.Endpoints;

/**
 * Created by Raphael on 20/11/2016.
 */
public class LoginProvider {

    public void login (String email, String password, Context context, final LoginCallback loginCallback) {
        RequestQueue request = Volley.newRequestQueue(context);

        StringRequest getRequest = new StringRequest(Request.Method.GET, Endpoints.LOGIN + email + "&" + password,
            new Response.Listener<String>()
            {
                @Override
                public void onResponse(String response) {
                    Log.d("Response", response.toString());

                    loginCallback.login(Boolean.valueOf(response.toString()));
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
