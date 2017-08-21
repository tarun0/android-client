package com.mifos.objects.jlg;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Tarun on 21-08-17.
 */

public class FundOptionsJLG implements Parcelable {

    private int id;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
    }

    public FundOptionsJLG() {
    }

    protected FundOptionsJLG(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
    }

    public static final Parcelable.Creator<FundOptionsJLG> CREATOR = new
            Parcelable.Creator<FundOptionsJLG>() {
        @Override
        public FundOptionsJLG createFromParcel(Parcel source) {
            return new FundOptionsJLG(source);
        }

        @Override
        public FundOptionsJLG[] newArray(int size) {
            return new FundOptionsJLG[size];
        }
    };
}
