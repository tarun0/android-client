package com.mifos.objects.jlg;

import android.os.Parcel;
import android.os.Parcelable;

import com.mifos.objects.accounts.loan.Status;
import com.mifos.objects.templates.loans.Timeline;

/**
 * Created by Tarun on 21-08-17.
 */

public class ClientJLG implements Parcelable {

    private String accountNo;

    private int[] activationDate;

    private boolean active;

    private ClientClassificationJLG clientClassification;

    private ClientNonPersonDetails clientNonPersonDetails;

    private ClientType clientType;

    private String displayName;

    private String fullName;

    private Gender gender;

    private int id;

    private boolean isStaff;

    private LegalForm legalForm;

    private int officeId;

    private String officeName;

    private int staffId;

    private String staffName;

    private Status status;

    private SubStatus subStatus;

    private Timeline timeline;

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accoutNo) {
        this.accountNo = accoutNo;
    }

    public int[] getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(int[] activationDate) {
        this.activationDate = activationDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public ClientClassificationJLG getClientClassification() {
        return clientClassification;
    }

    public void setClientClassification(ClientClassificationJLG clientClassification) {
        this.clientClassification = clientClassification;
    }

    public ClientNonPersonDetails getClientNonPersonDetails() {
        return clientNonPersonDetails;
    }

    public void setClientNonPersonDetails(ClientNonPersonDetails clientNonPersonDetails) {
        this.clientNonPersonDetails = clientNonPersonDetails;
    }

    public ClientType getClientType() {
        return clientType;
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isStaff() {
        return isStaff;
    }

    public void setStaff(boolean staff) {
        isStaff = staff;
    }

    public LegalForm getLegalForm() {
        return legalForm;
    }

    public void setLegalForm(LegalForm legalForm) {
        this.legalForm = legalForm;
    }

    public int getOfficeId() {
        return officeId;
    }

    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public SubStatus getSubStatus() {
        return subStatus;
    }

    public void setSubStatus(SubStatus subStatus) {
        this.subStatus = subStatus;
    }

    public Timeline getTimeline() {
        return timeline;
    }

    public void setTimeline(Timeline timeline) {
        this.timeline = timeline;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.accountNo);
        dest.writeIntArray(this.activationDate);
        dest.writeByte(this.active ? (byte) 1 : (byte) 0);
        dest.writeParcelable(this.clientClassification, flags);
        dest.writeParcelable(this.clientNonPersonDetails, flags);
        dest.writeParcelable(this.clientType, flags);
        dest.writeString(this.displayName);
        dest.writeString(this.fullName);
        dest.writeParcelable(this.gender, flags);
        dest.writeInt(this.id);
        dest.writeByte(this.isStaff ? (byte) 1 : (byte) 0);
        dest.writeParcelable(this.legalForm, flags);
        dest.writeInt(this.officeId);
        dest.writeString(this.officeName);
        dest.writeInt(this.staffId);
        dest.writeString(this.staffName);
        dest.writeParcelable(this.status, flags);
        dest.writeParcelable(this.subStatus, flags);
        dest.writeParcelable(this.timeline, flags);
    }

    public ClientJLG() {
    }

    protected ClientJLG(Parcel in) {
        this.accountNo = in.readString();
        this.activationDate = in.createIntArray();
        this.active = in.readByte() != 0;
        this.clientClassification = in.readParcelable(ClientClassificationJLG.class
                .getClassLoader());
        this.clientNonPersonDetails = in.readParcelable(ClientNonPersonDetails.class
                .getClassLoader());
        this.clientType = in.readParcelable(ClientType.class.getClassLoader());
        this.displayName = in.readString();
        this.fullName = in.readString();
        this.gender = in.readParcelable(Gender.class.getClassLoader());
        this.id = in.readInt();
        this.isStaff = in.readByte() != 0;
        this.legalForm = in.readParcelable(LegalForm.class.getClassLoader());
        this.officeId = in.readInt();
        this.officeName = in.readString();
        this.staffId = in.readInt();
        this.staffName = in.readString();
        this.status = in.readParcelable(Status.class.getClassLoader());
        this.subStatus = in.readParcelable(SubStatus.class.getClassLoader());
        this.timeline = in.readParcelable(Timeline.class.getClassLoader());
    }

    public static final Parcelable.Creator<ClientJLG> CREATOR = new
            Parcelable.Creator<ClientJLG>() {
        @Override
        public ClientJLG createFromParcel(Parcel source) {
            return new ClientJLG(source);
        }

        @Override
        public ClientJLG[] newArray(int size) {
            return new ClientJLG[size];
        }
    };
}
