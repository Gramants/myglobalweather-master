package mvp.globalweather.cleanarchitecture.stefano.model.cities;

import android.os.Parcel;
import android.os.Parcelable;

public class Postalcodes implements Parcelable
{
    private String adminCode2;

    private String adminCode1;

    private String adminName2;

    private double lng;

    private String countryCode;

    private String postalCode;

    private String adminName1;

    private String placeName;

    private double lat;

    protected Postalcodes(Parcel in) {
        adminCode2 = in.readString();
        adminCode1 = in.readString();
        adminName2 = in.readString();
        lng = in.readDouble();
        countryCode = in.readString();
        postalCode = in.readString();
        adminName1 = in.readString();
        placeName = in.readString();
        lat = in.readDouble();
    }

    public static final Creator<Postalcodes> CREATOR = new Creator<Postalcodes>() {
        @Override
        public Postalcodes createFromParcel(Parcel in) {
            return new Postalcodes(in);
        }

        @Override
        public Postalcodes[] newArray(int size) {
            return new Postalcodes[size];
        }
    };

    public void setAdminCode2(String adminCode2){
        this.adminCode2 = adminCode2;
    }
    public String getAdminCode2(){
        return this.adminCode2;
    }
    public void setAdminCode1(String adminCode1){
        this.adminCode1 = adminCode1;
    }
    public String getAdminCode1(){
        return this.adminCode1;
    }
    public void setAdminName2(String adminName2){
        this.adminName2 = adminName2;
    }
    public String getAdminName2(){
        return this.adminName2;
    }
    public void setLng(double lng){
        this.lng = lng;
    }
    public double getLng(){
        return this.lng;
    }
    public void setCountryCode(String countryCode){
        this.countryCode = countryCode;
    }
    public String getCountryCode(){
        return this.countryCode;
    }
    public void setPostalCode(String postalCode){
        this.postalCode = postalCode;
    }
    public String getPostalCode(){
        return this.postalCode;
    }
    public void setAdminName1(String adminName1){
        this.adminName1 = adminName1;
    }
    public String getAdminName1(){
        return this.adminName1;
    }
    public void setPlaceName(String placeName){
        this.placeName = placeName;
    }
    public String getPlaceName(){
        return this.placeName;
    }
    public void setLat(double lat){
        this.lat = lat;
    }
    public double getLat(){
        return this.lat;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(adminCode2);
        dest.writeString(adminCode1);
        dest.writeString(adminName2);
        dest.writeDouble(lng);
        dest.writeString(countryCode);
        dest.writeString(postalCode);
        dest.writeString(adminName1);
        dest.writeString(placeName);
        dest.writeDouble(lat);
    }
}