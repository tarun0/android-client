package com.mifos.mifosxdroid.online.lbulkJLG;

import android.content.Context;

import com.mifos.api.datamanager.DataManagerJLG;
import com.mifos.mifosxdroid.R;
import com.mifos.mifosxdroid.base.BasePresenter;
import com.mifos.mifosxdroid.injection.ActivityContext;
import com.mifos.objects.templates.jlg.JlgBulkProductsTemplate;
import com.mifos.objects.templates.loans.ProductOptions;
import com.mifos.utils.MFErrorParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import retrofit2.adapter.rxjava.HttpException;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.plugins.RxJavaPlugins;
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
}
