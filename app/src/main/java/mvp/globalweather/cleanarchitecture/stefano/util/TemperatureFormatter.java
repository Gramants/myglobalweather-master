package mvp.globalweather.cleanarchitecture.stefano.util;

public class TemperatureFormatter {

    public static String formatTemp(float temperature) {
        return String.valueOf(Math.round(temperature)) + "°";
    }
}
