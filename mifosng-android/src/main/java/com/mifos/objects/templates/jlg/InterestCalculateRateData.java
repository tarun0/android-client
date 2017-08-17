package com.mifos.objects.templates.jlg;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Tarun on 17-08-17.
 */

public class InterestCalculateRateData implements Parcelable {

    // Add details here about the data members.


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    public InterestCalculateRateData() {
    }

    protected InterestCalculateRateData(Parcel in) {
    }

    public static final Parcelable.Creator<InterestCalculateRateData> CREATOR = new
            Parcelable.Creator<InterestCalculateRateData>() {
        @Override
        public InterestCalculateRateData createFromParcel(Parcel source) {
            return new InterestCalculateRateData(source);
        }

        @Override
        public InterestCalculateRateData[] newArray(int size) {
            return new InterestCalculateRateData[size];
        }
    };
}
