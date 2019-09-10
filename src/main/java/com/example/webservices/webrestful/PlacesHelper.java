package com.example.webservices.webrestful;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class PlacesHelper {
    public static ArrayList<String> getPlaces(String search){

        final String APIKY = "";
        search = search.replaceAll("\\s+","");
        String uri = "https://maps.googleapis.com/maps/api/place/findplacefromtext/json?input=" + search + "%20Dublin&inputtype=textquery&fields=photos,formatted_address,name,rating,opening_hours,geometry&sensor=false&key=" + APIKY;
        StringBuffer response = sendRequest(uri);
        String img = "https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photoreference=";
        String endImage = "&sensor=false&key=" + APIKY;
        SortResponse sortResponse = new SortResponse(response).invoke();
        String name = sortResponse.getName();
        String address = sortResponse.getAddress();
        String rating = sortResponse.getRating();
        String photo = sortResponse.getPhoto();
        ArrayList<String> business = new ArrayList<>();
        img = img + photo + endImage;
        business.add(0,name);
        business.add(1, address);
        business.add(2, rating);
        business.add(3, img);
        return business;
    }

    private static StringBuffer sendRequest(String uri) {
        StringBuffer response = new StringBuffer();
        try {
            URL obj = new URL(uri);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            // optional default is GET
            con.setRequestMethod("GET");

            //add request header
            con.setRequestProperty("User-Agent", "Mozilla/5.0");

            int responseCode = con.getResponseCode();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    private static class SortResponse {
        private StringBuffer response;
        private String name;
        private String address;
        private String rating;
        private String photo;

        public SortResponse(StringBuffer response) {
            this.response = response;
        }

        public String getName() {
            return name;
        }

        public String getAddress() {
            return address;
        }

        public String getRating() {
            return rating;
        }

        public String getPhoto() {
            return photo;
        }

        public SortResponse invoke() {
            try {
                JSONObject jsonObj = new JSONObject(response.toString());
                JSONArray array = jsonObj.getJSONArray("candidates");
                name = array.getJSONObject(0).get("name").toString();
                address = array.getJSONObject(0).get("formatted_address").toString();
                rating = array.getJSONObject(0).get("rating").toString();
                JSONObject photoInfo = array.getJSONObject(0).getJSONArray("photos").getJSONObject(0);
                photo = photoInfo.getString("photo_reference");

            } catch (Exception e) {
                e.printStackTrace();
            }
            return this;
        }
    }
}
