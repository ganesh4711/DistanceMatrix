package com.demo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class DistanceAndTimeResponse{
        @Expose
        @SerializedName("destination_addresses")
        private String[] destination_addresses;

        @Expose
        @SerializedName("origin_addresses")
        private String[] origin_addresses;

        @Expose
        @SerializedName("rows")
        private List<Rows> rows;

        @Expose
        @SerializedName("status")
        private String status;

        public String[] getOrigin_addresses() {
            return origin_addresses;
        }

        public void setOrigin_addresses(String[] origin_addresses) {
            this.origin_addresses = origin_addresses;
        }

        public String[] getDestination_addresses() {
            return destination_addresses;
        }

        public void setDestination_addresses(String[] destination_addresses) {
            this.destination_addresses = destination_addresses;
        }

        public List<Rows> getRows() {
            return rows;
        }

        public void setRows(List<Rows> rows) {
            this.rows = rows;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

public static class Rows {
    @Expose
    @SerializedName("elements")
    private List<Elements> elements;

    public List<Elements> getElements() {
        return elements;
    }

    public void setElements(List<Elements> elements) {
        this.elements = elements;
    }
}

public static class Elements {
    @Expose
    @SerializedName("distance")
    private Distance distance;

    @Expose
    @SerializedName("duration")
    private Duration duration;

    public Distance getDistance() {
        return distance;
    }

    public void setDistance(Distance distance) {
        this.distance = distance;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }
}

public static class Distance {
    @Expose
    @SerializedName("text")
    private String text;

    @Expose
    @SerializedName("value")
    private String value;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

public static class Duration {
    @Expose
    @SerializedName("text")
    private String text;

    @Expose
    @SerializedName("value")
    private String value;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
}