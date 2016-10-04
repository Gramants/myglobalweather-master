package mvp.globalweather.cleanarchitecture.stefano.model.daily;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sys_ implements Parcelable{

    @SerializedName("pod")
    @Expose
    private String pod;

    /**
     * No args constructor for use in serialization
     *
     */
    public Sys_() {
    }

    /**
     *
     * @param pod
     */
    public Sys_(String pod) {
        this.pod = pod;
    }

    protected Sys_(Parcel in) {
        pod = in.readString();
    }

    public static final Creator<Sys_> CREATOR = new Creator<Sys_>() {
        @Override
        public Sys_ createFromParcel(Parcel in) {
            return new Sys_(in);
        }

        @Override
        public Sys_[] newArray(int size) {
            return new Sys_[size];
        }
    };

    /**
     *
     * @return
     * The pod
     */
    public String getPod() {
        return pod;
    }

    /**
     *
     * @param pod
     * The pod
     */
    public void setPod(String pod) {
        this.pod = pod;
    }

    public Sys_ withPod(String pod) {
        this.pod = pod;
        return this;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(pod);
    }
}
