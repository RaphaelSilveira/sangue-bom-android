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
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import br.com.bom.sangue.sangue_bom_android.Callbacks.NewsListCallback;
import br.com.bom.sangue.sangue_bom_android.Callbacks.NewsCallback;
import br.com.bom.sangue.sangue_bom_android.Constants.Endpoints;
import br.com.bom.sangue.sangue_bom_android.Entities.News;

public class NewsProvider {
    public void create (News news, Context context, final NewsCallback newsCallback) throws JSONException {
        RequestQueue request = Volley.newRequestQueue(context);

        Gson gson = new Gson();
        String newsJson = gson.toJson(news);
        JSONObject newsObject = new JSONObject(newsJson);

        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.POST, Endpoints.NEWS_CREATE, newsObject,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("Response", response.toString());

                        newsCallback.create(Boolean.TRUE);
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

    public void findAll (Context context, final NewsListCallback newsListCallback) throws JSONException {
        RequestQueue request = Volley.newRequestQueue(context);

        JsonArrayRequest getRequest = new JsonArrayRequest(Request.Method.GET, Endpoints.NEWS_FIND_ALL, null,
                new Response.Listener<JSONArray>()
                {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("Response", response.toString());
                        newsListCallback.findAllNews(response.toString());
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
