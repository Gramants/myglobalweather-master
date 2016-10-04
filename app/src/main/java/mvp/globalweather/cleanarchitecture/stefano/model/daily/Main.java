package mvp.globalweather.cleanarchitecture.stefano.model.daily;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Main implements Parcelable{

    @SerializedName("temp")
    @Expose
    private Float temp;
    @SerializedName("temp_min")
    @Expose
    private Float tempMin;
    @SerializedName("temp_max")
    @Expose
    private Float tempMax;
    @SerializedName("pressure")
    @Expose
    private Float pressure;
    @SerializedName("sea_level")
    @Expose
    private Float seaLevel;
    @SerializedName("grnd_level")
    @Expose
    private Float grndLevel;
    @SerializedName("humidity")
    @Expose
    private Integer humidity;
    @SerializedName("temp_kf")
    @Expose
    private Integer tempKf;

    /**
     * No args constructor for use in serialization
     *
     */
    public Main() {
    }

    /**
     *
     * @param seaLevel
     * @param humidity
     * @param pressure
     * @param grndLevel
     * @param tempMax
     * @param temp
     * @param tempKf
     * @param tempMin
     */
    public Main(Float temp, Float tempMin, Float tempMax, Float pressure, Float seaLevel, Float grndLevel, Integer humidity, Integer tempKf) {
        this.temp = temp;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.pressure = pressure;
        this.seaLevel = seaLevel;
        this.grndLevel = grndLevel;
        this.humidity = humidity;
        this.tempKf = tempKf;
    }

    protected Main(Parcel in) {
    }

    public static final Creator<Main> CREATOR = new Creator<Main>() {
        @Override
        public Main createFromParcel(Parcel in) {
            return new Main(in);
        }

        @Override
        public Main[] newArray(int size) {
            return new Main[size];
        }
    };

    /**
     *
     * @return
     * The temp
     */
    public Float getTemp() {
        return temp;
    }

    /**
     *
     * @param temp
     * The temp
     */
    public void setTemp(Float temp) {
        this.temp = temp;
    }

    public Main withTemp(Float temp) {
        this.temp = temp;
        return this;
    }

    /**
     *
     * @return
     * The tempMin
     */
    public Float getTempMin() {
        return tempMin;
    }

    /**
     *
     * @param tempMin
     * The temp_min
     */
    public void setTempMin(Float tempMin) {
        this.tempMin = tempMin;
    }

    public Main withTempMin(Float tempMin) {
        this.tempMin = tempMin;
        return this;
    }

    /**
     *
     * @return
     * The tempMax
     */
    public Float getTempMax() {
        return tempMax;
    }

    /**
     *
     * @param tempMax
     * The temp_max
     */
    public void setTempMax(Float tempMax) {
        this.tempMax = tempMax;
    }

    public Main withTempMax(Float tempMax) {
        this.tempMax = tempMax;
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

    public Main withPressure(Float pressure) {
        this.pressure = pressure;
        return this;
    }

    /**
     *
     * @return
     * The seaLevel
     */
    public Float getSeaLevel() {
        return seaLevel;
    }

    /**
     *
     * @param seaLevel
     * The sea_level
     */
    public void setSeaLevel(Float seaLevel) {
        this.seaLevel = seaLevel;
    }

    public Main withSeaLevel(Float seaLevel) {
        this.seaLevel = seaLevel;
        return this;
    }

    /**
     *
     * @return
     * The grndLevel
     */
    public Float getGrndLevel() {
        return grndLevel;
    }

    /**
     *
     * @param grndLevel
     * The grnd_level
     */
    public void setGrndLevel(Float grndLevel) {
        this.grndLevel = grndLevel;
    }

    public Main withGrndLevel(Float grndLevel) {
        this.grndLevel = grndLevel;
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

    public Main withHumidity(Integer humidity) {
        this.humidity = humidity;
        return this;
    }

    /**
     *
     * @return
     * The tempKf
     */
    public Integer getTempKf() {
        return tempKf;
    }

    /**
     *
     * @param tempKf
     * The temp_kf
     */
    public void setTempKf(Integer tempKf) {
        this.tempKf = tempKf;
    }

    public Main withTempKf(Integer tempKf) {
        this.tempKf = tempKf;
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