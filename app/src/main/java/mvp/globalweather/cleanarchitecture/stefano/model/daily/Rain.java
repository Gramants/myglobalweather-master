package mvp.globalweather.cleanarchitecture.stefano.model.daily;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rain implements Parcelable {

    @SerializedName("3h")
    @Expose
    private Float _3h;

    /**
     * No args constructor for use in serialization
     *
     */
    public Rain() {
    }

    /**
     *
     * @param _3h
     */
    public Rain(Float _3h) {
        this._3h = _3h;
    }

    protected Rain(Parcel in) {
    }

    public static final Creator<Rain> CREATOR = new Creator<Rain>() {
        @Override
        public Rain createFromParcel(Parcel in) {
            return new Rain(in);
        }

        @Override
        public Rain[] newArray(int size) {
            return new Rain[size];
        }
    };

    /**
     *
     * @return
     * The _3h
     */
    public Float get3h() {
        return _3h;
    }

    /**
     *
     * @param _3h
     * The 3h
     */
    public void set3h(Float _3h) {
        this._3h = _3h;
    }

    public Rain with3h(Float _3h) {
        this._3h = _3h;
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
