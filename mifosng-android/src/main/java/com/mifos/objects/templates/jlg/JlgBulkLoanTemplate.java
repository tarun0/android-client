package com.mifos.objects.templates.jlg;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import com.mifos.objects.accounts.loan.AccountLinkingOptions;
import com.mifos.objects.templates.loans.AmortizationType;
import com.mifos.objects.templates.loans.AmortizationTypeOptions;
import com.mifos.objects.templates.loans.CalendarOptions;
import com.mifos.objects.templates.loans.ChargeOptions;
import com.mifos.objects.templates.loans.Charges;
import com.mifos.objects.templates.loans.Currency;
import com.mifos.objects.templates.loans.DaysInMonthType;
import com.mifos.objects.templates.loans.DaysInYearType;
import com.mifos.objects.templates.loans.FundOptions;
import com.mifos.objects.templates.loans.Group;
import com.mifos.objects.templates.loans.InterestCalculationPeriodType;
import com.mifos.objects.templates.loans.InterestCalculationPeriodTypeOptions;
import com.mifos.objects.templates.loans.InterestRateFrequencyType;
import com.mifos.objects.templates.loans.InterestRateFrequencyTypeOptions;
import com.mifos.objects.templates.loans.InterestType;
import com.mifos.objects.templates.loans.InterestTypeOptions;
import com.mifos.objects.templates.loans.LoanCollateralOptions;
import com.mifos.objects.templates.loans.LoanOfficerOptions;
import com.mifos.objects.templates.loans.LoanPurposeOptions;
import com.mifos.objects.templates.loans.OverdueCharges;
import com.mifos.objects.templates.loans.Product;
import com.mifos.objects.templates.loans.ProductOptions;
import com.mifos.objects.templates.loans.RepaymentFrequencyDaysOfWeekTypeOptions;
import com.mifos.objects.templates.loans.RepaymentFrequencyNthDayTypeOptions;
import com.mifos.objects.templates.loans.RepaymentFrequencyType;
import com.mifos.objects.templates.loans.RepaymentFrequencyTypeOptions;
import com.mifos.objects.templates.loans.TermFrequencyTypeOptions;
import com.mifos.objects.templates.loans.TermPeriodFrequencyType;
import com.mifos.objects.templates.loans.Timeline;
import com.mifos.objects.templates.loans.TransactionProcessingStrategyOptions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tarun on 17-08-17.
 */

public class JlgBulkLoanTemplate implements Parcelable {

    private List<AccountLinkingOptions> accountLinkingOptions;

    @SerializedName("allowPartialPeriodInterestCalcualtion")
    private boolean allowPartialPeriodInterestCalculation;

    private AmortizationType amortizationType;

    private List<AmortizationTypeOptions> amortizationTypeOptions;

    private Float annualInterestRate;

    private Double approvedPrincipal;

    private List<CalendarOptions> calendarOptions;

    private boolean canDefineInstallmentAmount;

    private boolean canDisburse;

    private boolean canUseForTopup;

    private List<ChargeOptions> chargeOptions;

    private List<Charges> charges;

    private Currency currency;

    private DaysInMonthType daysInMonthType;

    private DaysInYearType daysInYearType;

    private int fundId;

    private String fundName;

    private List<FundOptions> fundOptions;

    private Group group;

    private InterestCalculationPeriodType interestCalculationPeriodType;

    private List<InterestCalculationPeriodTypeOptions> interestCalculationPeriodTypeOptions;

    private InterestRateFrequencyType interestRateFrequencyType;

    private List<InterestRateFrequencyTypeOptions> interestRateFrequencyTypeOptions;

    private int interestRatePerPeriod;

    private InterestCalculateRateData interestRecalculationData;

    private InterestType interestType;

    private List<InterestTypeOptions> interestTypeOptions;

    private boolean isFloatingInterestRate;

    private boolean isInterestRecalculationEnabled;

    private boolean isLoanProductLinkedToFloatingRate;

    private boolean isTopup;

    private boolean isVariableInstallmentsAllowed;

    private List<LoanCollateralOptions> loanCollateralOptions;

    private List<LoanOfficerOptions> loanOfficerOptions;

    private int loanProductId;

    private String loanProductName;

    private List<LoanPurposeOptions> loanPurposeOptions;

    private int maximumGap;

    private Map<Integer, MemberVariation> memberVariations;

    private int minimumGap;

    private boolean multiDisburseLoan;

    private int numberOfRepayments;

    private List<OverdueCharges> overdueCharges;

