package mvp.globalweather.cleanarchitecture.stefano.model.forecast;

import java.util.ArrayList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import mvp.globalweather.cleanarchitecture.stefano.model.daily.Weather;


public class List {

    @SerializedName("dt")
    @Expose
    private Integer dt;
    @SerializedName("temp")
    @Expose
    private Temp temp;
    @SerializedName("pressure")
    @Expose
    private Float pressure;
    @SerializedName("humidity")
    @Expose
    private Integer humidity;
    @SerializedName("weather")
    @Expose
    private java.util.List<Weather> weather = new ArrayList<Weather>();
    @SerializedName("speed")
    @Expose
    private Float speed;
    @SerializedName("deg")
    @Expose
    private Integer deg;
    @SerializedName("clouds")
    @Expose
    private Integer clouds;
    @SerializedName("rain")
    @Expose
    private Float rain;

    /**
     * No args constructor for use in serialization
     *
     */
    public List() {
    }

    /**
     *
     * @param clouds
     * @param dt
     * @param humidity
     * @param pressure
     * @param speed
     * @param deg
     * @param weather
     * @param temp
     * @param rain
     */
    public List(Integer dt, Temp temp, Float pressure, Integer humidity, java.util.List<Weather> weather, Float speed, Integer deg, Integer clouds, Float rain) {
        this.dt = dt;
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
        this.weather = weather;
        this.speed = speed;
        this.deg = deg;
        this.clouds = clouds;
        this.rain = rain;
    }

    /**
     *
     * @return
     * The dt
     */
    public Integer getDt() {
        return dt;
    }

    /**
     *
     * @param dt
     * The dt
     */
    public void setDt(Integer dt) {
        this.dt = dt;
    }

    public List withDt(Integer dt) {
        this.dt = dt;
        return this;
    }

    /**
     *
     * @return
     * The temp
     */
    public Temp getTemp() {
        return temp;
    }

    /**
     *
     * @param temp
     * The temp
     */
    public void setTemp(Temp temp) {
        this.temp = temp;
    }

    public List withTemp(Temp temp) {
        this.temp = temp;
        return this;
    }

    /**
     *
     * @return
     * The pressure
     */
    public Float getPressure() {
        return pressure;
    }

    /**
     *
     * @param pressure
     * The pressure
     */
    public void setPressure(Float pressure) {
        this.pressure = pressure;
    }

    public List withPressure(Float pressure) {
        this.pressure = pressure;
        return this;
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

    public List withHumidity(Integer humidity) {
        this.humidity = humidity;
        return this;
    }

    /**
     *
     * @return
     * The weather
     */
    public java.util.List<Weather> getWeather() {
        return weather;
    }

    /**
     *
     * @param weather
     * The weather
     */
    public void setWeather(java.util.List<Weather> weather) {
        this.weather = weather;
    }

    public List withWeather(java.util.List<Weather> weather) {
        this.weather = weather;
        return this;
    }

    /**
     *
     * @return
     * The speed
     */
    public Float getSpeed() {
        return speed;
    }

    /**
     *
     * @param speed
     * The speed
     */
    public void setSpeed(Float speed) {
        this.speed = speed;
    }

    public List withSpeed(Float speed) {
        this.speed = speed;
        return this;
    }

    /**
     *
     * @return
     * The deg
     */
    public Integer getDeg() {
        return deg;
    }

    /**
     *
     * @param deg
     * The deg
     */
    public void setDeg(Integer deg) {
        this.deg = deg;
    }

    public List withDeg(Integer deg) {
        this.deg = deg;
        return this;
    }

    /**
     *
     * @return
     * The clouds
     */
    public Integer getClouds() {
        return clouds;
    }

    /**
     *
     * @param clouds
     * The clouds
     */
    public void setClouds(Integer clouds) {
        this.clouds = clouds;
    }

    public List withClouds(Integer clouds) {
        this.clouds = clouds;
        return this;
    }

    /**
     *
     * @return
     * The rain
     */
    public Float getRain() {
        return rain;
    }

    /**
     *
     * @param rain
     * The rain
     */
    public void setRain(Float rain) {
        this.rain = rain;
    }

    public List withRain(Float rain) {
        this.rain = rain;
        return this;
    }

}