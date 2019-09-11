package com.example.webservices.webrestful;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class PlacesHelper {
    public static ArrayList<String> getPlaces(String search) {

        final String APIKY = "";
        search = search.replaceAll("\\s+","");
        String uri = "https://maps.googleapis.com/maps/api/place/findplacefromtext/json?input=" + search + "%20Dublin&inputtype=textquery&fields=photos,formatted_address,name,rating,opening_hours,geometry&sensor=false&key=" + APIKY;
        StringBuffer response = sendRequest(uri);
        SortResponse sortResponse = new SortResponse(response).invoke();
        ArrayList<String> business = new ArrayList<>();
        business.add(0, sortResponse.getName());
        business.add(1, sortResponse.getAddress());
        business.add(2, sortResponse.getRating());
        business.add(3, getImgURL(APIKY, sortResponse));
        return business;
    }

    private static StringBuffer sendRequest(String uri) {
        StringBuffer response = new StringBuffer();
        try {
            URL obj = new URL(uri);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            con.setRequestMethod("GET");

            con.setRequestProperty("User-Agent", "Mozilla/5.0");

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

    private static String getImgURL(String APIKY, SortResponse sortResponse) {
        String photo = sortResponse.getPhoto();
        return "https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photoreference=" + photo + "&sensor=false&key=" + APIKY;
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
