package com.udacity.sandwichclub.utils;

import android.media.Image;
import android.widget.ImageView;

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

            if (ingredients != null) {
                for (int i=0;i<ingredients.length();i++){
                    ingList.add(ingredients.getString(i));
                }
            }

            if (alsoKnownAs != null) {
                for (int i=0;i<alsoKnownAs.length();i++){
                    alsoList.add(alsoKnownAs.getString(i));
                }
            }

        } catch (JSONException e) {




        }


       Sandwich myLunch = new Sandwich(mainName,alsoList,placeOfOrigin,description,image,ingList);


        return myLunch;
    }
}
