package com.khanbaba.weatherdemo;

public class WeatherDetails {

    Double dayTemp;
    Double maxTemp;
    Double minTemp;
    String date;

        WeatherDetails(Double dayTemp, Double maxTemp, Double minTemp, String date) {
            this.dayTemp = dayTemp;
            this.maxTemp = maxTemp;
            this.minTemp = minTemp;
            this.date = date;
        }

        public void setDayTemp(Double dayTemp) {
            this.dayTemp = dayTemp;
        }

        public void setMaxTemp(Double maxTemp) {
            this.maxTemp = maxTemp;
        }

        public void setMinTemp(Double minTemp) {
            this.minTemp = minTemp;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public Double getDayTemp() {
            return dayTemp;
        }

        public Double getMaxTemp() {
            return maxTemp;
        }

        public Double getMinTemp() {
            return minTemp;
        }

        public String getDate() {
            return date;
        }
}

