package com.mifos.objects.jlg;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Tarun on 21-08-17.
 */

public class LoanPurposeOptions implements Parcelable {

    private int id;

    private boolean active;

    private String name;

    private int position;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeByte(this.active ? (byte) 1 : (byte) 0);
        dest.writeString(this.name);
        dest.writeInt(this.position);
    }

    public LoanPurposeOptions() {
    }

    protected LoanPurposeOptions(Parcel in) {
        this.id = in.readInt();
        this.active = in.readByte() != 0;
        this.name = in.readString();
        this.position = in.readInt();
    }

    public static final Parcelable.Creator<LoanPurposeOptions> CREATOR = new Parcelable.Creator<LoanPurposeOptions>() {
        @Override
        public LoanPurposeOptions createFromParcel(Parcel source) {
            return new LoanPurposeOptions(source);
        }

        @Override
        public LoanPurposeOptions[] newArray(int size) {
            return new LoanPurposeOptions[size];
        }
    };
}
