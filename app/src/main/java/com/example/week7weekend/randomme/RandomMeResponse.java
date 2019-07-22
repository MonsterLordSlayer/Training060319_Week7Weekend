
package com.example.week7weekend.randomme;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RandomMeResponse implements Parcelable
{

    @SerializedName("results")
    @Expose
    private List<Result> results = null;
    @SerializedName("info")
    @Expose
    private Info info;
    public final static Creator<RandomMeResponse> CREATOR = new Creator<RandomMeResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public RandomMeResponse createFromParcel(Parcel in) {
            return new RandomMeResponse(in);
        }

        public RandomMeResponse[] newArray(int size) {
            return (new RandomMeResponse[size]);
        }

    }
    ;

    protected RandomMeResponse(Parcel in) {
        in.readList(this.results, (Result.class.getClassLoader()));
        this.info = ((Info) in.readValue((Info.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public RandomMeResponse() {
    }

    /**
     * 
     * @param results
     * @param info
     */
    public RandomMeResponse(List<Result> results, Info info) {
        super();
        this.results = results;
        this.info = info;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(results);
        dest.writeValue(info);
    }

    public int describeContents() {
        return  0;
    }

}
