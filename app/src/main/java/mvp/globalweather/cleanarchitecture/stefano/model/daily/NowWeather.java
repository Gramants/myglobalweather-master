package mvp.globalweather.cleanarchitecture.stefano.model.daily;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class NowWeather implements Parcelable {

    @SerializedName("coord")
    @Expose
    private Coord coord;
    @SerializedName("weather")
    @Expose
    private List<Weather> weather = new ArrayList<Weather>();
    @SerializedName("base")
    @Expose
    private String base;
    @SerializedName("main")
    @Expose
    private Main main;
    @SerializedName("wind")
    @Expose
    private Wind wind;
    @SerializedName("clouds")
    @Expose
    private Clouds clouds;
    @SerializedName("dt")
    @Expose
    private Integer dt;
    @SerializedName("sys")
    @Expose
    private Sys sys;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("cod")
    @Expose
    private Integer cod;

    /**
     * No args constructor for use in serialization
     *
     */
    public NowWeather() {
    }

    /**
     *
     * @param id
     * @param dt
     * @param clouds
     * @param coord
     * @param wind
     * @param cod
     * @param sys
     * @param name
     * @param base
     * @param weather
     * @param main
     */
    public NowWeather(Coord coord, List<Weather> weather, String base, Main main, Wind wind, Clouds clouds, Integer dt, Sys sys, Integer id, String name, Integer cod) {
        this.coord = coord;
        this.weather = weather;
        this.base = base;
        this.main = main;
        this.wind = wind;
        this.clouds = clouds;
        this.dt = dt;
        this.sys = sys;
        this.id = id;
        this.name = name;
        this.cod = cod;
    }

    protected NowWeather(Parcel in) {
        coord = in.readParcelable(Coord.class.getClassLoader());
        weather = in.createTypedArrayList(Weather.CREATOR);
        base = in.readString();
        main = in.readParcelable(Main.class.getClassLoader());
        wind = in.readParcelable(Wind.class.getClassLoader());
        clouds = in.readParcelable(Clouds.class.getClassLoader());
        sys = in.readParcelable(Sys.class.getClassLoader());
        name = in.readString();
    }

    public static final Creator<NowWeather> CREATOR = new Creator<NowWeather>() {
        @Override
        public NowWeather createFromParcel(Parcel in) {
            return new NowWeather(in);
        }

        @Override
        public NowWeather[] newArray(int size) {
            return new NowWeather[size];
        }
    };

    /**
     *
     * @return
     * The coord
     */
    public Coord getCoord() {
        return coord;
    }

    /**
     *
     * @param coord
     * The coord
     */
    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public NowWeather withCoord(Coord coord) {
        this.coord = coord;
        return this;
    }

    /**
     *
     * @return
     * The weather
     */
    public List<Weather> getWeather() {
        return weather;
    }

    /**
     *
     * @param weather
     * The weather
     */
    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public NowWeather withWeather(List<Weather> weather) {
        this.weather = weather;
        return this;
    }

    /**
     *
     * @return
     * The base
     */
    public String getBase() {
        return base;
    }

    /**
     *
     * @param base
     * The base
     */
    public void setBase(String base) {
        this.base = base;
    }

    public NowWeather withBase(String base) {
        this.base = base;
        return this;
    }

    /**
     *
     * @return
     * The main
     */
    public Main getMain() {
        return main;
    }

    /**
     *
     * @param main
     * The main
     */
    public void setMain(Main main) {
        this.main = main;
    }

    public NowWeather withMain(Main main) {
        this.main = main;
        return this;
    }

    /**
     *
     * @return
     * The wind
     */
    public Wind getWind() {
        return wind;
    }

    /**
     *
     * @param wind
     * The wind
     */
    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public NowWeather withWind(Wind wind) {
        this.wind = wind;
        return this;
    }

    /**
     *
     * @return
     * The clouds
     */
    public Clouds getClouds() {
        return clouds;
    }

    /**
     *
     * @param clouds
     * The clouds
     */
    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public NowWeather withClouds(Clouds clouds) {
        this.clouds = clouds;
        return this;
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

    public NowWeather withDt(Integer dt) {
        this.dt = dt;
        return this;
    }

    /**
     *
     * @return
     * The sys
     */
    public Sys getSys() {
        return sys;
    }

    /**
     *
     * @param sys
     * The sys
     */
    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public NowWeather withSys(Sys sys) {
        this.sys = sys;
        return this;
    }

    /**
     *
     * @return
     * The id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    public NowWeather withId(Integer id) {
        this.id = id;
        return this;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    public NowWeather withName(String name) {
        this.name = name;
        return this;
    }

    /**
     *
     * @return
     * The cod
     */
    public Integer getCod() {
        return cod;
    }

    /**
     *
     * @param cod
     * The cod
     */
    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public NowWeather withCod(Integer cod) {
        this.cod = cod;
        return this;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(coord, flags);
        dest.writeTypedList(weather);
        dest.writeString(base);
        dest.writeParcelable(main, flags);
        dest.writeParcelable(wind, flags);
        dest.writeParcelable(clouds, flags);
        dest.writeParcelable(sys, flags);
        dest.writeString(name);
    }
}