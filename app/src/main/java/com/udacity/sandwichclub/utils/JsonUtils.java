package com.udacity.sandwichclub.utils;


import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        JSONObject sandwich = null;
        JSONObject name = null;
        String description = null;
        String mainName = null;
        JSONArray alsoKnownAs = null;
        String placeOfOrigin = null;
        String image = null;
        JSONArray ingredients = null;
        List<String> ingList = new ArrayList<String>();
        List<String> alsoList = new ArrayList<String>();



        try {
            sandwich = new JSONObject(json);
            name = sandwich.getJSONObject("name");
            mainName = name.getString( "mainName" );
            alsoKnownAs = name.getJSONArray( "alsoKnownAs");
            placeOfOrigin = sandwich.getString("placeOfOrigin");
            description = sandwich.getString("description");
            image = sandwich.getString("image");
            ingredients = sandwich.getJSONArray( "ingredients" );
            makeList(ingredients, ingList);
            makeList(alsoKnownAs, alsoList);

        } catch (JSONException e) {
            e.printStackTrace();

        }

       Sandwich myLunch = new Sandwich(mainName,alsoList,placeOfOrigin,description,image,ingList);


        return myLunch;
    }

    private static void makeList(JSONArray jsonArray, List<String> ingList) throws JSONException {
        if (jsonArray != null) {
            for (int i=0;i<jsonArray.length();i++){
                ingList.add(jsonArray.getString(i));
            }
        }
    }
}
