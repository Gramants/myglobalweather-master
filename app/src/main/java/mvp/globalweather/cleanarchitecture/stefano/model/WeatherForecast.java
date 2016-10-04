package mvp.globalweather.cleanarchitecture.stefano.model;

public class WeatherForecast {

    private final long mTimestamp;
    private final String mDescription;
    private final float mMinimumTemperature;
    private final float mMaximumTemperature;

    public WeatherForecast(
                           final long timestamp,
                           final String description,
                           final float minimumTemperature,
                           final float maximumTemperature) {


        mTimestamp = timestamp;
        mMinimumTemperature = minimumTemperature;
        mMaximumTemperature = maximumTemperature;
        mDescription = description;
    }



    public long getTimestamp() {
        return mTimestamp;
    }

    public String getDescription() {
        return mDescription;
    }

    public float getMinimumTemperature() {
        return mMinimumTemperature;
    }

    public float getMaximumTemperature() {
        return mMaximumTemperature;
    }
}