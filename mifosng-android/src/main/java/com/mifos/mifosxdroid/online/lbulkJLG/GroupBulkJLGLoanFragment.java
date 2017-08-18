package com.mifos.mifosxdroid.online.lbulkJLG;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.mifos.mifosxdroid.R;
import com.mifos.mifosxdroid.core.MifosBaseActivity;
import com.mifos.mifosxdroid.core.MifosBaseFragment;
import com.mifos.mifosxdroid.core.util.Toaster;
import com.mifos.objects.templates.jlg.JlgBulkProductsTemplate;
import com.mifos.objects.templates.loans.ProductOptions;
import com.mifos.utils.Constants;

import java.util.ArrayList;
import java.util.HashMap;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Tarun on 17-08-17.
 */

public class GroupBulkJLGLoanFragment extends MifosBaseFragment implements GroupBulkJLGLoanMvpView,
        Spinner.OnItemSelectedListener {

    private View rootView;

    private int groupId;

    private JlgBulkProductsTemplate jlgBulkProductsTemplate;

    private HashMap<String, ProductOptions> productOptionsMap;

    private ArrayAdapter<String> productNamesAdapter;

    @BindView(R.id.sp_jlg_product)
    Spinner spProduct;

    @Inject
    GroupBulkJLGLoanPresenter presenter;

    public static GroupBulkJLGLoanFragment newInstance(int groupId) {
        GroupBulkJLGLoanFragment groupBulkJLGLoanFragment = new GroupBulkJLGLoanFragment();
        Bundle args = new Bundle();
        args.putInt(Constants.GROUP_ID, groupId);
        groupBulkJLGLoanFragment.setArguments(args);
        return groupBulkJLGLoanFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            groupId = getArguments().getInt(Constants.GROUP_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        if (getActivity().getActionBar() != null)
            getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
        rootView = inflater.inflate(R.layout.fragment_jlg_bulk_loan, null);
        ((MifosBaseActivity) getActivity()).getActivityComponent().inject(this);
        ButterKnife.bind(this, rootView);
        presenter.attachView(this);

        presenter.fetchJlgProduct(groupId);
        return rootView;
    }

    private void inflateJLGProductSpinner() {
        ArrayList<String> productNames = new ArrayList<>();
        productOptionsMap = presenter.filterProducts(jlgBulkProductsTemplate.getProductOptions(),
               productNames);

        productNamesAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item,
                productNames);
        productNamesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spProduct.setAdapter(productNamesAdapter);
        spProduct.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toaster.show(rootView, spProduct.getSelectedItem().toString());
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void showJLGProducts(JlgBulkProductsTemplate jlgBulkProductsTemplate) {
        this.jlgBulkProductsTemplate = jlgBulkProductsTemplate;
        inflateJLGProductSpinner();
    }

    @Override
    public void showProgressbar(boolean b) {
        if (b) {
            showMifosProgressDialog();
        } else {
            hideMifosProgressDialog();
        }
    }

    @Override
    public void showError(String errorMessage) {
        Toaster.show(rootView, errorMessage);
    }
}
