package com.mifos.mifosxdroid.online.lbulkJLG;

import android.content.Context;

import com.mifos.api.datamanager.DataManagerJLG;
import com.mifos.mifosxdroid.R;
import com.mifos.mifosxdroid.base.BasePresenter;
import com.mifos.mifosxdroid.injection.ActivityContext;
import com.mifos.objects.jlg.LoanPurposeOptions;
import com.mifos.objects.jlg.FundOptionsJLG;
import com.mifos.objects.templates.jlg.JlgBulkLoanTemplate;
import com.mifos.objects.templates.jlg.JlgBulkProductsTemplate;
import com.mifos.objects.templates.loans.LoanOfficerOptions;
import com.mifos.objects.templates.loans.ProductOptions;
import com.mifos.utils.MFErrorParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Tarun on 17-08-17.
 */

public class GroupBulkJLGLoanPresenter extends BasePresenter<GroupBulkJLGLoanMvpView> {

    private CompositeSubscription compositeSubscription;
    private final DataManagerJLG dataManagerJLG;
    private final Context context;

    @Inject
    public GroupBulkJLGLoanPresenter(DataManagerJLG dataManagerJLG,
                                     @ActivityContext Context c) {
        this.dataManagerJLG = dataManagerJLG;
        context = c;
        compositeSubscription = new CompositeSubscription();
    }

    @Override
    public void attachView(GroupBulkJLGLoanMvpView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
        compositeSubscription.clear();
    }

    public void fetchJlgProduct(int groupId) {
        checkViewAttached();
        getMvpView().showProgressbar(true);
        compositeSubscription.add(dataManagerJLG.getJLGProducts(groupId, 300, "jlgbulk")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<JlgBulkProductsTemplate>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        getMvpView().showProgressbar(false);
                        getMvpView().showError(MFErrorParser.errorMessage(e));
                    }

                    @Override
                    public void onNext(JlgBulkProductsTemplate jlgBulkProductsTemplate) {
                        getMvpView().showProgressbar(false);
                        getMvpView().showJLGProducts(jlgBulkProductsTemplate);
                    }
                }));
    }

    public void fetchJlgLoanTemplate(int groupId, int productId) {
        checkViewAttached();
        getMvpView().showProgressbar(true);
        compositeSubscription.add(dataManagerJLG.getJLGLoanTemplate(groupId, 300, productId, "jlgbulk")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<JlgBulkLoanTemplate>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        getMvpView().showProgressbar(false);
                        getMvpView().showError(MFErrorParser.errorMessage(e));
                    }

                    @Override
                    public void onNext(JlgBulkLoanTemplate jlgBulkLoanTemplate) {
                        getMvpView().showProgressbar(false);
                        getMvpView().showJlgLoanTemplate(jlgBulkLoanTemplate);
                    }
                }));
    }

    public HashMap<String, ProductOptions> filterProducts(
            List<ProductOptions> productOptionsList,
            final ArrayList<String> productNames) {
        final HashMap<String, ProductOptions> productMap = new HashMap<>();
        productNames.clear();
        productNames.add(context.getString(R.string.product_name));
        Observable.from(productOptionsList)
                .subscribe(new Action1<ProductOptions>() {
                    @Override
                    public void call(ProductOptions productOption) {
                        productNames.add(productOption.getName());
                        productMap.put(productOption.getName(), productOption);
                    }
                });
        return productMap;
    }

    public HashMap<String, LoanPurposeOptions> filterLoanPurpose(
            List<LoanPurposeOptions> purposeOptionsList,
            final ArrayList<String> purposeNames) {
        final HashMap<String, LoanPurposeOptions> purposeMap = new HashMap<>();
        purposeNames.clear();
        purposeNames.add(context.getString(R.string.loan_purpose));
        Observable.from(purposeOptionsList)
                .subscribe(new Action1<LoanPurposeOptions>() {
                    @Override
                    public void call(LoanPurposeOptions purposeOption) {
                        purposeNames.add(purposeOption.getName());
                        purposeMap.put(purposeOption.getName(), purposeOption);
                    }
                });
        return purposeMap;
    }

    public HashMap<String, LoanOfficerOptions> filterLoanOfficer(
            List<LoanOfficerOptions> loanOfficerOptions, final ArrayList<String> loanOfficerNames) {
        final HashMap<String, LoanOfficerOptions> loanOfficerOptionMap = new HashMap<>();
        loanOfficerNames.clear();
        loanOfficerNames.add(context.getString(R.string.loan_officer));
        Observable.from(loanOfficerOptions)
                .subscribe(new Action1<LoanOfficerOptions>() {
                    @Override
                    public void call(LoanOfficerOptions loanOfficerOption) {
                        loanOfficerNames.add(loanOfficerOption.getDisplayName());
                        loanOfficerOptionMap.put(loanOfficerOption.getDisplayName(),
                                loanOfficerOption);
                    }
                });
        return loanOfficerOptionMap;
    }

    public HashMap<String, FundOptionsJLG> filterFund(List<FundOptionsJLG> fundsJLG,
                                                      final ArrayList<String> fundNames) {
        final HashMap<String, FundOptionsJLG> fundOptionsJLGHashMap = new HashMap<>();
        fundNames.clear();
        fundNames.add(context.getString(R.string.error_select_fund));
        Observable.from(fundsJLG)
                .subscribe(new Action1<FundOptionsJLG>() {
                    @Override
                    public void call(FundOptionsJLG fundOptionJLG) {
                        fundNames.add(fundOptionJLG.getName());
                        fundOptionsJLGHashMap.put(fundOptionJLG.getName(), fundOptionJLG);
                    }
                });
        return fundOptionsJLGHashMap;
    }
}
