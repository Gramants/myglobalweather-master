package mvp.globalweather.cleanarchitecture.stefano.model.daily;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sys implements Parcelable {

    @SerializedName("population")
    @Expose
    private Integer population;

    /**
     * No args constructor for use in serialization
     *
     */
    public Sys() {
    }

    /**
     *
     * @param population
     */
    public Sys(Integer population) {
        this.population = population;
    }

    protected Sys(Parcel in) {
    }

    public static final Creator<Sys> CREATOR = new Creator<Sys>() {
        @Override
        public Sys createFromParcel(Parcel in) {
            return new Sys(in);
        }

        @Override
        public Sys[] newArray(int size) {
            return new Sys[size];
        }
    };

    /**
     *
     * @return
     * The population
     */
    public Integer getPopulation() {
        return population;
    }

    /**
     *
     * @param population
     * The population
     */
    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Sys withPopulation(Integer population) {
        this.population = population;
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