    private Double principal;

    private Product product;

    private List<ProductOptions> productOptions;

    private Double proposedPrincipal;

    private int repaymentEvery;

    private List<RepaymentFrequencyDaysOfWeekTypeOptions> repaymentFrequencyDaysOfWeekTypeOptions;

    private List<RepaymentFrequencyNthDayTypeOptions> repaymentFrequencyNthDayTypeOptions;

    private RepaymentFrequencyType repaymentFrequencyType;

    private RepaymentFrequencyTypeOptions repaymentFrequencyTypeOptions;

    private int termFrequency;

    private List<TermFrequencyTypeOptions> termFrequencyTypeOptions;

    private List<TermPeriodFrequencyType> termPeriodFrequencyType;

    private Timeline timeline;

    private int transactionProcessingStrategyId;

    private List<TransactionProcessingStrategyOptions> transactionProcessingStrategyOptions;

    public List<AccountLinkingOptions> getAccountLinkingOptions() {
        return accountLinkingOptions;
    }

    public void setAccountLinkingOptions(List<AccountLinkingOptions> accountLinkingOptions) {
        this.accountLinkingOptions = accountLinkingOptions;
    }

    public boolean isAllowPartialPeriodInterestCalculation() {
        return allowPartialPeriodInterestCalculation;
    }

    public void setAllowPartialPeriodInterestCalculation(boolean allowPartialPeriodInterestCalculation) {
        this.allowPartialPeriodInterestCalculation = allowPartialPeriodInterestCalculation;
    }

    public AmortizationType getAmortizationType() {
        return amortizationType;
    }

    public void setAmortizationType(AmortizationType amortizationType) {
        this.amortizationType = amortizationType;
    }

    public List<AmortizationTypeOptions> getAmortizationTypeOptions() {
        return amortizationTypeOptions;
    }

    public void setAmortizationTypeOptions(List<AmortizationTypeOptions> amortizationTypeOptions) {
        this.amortizationTypeOptions = amortizationTypeOptions;
    }

