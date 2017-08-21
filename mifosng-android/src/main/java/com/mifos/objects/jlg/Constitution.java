package com.mifos.objects.jlg;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Tarun on 21-08-17.
 */

public class Constitution implements Parcelable {

    private boolean active;

    private int id;

    private boolean mandatory;

    private String name;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isMandatory() {
        return mandatory;
    }

    public void setMandatory(boolean mandatory) {
        this.mandatory = mandatory;
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
        dest.writeByte(this.active ? (byte) 1 : (byte) 0);
        dest.writeInt(this.id);
        dest.writeByte(this.mandatory ? (byte) 1 : (byte) 0);
        dest.writeString(this.name);
    }

    public Constitution() {
    }

    protected Constitution(Parcel in) {
        this.active = in.readByte() != 0;
        this.id = in.readInt();
        this.mandatory = in.readByte() != 0;
        this.name = in.readString();
    }

    public static final Parcelable.Creator<Constitution> CREATOR = new
            Parcelable.Creator<Constitution>() {
        @Override
        public Constitution createFromParcel(Parcel source) {
            return new Constitution(source);
        }

        @Override
        public Constitution[] newArray(int size) {
            return new Constitution[size];
        }
    };
}
