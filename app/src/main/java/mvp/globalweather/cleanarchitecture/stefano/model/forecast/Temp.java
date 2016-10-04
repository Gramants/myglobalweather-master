package mvp.globalweather.cleanarchitecture.stefano.model.forecast;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Temp implements Parcelable {

    @SerializedName("day")
    @Expose
    private Float day;
    @SerializedName("min")
    @Expose
    private Float min;
    @SerializedName("max")
    @Expose
    private Float max;
    @SerializedName("night")
    @Expose
    private Float night;
    @SerializedName("eve")
    @Expose
    private Float eve;
    @SerializedName("morn")
    @Expose
    private Float morn;

    /**
     * No args constructor for use in serialization
     *
     */
    public Temp() {
    }

    /**
     *
     * @param min
     * @param eve
     * @param max
     * @param morn
     * @param night
     * @param day
     */
    public Temp(Float day, Float min, Float max, Float night, Float eve, Float morn) {
        this.day = day;
        this.min = min;
        this.max = max;
        this.night = night;
        this.eve = eve;
        this.morn = morn;
    }

    protected Temp(Parcel in) {
    }

    public static final Creator<Temp> CREATOR = new Creator<Temp>() {
        @Override
        public Temp createFromParcel(Parcel in) {
            return new Temp(in);
        }

        @Override
        public Temp[] newArray(int size) {
            return new Temp[size];
        }
    };

    /**
     *
     * @return
     * The day
     */
    public Float getDay() {
        return day;
    }

    /**
     *
     * @param day
     * The day
     */
    public void setDay(Float day) {
        this.day = day;
    }

    public Temp withDay(Float day) {
        this.day = day;
        return this;
    }

    /**
     *
     * @return
     * The min
     */
    public Float getMin() {
        return min;
    }

    /**
     *
     * @param min
     * The min
     */
    public void setMin(Float min) {
        this.min = min;
    }

    public Temp withMin(Float min) {
        this.min = min;
        return this;
    }

    /**
     *
     * @return
     * The max
     */
    public Float getMax() {
        return max;
    }

    /**
     *
     * @param max
     * The max
     */
    public void setMax(Float max) {
        this.max = max;
    }

    public Temp withMax(Float max) {
        this.max = max;
        return this;
    }

    /**
     *
     * @return
     * The night
     */
    public Float getNight() {
        return night;
    }

    /**
     *
     * @param night
     * The night
     */
    public void setNight(Float night) {
        this.night = night;
    }

    public Temp withNight(Float night) {
        this.night = night;
        return this;
    }

    /**
     *
     * @return
     * The eve
     */
    public Float getEve() {
        return eve;
    }

    /**
     *
     * @param eve
     * The eve
     */
    public void setEve(Float eve) {
        this.eve = eve;
    }

    public Temp withEve(Float eve) {
        this.eve = eve;
        return this;
    }

    /**
     *
     * @return
     * The morn
     */
    public Float getMorn() {
        return morn;
    }

    /**
     *
     * @param morn
     * The morn
     */
    public void setMorn(Float morn) {
        this.morn = morn;
    }

    public Temp withMorn(Float morn) {
        this.morn = morn;
        return this;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}