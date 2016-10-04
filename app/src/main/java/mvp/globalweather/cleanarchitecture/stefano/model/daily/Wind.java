package mvp.globalweather.cleanarchitecture.stefano.model.daily;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Wind  implements Parcelable {

    @SerializedName("speed")
    @Expose
    private Float speed;
    @SerializedName("deg")
    @Expose
    private Float deg;

    /**
     * No args constructor for use in serialization
     *
     */
    public Wind() {
    }

    /**
     *
     * @param speed
     * @param deg
     */
    public Wind(Float speed, Float deg) {
        this.speed = speed;
        this.deg = deg;
    }

    protected Wind(Parcel in) {
    }

    public static final Creator<Wind> CREATOR = new Creator<Wind>() {
        @Override
        public Wind createFromParcel(Parcel in) {
            return new Wind(in);
        }

        @Override
        public Wind[] newArray(int size) {
            return new Wind[size];
        }
    };

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

    public Wind withSpeed(Float speed) {
        this.speed = speed;
        return this;
    }

    /**
     *
     * @return
     * The deg
     */
    public Float getDeg() {
        return deg;
    }

    /**
     *
     * @param deg
     * The deg
     */
    public void setDeg(Float deg) {
        this.deg = deg;
    }

    public Wind withDeg(Float deg) {
        this.deg = deg;
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