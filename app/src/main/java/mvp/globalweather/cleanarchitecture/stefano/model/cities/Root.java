package mvp.globalweather.cleanarchitecture.stefano.model.cities;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Root implements Parcelable
{
    private List<Postalcodes> postalCodes;

    protected Root(Parcel in) {
        postalCodes = in.createTypedArrayList(Postalcodes.CREATOR);
    }

    public static final Creator<Root> CREATOR = new Creator<Root>() {
        @Override
        public Root createFromParcel(Parcel in) {
            return new Root(in);
        }

        @Override
        public Root[] newArray(int size) {
            return new Root[size];
        }
    };

    public void setPostalCodes(List<Postalcodes> postalCodes){
        this.postalCodes = postalCodes;
    }
    public List<Postalcodes> getPostalCodes(){
        return this.postalCodes;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(postalCodes);
    }
}