    public Float getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(Float annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public Double getApprovedPrincipal() {
        return approvedPrincipal;
    }

    public void setApprovedPrincipal(Double approvedPrincipal) {
        this.approvedPrincipal = approvedPrincipal;
    }

    public List<CalendarOptions> getCalendarOptions() {
        return calendarOptions;
    }

    public void setCalendarOptions(List<CalendarOptions> calendarOptions) {
        this.calendarOptions = calendarOptions;
    }

    public boolean isCanDefineInstallmentAmount() {
        return canDefineInstallmentAmount;
    }

    public void setCanDefineInstallmentAmount(boolean canDefineInstallmentAmount) {
        this.canDefineInstallmentAmount = canDefineInstallmentAmount;
    }

    public boolean isCanDisburse() {
        return canDisburse;
    }

    public void setCanDisburse(boolean canDisburse) {
        this.canDisburse = canDisburse;
    }

    public boolean isCanUseForTopup() {
        return canUseForTopup;
    }

    public void setCanUseForTopup(boolean canUseForTopup) {
        this.canUseForTopup = canUseForTopup;
    }

    public List<ChargeOptions> getChargeOptions() {
        return chargeOptions;
    }

    public void setChargeOptions(List<ChargeOptions> chargeOptions) {
        this.chargeOptions = chargeOptions;
    }

    public List<Charges> getCharges() {
        return charges;
    }

    public void setCharges(List<Charges> charges) {
        this.charges = charges;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public DaysInMonthType getDaysInMonthType() {
        return daysInMonthType;
    }

    public void setDaysInMonthType(DaysInMonthType daysInMonthType) {
        this.daysInMonthType = daysInMonthType;
    }

    public DaysInYearType getDaysInYearType() {
        return daysInYearType;
    }

    public void setDaysInYearType(DaysInYearType daysInYearType) {
        this.daysInYearType = daysInYearType;
    }

    public int getFundId() {
        return fundId;
    }

    public void setFundId(int fundId) {
        this.fundId = fundId;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public List<FundOptions> getFundOptions() {
        return fundOptions;
    }

    public void setFundOptions(List<FundOptions> fundOptions) {
        this.fundOptions = fundOptions;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public InterestCalculationPeriodType getInterestCalculationPeriodType() {
        return interestCalculationPeriodType;
    }

    public void setInterestCalculationPeriodType(InterestCalculationPeriodType
                                                         interestCalculationPeriodType) {
        this.interestCalculationPeriodType = interestCalculationPeriodType;
    }

    public List<InterestCalculationPeriodTypeOptions> getInterestCalculationPeriodTypeOptions() {
        return interestCalculationPeriodTypeOptions;
    }

    public void setInterestCalculationPeriodTypeOptions(
            List<InterestCalculationPeriodTypeOptions> interestCalculationPeriodTypeOptions) {
        this.interestCalculationPeriodTypeOptions = interestCalculationPeriodTypeOptions;
    }

    public InterestRateFrequencyType getInterestRateFrequencyType() {
        return interestRateFrequencyType;
    }

    public void setInterestRateFrequencyType(InterestRateFrequencyType interestRateFrequencyType) {
        this.interestRateFrequencyType = interestRateFrequencyType;
    }

    public List<InterestRateFrequencyTypeOptions> getInterestRateFrequencyTypeOptions() {
        return interestRateFrequencyTypeOptions;
    }

    public void setInterestRateFrequencyTypeOptions(List<InterestRateFrequencyTypeOptions>
                                                            interestRateFrequencyTypeOptions) {
        this.interestRateFrequencyTypeOptions = interestRateFrequencyTypeOptions;
    }

    public int getInterestRatePerPeriod() {
        return interestRatePerPeriod;
    }

    public void setInterestRatePerPeriod(int interestRatePerPeriod) {
        this.interestRatePerPeriod = interestRatePerPeriod;
    }

    public InterestCalculateRateData getInterestRecalculationData() {
        return interestRecalculationData;
    }

    public void setInterestRecalculationData(InterestCalculateRateData interestRecalculationData) {
        this.interestRecalculationData = interestRecalculationData;
    }

    public InterestType getInterestType() {
        return interestType;
    }

    public void setInterestType(InterestType interestType) {
        this.interestType = interestType;
    }

    public List<InterestTypeOptions> getInterestTypeOptions() {
        return interestTypeOptions;
    }

    public void setInterestTypeOptions(List<InterestTypeOptions> interestTypeOptions) {
        this.interestTypeOptions = interestTypeOptions;
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

    public List<LoanCollateralOptions> getLoanCollateralOptions() {
        return loanCollateralOptions;
    }

    public void setLoanCollateralOptions(List<LoanCollateralOptions> loanCollateralOptions) {
        this.loanCollateralOptions = loanCollateralOptions;
    }

    public List<LoanOfficerOptions> getLoanOfficerOptions() {
        return loanOfficerOptions;
    }

    public void setLoanOfficerOptions(List<LoanOfficerOptions> loanOfficerOptions) {
        this.loanOfficerOptions = loanOfficerOptions;
    }

    public int getLoanProductId() {
        return loanProductId;
    }

    public void setLoanProductId(int loanProductId) {
        this.loanProductId = loanProductId;
    }

    public String getLoanProductName() {
        return loanProductName;
    }

    public void setLoanProductName(String loanProductName) {
        this.loanProductName = loanProductName;
    }

    public List<LoanPurposeOptions> getLoanPurposeOptions() {
        return loanPurposeOptions;
    }

    public void setLoanPurposeOptions(List<LoanPurposeOptions> loanPurposeOptions) {
        this.loanPurposeOptions = loanPurposeOptions;
    }

    public int getMaximumGap() {
        return maximumGap;
    }

    public void setMaximumGap(int maximumGap) {
        this.maximumGap = maximumGap;
    }

    public Map<Integer, MemberVariation> getMemberVariations() {
        return memberVariations;
    }

    public void setMemberVariations(Map<Integer, MemberVariation> memberVariations) {
        this.memberVariations = memberVariations;
    }

    public int getMinimumGap() {
        return minimumGap;
    }

    public void setMinimumGap(int minimumGap) {
        this.minimumGap = minimumGap;
    }

    public boolean isMultiDisburseLoan() {
        return multiDisburseLoan;
    }

    public void setMultiDisburseLoan(boolean multiDisburseLoan) {
        this.multiDisburseLoan = multiDisburseLoan;
    }

    public int getNumberOfRepayments() {
        return numberOfRepayments;
    }

    public void setNumberOfRepayments(int numberOfRepayments) {
        this.numberOfRepayments = numberOfRepayments;
    }

    public List<OverdueCharges> getOverdueCharges() {
        return overdueCharges;
    }

    public void setOverdueCharges(List<OverdueCharges> overdueCharges) {
        this.overdueCharges = overdueCharges;
    }

    public Double getPrincipal() {
        return principal;
    }

    public void setPrincipal(Double principal) {
        this.principal = principal;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<ProductOptions> getProductOptions() {
        return productOptions;
    }

    public void setProductOptions(List<ProductOptions> productOptions) {
        this.productOptions = productOptions;
    }

    public Double getProposedPrincipal() {
        return proposedPrincipal;
    }

    public void setProposedPrincipal(Double proposedPrincipal) {
        this.proposedPrincipal = proposedPrincipal;
    }

    public int getRepaymentEvery() {
        return repaymentEvery;
    }

    public void setRepaymentEvery(int repaymentEvery) {
        this.repaymentEvery = repaymentEvery;
    }

    public List<RepaymentFrequencyDaysOfWeekTypeOptions>
    getRepaymentFrequencyDaysOfWeekTypeOptions() {
        return repaymentFrequencyDaysOfWeekTypeOptions;
    }

    public void setRepaymentFrequencyDaysOfWeekTypeOptions(
            List<RepaymentFrequencyDaysOfWeekTypeOptions> repaymentFrequencyDaysOfWeekTypeOptions) {
        this.repaymentFrequencyDaysOfWeekTypeOptions = repaymentFrequencyDaysOfWeekTypeOptions;
    }

    public List<RepaymentFrequencyNthDayTypeOptions> getRepaymentFrequencyNthDayTypeOptions() {
        return repaymentFrequencyNthDayTypeOptions;
    }

    public void setRepaymentFrequencyNthDayTypeOptions(
            List<RepaymentFrequencyNthDayTypeOptions> repaymentFrequencyNthDayTypeOptions) {
        this.repaymentFrequencyNthDayTypeOptions = repaymentFrequencyNthDayTypeOptions;
    }

    public RepaymentFrequencyType getRepaymentFrequencyType() {
        return repaymentFrequencyType;
    }

    public void setRepaymentFrequencyType(RepaymentFrequencyType repaymentFrequencyType) {
        this.repaymentFrequencyType = repaymentFrequencyType;
    }

    public RepaymentFrequencyTypeOptions getRepaymentFrequencyTypeOptions() {
        return repaymentFrequencyTypeOptions;
    }

    public void setRepaymentFrequencyTypeOptions(RepaymentFrequencyTypeOptions
                                                         repaymentFrequencyTypeOptions) {
        this.repaymentFrequencyTypeOptions = repaymentFrequencyTypeOptions;
    }

    public int getTermFrequency() {
        return termFrequency;
    }

    public void setTermFrequency(int termFrequency) {
        this.termFrequency = termFrequency;
    }

    public List<TermFrequencyTypeOptions> getTermFrequencyTypeOptions() {
        return termFrequencyTypeOptions;
    }

    public void setTermFrequencyTypeOptions(List<TermFrequencyTypeOptions>
                                                    termFrequencyTypeOptions) {
        this.termFrequencyTypeOptions = termFrequencyTypeOptions;
    }

    public List<TermPeriodFrequencyType> getTermPeriodFrequencyType() {
        return termPeriodFrequencyType;
    }

    public void setTermPeriodFrequencyType(List<TermPeriodFrequencyType> termPeriodFrequencyType) {
        this.termPeriodFrequencyType = termPeriodFrequencyType;
    }

    public Timeline getTimeline() {
        return timeline;
    }

    public void setTimeline(Timeline timeline) {
        this.timeline = timeline;
    }

    public int getTransactionProcessingStrategyId() {
        return transactionProcessingStrategyId;
    }

    public void setTransactionProcessingStrategyId(int transactionProcessingStrategyId) {
        this.transactionProcessingStrategyId = transactionProcessingStrategyId;
    }

    public List<TransactionProcessingStrategyOptions> getTransactionProcessingStrategyOptions() {
        return transactionProcessingStrategyOptions;
    }

    public void setTransactionProcessingStrategyOptions(
            List<TransactionProcessingStrategyOptions> transactionProcessingStrategyOptions) {
        this.transactionProcessingStrategyOptions = transactionProcessingStrategyOptions;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.accountLinkingOptions);
        dest.writeByte(this.allowPartialPeriodInterestCalculation ? (byte) 1 : (byte) 0);
        dest.writeParcelable(this.amortizationType, flags);
        dest.writeTypedList(this.amortizationTypeOptions);
        dest.writeValue(this.annualInterestRate);
        dest.writeValue(this.approvedPrincipal);
        dest.writeTypedList(this.calendarOptions);
        dest.writeByte(this.canDefineInstallmentAmount ? (byte) 1 : (byte) 0);
        dest.writeByte(this.canDisburse ? (byte) 1 : (byte) 0);
        dest.writeByte(this.canUseForTopup ? (byte) 1 : (byte) 0);
        dest.writeTypedList(this.chargeOptions);
        dest.writeTypedList(this.charges);
        dest.writeParcelable(this.currency, flags);
        dest.writeParcelable(this.daysInMonthType, flags);
        dest.writeParcelable(this.daysInYearType, flags);
        dest.writeInt(this.fundId);
        dest.writeString(this.fundName);
        dest.writeTypedList(this.fundOptions);
        dest.writeParcelable(this.group, flags);
        dest.writeParcelable(this.interestCalculationPeriodType, flags);
        dest.writeTypedList(this.interestCalculationPeriodTypeOptions);
        dest.writeParcelable(this.interestRateFrequencyType, flags);
        dest.writeTypedList(this.interestRateFrequencyTypeOptions);
        dest.writeInt(this.interestRatePerPeriod);
        dest.writeParcelable(this.interestRecalculationData, flags);
        dest.writeParcelable(this.interestType, flags);
        dest.writeTypedList(this.interestTypeOptions);
        dest.writeByte(this.isFloatingInterestRate ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isInterestRecalculationEnabled ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isLoanProductLinkedToFloatingRate ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isTopup ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isVariableInstallmentsAllowed ? (byte) 1 : (byte) 0);
        dest.writeTypedList(this.loanCollateralOptions);
        dest.writeTypedList(this.loanOfficerOptions);
        dest.writeInt(this.loanProductId);
        dest.writeString(this.loanProductName);
        dest.writeTypedList(this.loanPurposeOptions);
        dest.writeInt(this.maximumGap);
        dest.writeInt(this.memberVariations.size());
        for (Map.Entry<Integer, MemberVariation> entry : this.memberVariations.entrySet()) {
            dest.writeValue(entry.getKey());
            dest.writeParcelable(entry.getValue(), flags);
        }
        dest.writeInt(this.minimumGap);
        dest.writeByte(this.multiDisburseLoan ? (byte) 1 : (byte) 0);
        dest.writeInt(this.numberOfRepayments);
        dest.writeTypedList(this.overdueCharges);
        dest.writeValue(this.principal);
        dest.writeParcelable(this.product, flags);
        dest.writeTypedList(this.productOptions);
        dest.writeValue(this.proposedPrincipal);
        dest.writeInt(this.repaymentEvery);
        dest.writeTypedList(this.repaymentFrequencyDaysOfWeekTypeOptions);
        dest.writeTypedList(this.repaymentFrequencyNthDayTypeOptions);
        dest.writeParcelable(this.repaymentFrequencyType, flags);
        dest.writeParcelable(this.repaymentFrequencyTypeOptions, flags);
        dest.writeInt(this.termFrequency);
        dest.writeTypedList(this.termFrequencyTypeOptions);
        dest.writeTypedList(this.termPeriodFrequencyType);
        dest.writeParcelable(this.timeline, flags);
        dest.writeInt(this.transactionProcessingStrategyId);
        dest.writeTypedList(this.transactionProcessingStrategyOptions);
    }

    public JlgBulkLoanTemplate() {
    }

    protected JlgBulkLoanTemplate(Parcel in) {
        this.accountLinkingOptions = in.createTypedArrayList(AccountLinkingOptions.CREATOR);
        this.allowPartialPeriodInterestCalculation = in.readByte() != 0;
        this.amortizationType = in.readParcelable(AmortizationType.class.getClassLoader());
        this.amortizationTypeOptions = in.createTypedArrayList(AmortizationTypeOptions.CREATOR);
        this.annualInterestRate = (Float) in.readValue(Float.class.getClassLoader());
        this.approvedPrincipal = (Double) in.readValue(Double.class.getClassLoader());
        this.calendarOptions = in.createTypedArrayList(CalendarOptions.CREATOR);
        this.canDefineInstallmentAmount = in.readByte() != 0;
        this.canDisburse = in.readByte() != 0;
        this.canUseForTopup = in.readByte() != 0;
        this.chargeOptions = in.createTypedArrayList(ChargeOptions.CREATOR);
        this.charges = in.createTypedArrayList(Charges.CREATOR);
        this.currency = in.readParcelable(Currency.class.getClassLoader());
        this.daysInMonthType = in.readParcelable(DaysInMonthType.class.getClassLoader());
        this.daysInYearType = in.readParcelable(DaysInYearType.class.getClassLoader());
        this.fundId = in.readInt();
        this.fundName = in.readString();
        this.fundOptions = in.createTypedArrayList(FundOptions.CREATOR);
        this.group = in.readParcelable(Group.class.getClassLoader());
        this.interestCalculationPeriodType = in
                .readParcelable(InterestCalculationPeriodType.class.getClassLoader());
        this.interestCalculationPeriodTypeOptions = in
                .createTypedArrayList(InterestCalculationPeriodTypeOptions.CREATOR);
        this.interestRateFrequencyType = in
                .readParcelable(InterestRateFrequencyType.class.getClassLoader());
        this.interestRateFrequencyTypeOptions = in
                .createTypedArrayList(InterestRateFrequencyTypeOptions.CREATOR);
        this.interestRatePerPeriod = in.readInt();
        this.interestRecalculationData = in
                .readParcelable(InterestCalculateRateData.class.getClassLoader());
        this.interestType = in.readParcelable(InterestType.class.getClassLoader());
        this.interestTypeOptions = in.createTypedArrayList(InterestTypeOptions.CREATOR);
        this.isFloatingInterestRate = in.readByte() != 0;
        this.isInterestRecalculationEnabled = in.readByte() != 0;
        this.isLoanProductLinkedToFloatingRate = in.readByte() != 0;
        this.isTopup = in.readByte() != 0;
        this.isVariableInstallmentsAllowed = in.readByte() != 0;
        this.loanCollateralOptions = in.createTypedArrayList(LoanCollateralOptions.CREATOR);
        this.loanOfficerOptions = in.createTypedArrayList(LoanOfficerOptions.CREATOR);
        this.loanProductId = in.readInt();
        this.loanProductName = in.readString();
        this.loanPurposeOptions = in.createTypedArrayList(LoanPurposeOptions.CREATOR);
        this.maximumGap = in.readInt();
        int memberVariationsSize = in.readInt();
        this.memberVariations = new HashMap<Integer, MemberVariation>(memberVariationsSize);
        for (int i = 0; i < memberVariationsSize; i++) {
            Integer key = (Integer) in.readValue(Integer.class.getClassLoader());
            MemberVariation value = in.readParcelable(MemberVariation.class.getClassLoader());
            this.memberVariations.put(key, value);
        }
        this.minimumGap = in.readInt();
        this.multiDisburseLoan = in.readByte() != 0;
        this.numberOfRepayments = in.readInt();
        this.overdueCharges = in.createTypedArrayList(OverdueCharges.CREATOR);
        this.principal = (Double) in.readValue(Double.class.getClassLoader());
        this.product = in.readParcelable(Product.class.getClassLoader());
        this.productOptions = in.createTypedArrayList(ProductOptions.CREATOR);
        this.proposedPrincipal = (Double) in.readValue(Double.class.getClassLoader());
        this.repaymentEvery = in.readInt();
        this.repaymentFrequencyDaysOfWeekTypeOptions = in
                .createTypedArrayList(RepaymentFrequencyDaysOfWeekTypeOptions.CREATOR);
        this.repaymentFrequencyNthDayTypeOptions = in
                .createTypedArrayList(RepaymentFrequencyNthDayTypeOptions.CREATOR);
        this.repaymentFrequencyType = in
                .readParcelable(RepaymentFrequencyType.class.getClassLoader());
        this.repaymentFrequencyTypeOptions = in
                .readParcelable(RepaymentFrequencyTypeOptions.class.getClassLoader());
        this.termFrequency = in.readInt();
        this.termFrequencyTypeOptions = in.createTypedArrayList(TermFrequencyTypeOptions.CREATOR);
        this.termPeriodFrequencyType = in.createTypedArrayList(TermPeriodFrequencyType.CREATOR);
        this.timeline = in.readParcelable(Timeline.class.getClassLoader());
        this.transactionProcessingStrategyId = in.readInt();
        this.transactionProcessingStrategyOptions = in
                .createTypedArrayList(TransactionProcessingStrategyOptions.CREATOR);
    }

    public static final Creator<JlgBulkLoanTemplate> CREATOR = new Creator<JlgBulkLoanTemplate>() {
        @Override
        public JlgBulkLoanTemplate createFromParcel(Parcel source) {
            return new JlgBulkLoanTemplate(source);
        }

        @Override
        public JlgBulkLoanTemplate[] newArray(int size) {
            return new JlgBulkLoanTemplate[size];
        }
    };
}
