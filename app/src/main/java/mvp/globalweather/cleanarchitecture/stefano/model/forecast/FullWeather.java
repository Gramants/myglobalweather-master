package mvp.globalweather.cleanarchitecture.stefano.model.forecast;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import mvp.globalweather.cleanarchitecture.stefano.model.daily.City;

public class FullWeather implements Parcelable {

    @SerializedName("city")
    @Expose
    private City city;
    @SerializedName("cod")
    @Expose
    private String cod;
    @SerializedName("message")
    @Expose
    private Float message;
    @SerializedName("cnt")
    @Expose
    private Integer cnt;
    @SerializedName("list")
    @Expose
    private java.util.List<List> list = new ArrayList<List>();

    /**
     * No args constructor for use in serialization
     *
     */
    public FullWeather() {
    }

    /**
     *
     * @param message
     * @param cnt
     * @param cod
     * @param list
     * @param city
     */
    public FullWeather(City city, String cod, Float message, Integer cnt, java.util.List<List> list) {
        this.city = city;
        this.cod = cod;
        this.message = message;
        this.cnt = cnt;
        this.list = list;
    }

    protected FullWeather(Parcel in) {
        cod = in.readString();
    }

    public static final Creator<FullWeather> CREATOR = new Creator<FullWeather>() {
        @Override
        public FullWeather createFromParcel(Parcel in) {
            return new FullWeather(in);
        }

        @Override
        public FullWeather[] newArray(int size) {
            return new FullWeather[size];
        }
    };

    /**
     *
     * @return
     * The city
     */
    public City getCity() {
        return city;
    }

    /**
     *
     * @param city
     * The city
     */
    public void setCity(City city) {
        this.city = city;
    }

    public FullWeather withCity(City city) {
        this.city = city;
        return this;
    }

    /**
     *
     * @return
     * The cod
     */
    public String getCod() {
        return cod;
    }

    /**
     *
     * @param cod
     * The cod
     */
    public void setCod(String cod) {
        this.cod = cod;
    }

    public FullWeather withCod(String cod) {
        this.cod = cod;
        return this;
    }

    /**
     *
     * @return
     * The message
     */
    public Float getMessage() {
        return message;
    }

    /**
     *
     * @param message
     * The message
     */
    public void setMessage(Float message) {
        this.message = message;
    }

    public FullWeather withMessage(Float message) {
        this.message = message;
        return this;
    }

    /**
     *
     * @return
     * The cnt
     */
    public Integer getCnt() {
        return cnt;
    }

    /**
     *
     * @param cnt
     * The cnt
     */
    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public FullWeather withCnt(Integer cnt) {
        this.cnt = cnt;
        return this;
    }

    /**
     *
     * @return
     * The list
     */
    public java.util.List<List> getList() {
        return list;
    }

    /**
     *
     * @param list
     * The list
     */
    public void setList(java.util.List<List> list) {
        this.list = list;
    }

    public FullWeather withList(java.util.List<List> list) {
        this.list = list;
        return this;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(cod);
    }
}