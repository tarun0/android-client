package com.mifos.objects.templates.jlg;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Tarun on 17-08-17.
 */

public class MemberVariation implements Parcelable {

    private int interestRatePerPeriod;

    private int numberOfRepayments;

    private Double principal;

    private int termFrequency;

    public int getInterestRatePerPeriod() {
        return interestRatePerPeriod;
    }

    public void setInterestRatePerPeriod(int interestRatePerPeriod) {
        this.interestRatePerPeriod = interestRatePerPeriod;
    }

    public int getNumberOfRepayments() {
        return numberOfRepayments;
    }

    public void setNumberOfRepayments(int numberOfRepayments) {
        this.numberOfRepayments = numberOfRepayments;
    }

    public Double getPrincipal() {
        return principal;
    }

    public void setPrincipal(Double principal) {
        this.principal = principal;
    }

    public int getTermFrequency() {
        return termFrequency;
    }

    public void setTermFrequency(int termFrequency) {
        this.termFrequency = termFrequency;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.interestRatePerPeriod);
        dest.writeInt(this.numberOfRepayments);
        dest.writeValue(this.principal);
        dest.writeInt(this.termFrequency);
    }

    public MemberVariation() {
    }

    protected MemberVariation(Parcel in) {
        this.interestRatePerPeriod = in.readInt();
        this.numberOfRepayments = in.readInt();
        this.principal = (Double) in.readValue(Double.class.getClassLoader());
        this.termFrequency = in.readInt();
    }

    public static final Parcelable.Creator<MemberVariation> CREATOR = new
            Parcelable.Creator<MemberVariation>() {
        @Override
        public MemberVariation createFromParcel(Parcel source) {
            return new MemberVariation(source);
        }

        @Override
        public MemberVariation[] newArray(int size) {
            return new MemberVariation[size];
        }
    };
}
