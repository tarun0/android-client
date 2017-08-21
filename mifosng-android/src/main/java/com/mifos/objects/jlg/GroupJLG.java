package com.mifos.objects.jlg;

import android.os.Parcel;
import android.os.Parcelable;

import com.mifos.objects.accounts.loan.Status;
import com.mifos.objects.templates.loans.Timeline;

import java.util.List;

/**
 * Created by Tarun on 21-08-17.
 */

public class GroupJLG implements Parcelable {

    private String accountNo;

    private int[] activationDate;

    private boolean active;

    private int centerId;

    private String centerName;

    private List<ClientJLG> clientMembers;

    private String groupLevel;

    private String hierarchy;

    private int id;

    private String name;

    private int officeId;

    private String officeName;

    private int staffId;

    private String staffName;

    private Status status;

    private Timeline timeline;

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
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

    public int getCenterId() {
        return centerId;
    }

    public void setCenterId(int centerId) {
        this.centerId = centerId;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public List<ClientJLG> getClientMembers() {
        return clientMembers;
    }

    public void setClientMembers(List<ClientJLG> clientMembers) {
        this.clientMembers = clientMembers;
    }

    public String getGroupLevel() {
        return groupLevel;
    }

    public void setGroupLevel(String groupLevel) {
        this.groupLevel = groupLevel;
    }

    public String getHierarchy() {
        return hierarchy;
    }

    public void setHierarchy(String hierarchy) {
        this.hierarchy = hierarchy;
    }

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
        dest.writeInt(this.centerId);
        dest.writeString(this.centerName);
        dest.writeTypedList(this.clientMembers);
        dest.writeString(this.groupLevel);
        dest.writeString(this.hierarchy);
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeInt(this.officeId);
        dest.writeString(this.officeName);
        dest.writeInt(this.staffId);
        dest.writeString(this.staffName);
        dest.writeParcelable(this.status, flags);
        dest.writeParcelable(this.timeline, flags);
    }

    public GroupJLG() {
    }

    protected GroupJLG(Parcel in) {
        this.accountNo = in.readString();
        this.activationDate = in.createIntArray();
        this.active = in.readByte() != 0;
        this.centerId = in.readInt();
        this.centerName = in.readString();
        this.clientMembers = in.createTypedArrayList(ClientJLG.CREATOR);
        this.groupLevel = in.readString();
        this.hierarchy = in.readString();
        this.id = in.readInt();
        this.name = in.readString();
        this.officeId = in.readInt();
        this.officeName = in.readString();
        this.staffId = in.readInt();
        this.staffName = in.readString();
        this.status = in.readParcelable(Status.class.getClassLoader());
        this.timeline = in.readParcelable(Timeline.class.getClassLoader());
    }

    public static final Parcelable.Creator<GroupJLG> CREATOR = new Parcelable.Creator<GroupJLG>() {
        @Override
        public GroupJLG createFromParcel(Parcel source) {
            return new GroupJLG(source);
        }

        @Override
        public GroupJLG[] newArray(int size) {
            return new GroupJLG[size];
        }
    };
}
