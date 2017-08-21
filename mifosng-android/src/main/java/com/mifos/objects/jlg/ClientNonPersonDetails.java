package com.mifos.objects.jlg;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Tarun on 21-08-17.
 */

public class ClientNonPersonDetails implements Parcelable {

    private Constitution constitution;

    private MainBusinessLine mainBusinessLine;

    public Constitution getConstitution() {
        return constitution;
    }

    public void setConstitution(Constitution constitution) {
        this.constitution = constitution;
    }

    public MainBusinessLine getMainBusinessLine() {
        return mainBusinessLine;
    }

    public void setMainBusinessLine(MainBusinessLine mainBusinessLine) {
        this.mainBusinessLine = mainBusinessLine;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.constitution, flags);
        dest.writeParcelable(this.mainBusinessLine, flags);
    }

    public ClientNonPersonDetails() {
    }

    protected ClientNonPersonDetails(Parcel in) {
        this.constitution = in.readParcelable(Constitution.class.getClassLoader());
        this.mainBusinessLine = in.readParcelable(MainBusinessLine.class.getClassLoader());
    }

    public static final Parcelable.Creator<ClientNonPersonDetails> CREATOR = new
            Parcelable.Creator<ClientNonPersonDetails>() {
        @Override
        public ClientNonPersonDetails createFromParcel(Parcel source) {
            return new ClientNonPersonDetails(source);
        }

        @Override
        public ClientNonPersonDetails[] newArray(int size) {
            return new ClientNonPersonDetails[size];
        }
    };
}
