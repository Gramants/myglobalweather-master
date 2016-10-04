package mvp.globalweather.cleanarchitecture.stefano.model.daily;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Coord implements Parcelable{

    @SerializedName("lon")
    @Expose
    private Float lon;
    @SerializedName("lat")
    @Expose
    private Float lat;

    /**
     * No args constructor for use in serialization
     *
     */
    public Coord() {
    }

    /**
     *
     * @param lon
     * @param lat
     */
    public Coord(Float lon, Float lat) {
        this.lon = lon;
        this.lat = lat;
    }

    protected Coord(Parcel in) {
    }

    public static final Creator<Coord> CREATOR = new Creator<Coord>() {
        @Override
        public Coord createFromParcel(Parcel in) {
            return new Coord(in);
        }

        @Override
        public Coord[] newArray(int size) {
            return new Coord[size];
        }
    };

    /**
     *
     * @return
     * The lon
     */
    public Float getLon() {
        return lon;
    }

    /**
     *
     * @param lon
     * The lon
     */
    public void setLon(Float lon) {
        this.lon = lon;
    }

    public Coord withLon(Float lon) {
        this.lon = lon;
        return this;
    }

    /**
     *
     * @return
     * The lat
     */
    public Float getLat() {
        return lat;
    }

    /**
     *
     * @param lat
     * The lat
     */
    public void setLat(Float lat) {
        this.lat = lat;
    }

    public Coord withLat(Float lat) {
        this.lat = lat;
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