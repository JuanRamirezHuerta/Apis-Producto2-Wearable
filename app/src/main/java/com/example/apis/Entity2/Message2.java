package com.example.apis.Entity2;

import java.util.HashMap;
import java.util.Map;

public class Message2 {
    //api on water 2
    private String query;
    private String requestId;
    private Double lat;
    private Double lon;
    private Boolean water;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Boolean getWater() {
        return water;
    }

    public void setWater(Boolean water) {
        this.water = water;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
