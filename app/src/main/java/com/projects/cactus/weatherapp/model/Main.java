package com.projects.cactus.weatherapp.model;

public class Main {

    private Double temp;
    private Double temp_min;
    private Double temp_max;
    private Double pressure;
    private Double sea_level;
    private Double grnd_level;
    private Integer humidity;
    private Double temp_kf;

    /**
     *
     * @return
     * The temp
     */
    public Double getTemp() {
        return temp;
    }

    /**
     *
     * @param temp
     * The temp
     */
    public void setTemp(Double temp) {
        this.temp = temp;
    }

    /**
     *
     * @return
     * The tempMin
     */
    public Double getTempMin() {
        return temp_min;
    }

    /**
     *
     * @param tempMin
     * The temp_min
     */
    public void setTempMin(Double tempMin) {
        this.temp_min = tempMin;
    }

    /**
     *
     * @return
     * The tempMax
     */
    public Double getTempMax() {
        return temp_max;
    }

    /**
     *
     * @param tempMax
     * The temp_max
     */
    public void setTempMax(Double tempMax) {
        this.temp_max = tempMax;
    }

    /**
     *
     * @return
     * The pressure
     */
    public Double getPressure() {
        return pressure;
    }

    /**
     *
     * @param pressure
     * The pressure
     */
    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    /**
     *
     * @return
     * The seaLevel
     */
    public Double getSeaLevel() {
        return sea_level;
    }

    /**
     *
     * @param seaLevel
     * The sea_level
     */
    public void setSeaLevel(Double seaLevel) {
        this.sea_level = seaLevel;
    }

    /**
     *
     * @return
     * The grndLevel
     */
    public Double getGrndLevel() {
        return grnd_level;
    }

    /**
     *
     * @param grndLevel
     * The grnd_level
     */
    public void setGrndLevel(Double grndLevel) {
        this.grnd_level = grndLevel;
    }

    /**
     *
     * @return
     * The humidity
     */
    public Integer getHumidity() {
        return humidity;
    }

    /**
     *
     * @param humidity
     * The humidity
     */
    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    /**
     *
     * @return
     * The tempKf
     */
    public Double getTempKf() {
        return temp_kf;
    }

    /**
     *
     * @param tempKf
     * The temp_kf
     */
    public void setTempKf(Double tempKf) {
        this.temp_kf = tempKf;
    }

}