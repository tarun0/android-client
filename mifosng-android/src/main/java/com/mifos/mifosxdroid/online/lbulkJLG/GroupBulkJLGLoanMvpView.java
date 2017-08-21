package com.mifos.mifosxdroid.online.lbulkJLG;

import com.mifos.mifosxdroid.base.MvpView;
import com.mifos.objects.templates.jlg.JlgBulkLoanTemplate;
import com.mifos.objects.templates.jlg.JlgBulkProductsTemplate;

/**
 * Created by Tarun on 17-08-17.
 */

public interface GroupBulkJLGLoanMvpView extends MvpView {

    void showJLGProducts(JlgBulkProductsTemplate jlgBulkProductsTemplate);

    void showError(String errorMessage);

    void showJlgLoanTemplate(JlgBulkLoanTemplate jlgBulkLoanTemplate);

}
