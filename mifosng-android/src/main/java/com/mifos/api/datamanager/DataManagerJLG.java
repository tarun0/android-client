package com.mifos.api.datamanager;

import com.mifos.api.BaseApiManager;
import com.mifos.objects.templates.jlg.JlgBulkProductsTemplate;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

/**
 * Created by Tarun on 17-08-17.
 */

@Singleton
public class DataManagerJLG {

    public final BaseApiManager baseApiManager;

    @Inject
    public DataManagerJLG(BaseApiManager baseApiManager) {
        this.baseApiManager = baseApiManager;
    }

    public Observable<JlgBulkProductsTemplate> getJLGProducts(int groupId, int lendingStrategy, String templateType) {
        return baseApiManager.getJlgApi().getJLGProducts(groupId, lendingStrategy, templateType);
    }

}
