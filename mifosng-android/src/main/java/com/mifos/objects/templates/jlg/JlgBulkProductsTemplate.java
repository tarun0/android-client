package com.mifos.objects.templates.jlg;

import android.os.Parcel;
import android.os.Parcelable;

import com.mifos.objects.templates.loans.CalendarOptions;
import com.mifos.objects.templates.loans.LoanOfficerOptions;
import com.mifos.objects.templates.loans.ProductOptions;
import com.mifos.objects.templates.loans.Timeline;

import java.util.List;

/**
 * Created by Tarun on 17-08-17.
 */

public class JlgBulkProductsTemplate implements Parcelable {

    private List<CalendarOptions> calendarOptions;

    private boolean canDisburse;

    private boolean isFloatingInterestRate;

    private boolean isInterestRecalculationEnabled;

    private boolean isLoanProductLinkedToFloatingRate;

    private boolean isTopup;

    private boolean isVariableInstallmentsAllowed;

    private List<LoanOfficerOptions> loanOfficerOptions;

    private List<ProductOptions> productOptions;

    private Timeline timeline;

    public List<CalendarOptions> getCalendarOptions() {
        return calendarOptions;
    }

    public void setCalendarOptions(List<CalendarOptions> calendarOptions) {
        this.calendarOptions = calendarOptions;
    }

    public boolean isCanDisburse() {
        return canDisburse;
    }

    public void setCanDisburse(boolean canDisburse) {
        this.canDisburse = canDisburse;
    }

    public boolean isFloatingInterestRate() {
        return isFloatingInterestRate;
    }

    public void setFloatingInterestRate(boolean floatingInterestRate) {
        isFloatingInterestRate = floatingInterestRate;
    }

    public boolean isInterestRecalculationEnabled() {
        return isInterestRecalculationEnabled;
    }

    public void setInterestRecalculationEnabled(boolean interestRecalculationEnabled) {
        isInterestRecalculationEnabled = interestRecalculationEnabled;
    }

    public boolean isLoanProductLinkedToFloatingRate() {
        return isLoanProductLinkedToFloatingRate;
    }

    public void setLoanProductLinkedToFloatingRate(boolean loanProductLinkedToFloatingRate) {
        isLoanProductLinkedToFloatingRate = loanProductLinkedToFloatingRate;
    }

    public boolean isTopup() {
        return isTopup;
    }

    public void setTopup(boolean topup) {
        isTopup = topup;
    }

    public boolean isVariableInstallmentsAllowed() {
        return isVariableInstallmentsAllowed;
    }

    public void setVariableInstallmentsAllowed(boolean variableInstallmentsAllowed) {
        isVariableInstallmentsAllowed = variableInstallmentsAllowed;
    }

    public List<LoanOfficerOptions> getLoanOfficerOptions() {
        return loanOfficerOptions;
    }

    public void setLoanOfficerOptions(List<LoanOfficerOptions> loanOfficerOptions) {
        this.loanOfficerOptions = loanOfficerOptions;
    }

    public List<ProductOptions> getProductOptions() {
        return productOptions;
    }

    public void setProductOptions(List<ProductOptions> productOptions) {
        this.productOptions = productOptions;
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
        dest.writeTypedList(this.calendarOptions);
        dest.writeByte(this.canDisburse ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isFloatingInterestRate ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isInterestRecalculationEnabled ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isLoanProductLinkedToFloatingRate ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isTopup ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isVariableInstallmentsAllowed ? (byte) 1 : (byte) 0);
        dest.writeTypedList(this.loanOfficerOptions);
        dest.writeTypedList(this.productOptions);
        dest.writeParcelable(this.timeline, flags);
    }

    public JlgBulkProductsTemplate() {
    }

    protected JlgBulkProductsTemplate(Parcel in) {
        this.calendarOptions = in.createTypedArrayList(CalendarOptions.CREATOR);
        this.canDisburse = in.readByte() != 0;
        this.isFloatingInterestRate = in.readByte() != 0;
        this.isInterestRecalculationEnabled = in.readByte() != 0;
        this.isLoanProductLinkedToFloatingRate = in.readByte() != 0;
        this.isTopup = in.readByte() != 0;
        this.isVariableInstallmentsAllowed = in.readByte() != 0;
        this.loanOfficerOptions = in.createTypedArrayList(LoanOfficerOptions.CREATOR);
        this.productOptions = in.createTypedArrayList(ProductOptions.CREATOR);
        this.timeline = in.readParcelable(Timeline.class.getClassLoader());
    }

    public static final Parcelable.Creator<JlgBulkProductsTemplate> CREATOR = new
            Parcelable.Creator<JlgBulkProductsTemplate>() {
        @Override
        public JlgBulkProductsTemplate createFromParcel(Parcel source) {
            return new JlgBulkProductsTemplate(source);
        }

        @Override
        public JlgBulkProductsTemplate[] newArray(int size) {
            return new JlgBulkProductsTemplate[size];
        }
    };
}
