package com.mifos.objects.jlg;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Tarun on 21-08-17.
 */

public class LegalForm implements Parcelable {

    private String code;

    private int id;

    private String value;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.code);
        dest.writeInt(this.id);
        dest.writeString(this.value);
    }

    public LegalForm() {
    }

    protected LegalForm(Parcel in) {
        this.code = in.readString();
        this.id = in.readInt();
        this.value = in.readString();
    }

    public static final Parcelable.Creator<LegalForm> CREATOR = new Parcelable.Creator<LegalForm>() {
        @Override
        public LegalForm createFromParcel(Parcel source) {
            return new LegalForm(source);
        }

        @Override
        public LegalForm[] newArray(int size) {
            return new LegalForm[size];
        }
    };
}
