package com.mifos.api.services;

import com.mifos.api.model.APIEndPoint;
import com.mifos.objects.templates.jlg.JlgBulkProductsTemplate;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Tarun on 17-08-17.
 */

public interface JLGService {

    @GET(APIEndPoint.LOANS + "/template")
    Observable<JlgBulkProductsTemplate> getJLGProducts(
            @Query("groupId") int groupId,
            @Query("lendingStrategy") int lendingStrategy,
            @Query("templateType") String templateType);
}
