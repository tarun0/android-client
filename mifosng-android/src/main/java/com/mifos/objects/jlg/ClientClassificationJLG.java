package com.mifos.objects.jlg;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Tarun on 21-08-17.
 */

public class ClientClassificationJLG implements Parcelable {

    private boolean active;

    private boolean mandatory;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isMandatory() {
        return mandatory;
    }

    public void setMandatory(boolean mandatory) {
        this.mandatory = mandatory;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte(this.active ? (byte) 1 : (byte) 0);
        dest.writeByte(this.mandatory ? (byte) 1 : (byte) 0);
    }

    public ClientClassificationJLG() {
    }

    protected ClientClassificationJLG(Parcel in) {
        this.active = in.readByte() != 0;
        this.mandatory = in.readByte() != 0;
    }

    public static final Parcelable.Creator<ClientClassificationJLG> CREATOR = new
            Parcelable.Creator<ClientClassificationJLG>() {
        @Override
        public ClientClassificationJLG createFromParcel(Parcel source) {
            return new ClientClassificationJLG(source);
        }

        @Override
        public ClientClassificationJLG[] newArray(int size) {
            return new ClientClassificationJLG[size];
        }
    };
}
