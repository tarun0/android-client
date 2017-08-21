package com.mifos.mifosxdroid.online.lbulkJLG;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.mifos.mifosxdroid.R;
import com.mifos.mifosxdroid.adapters.JLGLoanAdapter;
import com.mifos.mifosxdroid.core.MifosBaseActivity;
import com.mifos.mifosxdroid.core.MifosBaseFragment;
import com.mifos.mifosxdroid.core.util.Toaster;
import com.mifos.mifosxdroid.uihelpers.MFDatePicker;
import com.mifos.objects.jlg.FundOptionsJLG;
import com.mifos.objects.jlg.LoanPurposeOptions;
import com.mifos.objects.templates.jlg.JlgBulkLoanTemplate;
import com.mifos.objects.templates.jlg.JlgBulkProductsTemplate;
import com.mifos.objects.templates.loans.LoanOfficerOptions;
import com.mifos.objects.templates.loans.ProductOptions;
import com.mifos.utils.Constants;
import com.mifos.utils.DateHelper;
import com.mifos.utils.FragmentConstants;

import java.util.ArrayList;
import java.util.HashMap;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Tarun on 17-08-17.
 */

public class GroupBulkJLGLoanFragment extends MifosBaseFragment implements GroupBulkJLGLoanMvpView,
        Spinner.OnItemSelectedListener, View.OnClickListener, MFDatePicker.OnDatePickListener {

    @BindView(R.id.sp_jlg_product)
    Spinner spProduct;

    @BindView(R.id.sp_loan_officer)
    Spinner spLoanOfficer;

    @BindView(R.id.sp_fund)
    Spinner spFund;

    @BindView(R.id.et_submission_date)
    TextInputEditText etSubmissionDate;

    @BindView(R.id.et_disbursement_date)
    TextInputEditText etDisbursementDate;

    @BindView(R.id.recycler_jlg)
    RecyclerView rvClientLoanInfo;

    @Inject
    JLGLoanAdapter jlgLoanAdapter;

    private View rootView;

    private int groupId;
    private boolean isSubmissionDate;
    private boolean isDisbursementDate;

    private JlgBulkProductsTemplate jlgBulkProductsTemplate;
    private JlgBulkLoanTemplate jlgBulkLoanTemplate;

    private HashMap<String, ProductOptions> productOptionsMap;
    private HashMap<String, LoanPurposeOptions> purposeOptionsHashMap;
    private HashMap<String, LoanOfficerOptions> loanOfficerOptionsHashMap;
    private HashMap<String, FundOptionsJLG> fundOptionsJLGHashMap;

    private ArrayList<String> loanOfficerNames;
    private ArrayList<String> fundNames;

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

        setUpViews();
        return rootView;
    }

    private void setUpViews() {
        presenter.fetchJlgProduct(groupId);

        String date = DateHelper.getCurrentDateAsNewDateFormat();
        etDisbursementDate.setText(date);
        etSubmissionDate.setText(date);

        etSubmissionDate.setOnClickListener(this);
        etSubmissionDate.setFocusable(false);
        etSubmissionDate.setLongClickable(false);

        etDisbursementDate.setOnClickListener(this);
        etDisbursementDate.setFocusable(false);
        etDisbursementDate.setLongClickable(false);

        fundNames = new ArrayList<>();
        fundNames.add(getString(R.string.loan_fund));

        loanOfficerNames = new ArrayList<>();
        loanOfficerNames.add(getString(R.string.loan_officer));

        setUpSpinner(spFund, fundNames);
        setUpSpinner(spLoanOfficer, loanOfficerNames);
    }

    private void inflateJLGProductSpinner() {
        ArrayList<String> productNames = new ArrayList<>();
        productOptionsMap = presenter.filterProducts(jlgBulkProductsTemplate.getProductOptions(),
                productNames);

        setUpSpinner(spProduct, productNames);
    }

    private void setUpLoanTemplate() {

        ArrayList<String> loanPurposeNames = new ArrayList<>();
        purposeOptionsHashMap = presenter
                .filterLoanPurpose(jlgBulkLoanTemplate.getLoanPurposeOptions(), loanPurposeNames);

        jlgLoanAdapter.setApprovedPrincipal(jlgBulkLoanTemplate.getApprovedPrincipal());
        jlgLoanAdapter.setClients(jlgBulkLoanTemplate.getGroup().getClientMembers());
        jlgLoanAdapter.setLoanPurposeList(loanPurposeNames);
        jlgLoanAdapter.setLoanPurposeOptionsList(jlgBulkLoanTemplate.getLoanPurposeOptions());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rvClientLoanInfo.setLayoutManager(layoutManager);

        loanOfficerOptionsHashMap = presenter
                .filterLoanOfficer(jlgBulkLoanTemplate.getLoanOfficerOptions(), loanOfficerNames);
        setUpSpinner(spLoanOfficer, loanOfficerNames);

        fundOptionsJLGHashMap = presenter.filterFund(jlgBulkLoanTemplate.getFundOptions(),
                fundNames);
        setUpSpinner(spFund, fundNames);

        rvClientLoanInfo.setAdapter(jlgLoanAdapter);
    }

    private void setUpSpinner(Spinner spinner, ArrayList<String> values) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_item, values);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.et_disbursement_date:
                isDisbursementDate = true;
                MFDatePicker.newInsance(this).show(getActivity().getSupportFragmentManager(),
                        FragmentConstants.DFRAG_DATE_PICKER);
                break;

            case R.id.et_submission_date:
                isSubmissionDate = true;
                MFDatePicker.newInsance(this).show(getActivity().getSupportFragmentManager(),
                        FragmentConstants.DFRAG_DATE_PICKER);
                break;
        }
    }

    @Override
    public void onDatePicked(String date) {
        String longDate = DateHelper.getDateAsStringUsedForCollectionSheetPayload(date);
        longDate = longDate.replace('-', ' ');
        if (isDisbursementDate) {
            etDisbursementDate.setText(longDate);
            isDisbursementDate = false;
        } else if (isSubmissionDate) {
            etSubmissionDate.setText(longDate);
            isSubmissionDate = false;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch (adapterView.getId()) {
            case R.id.sp_jlg_product:
                if (!spProduct.getSelectedItem().toString()
                        .equals(getString(R.string.product_name))) {
                    presenter.fetchJlgLoanTemplate(groupId, productOptionsMap.get(
                            spProduct.getSelectedItem().toString()).getId());
                }
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void showJlgLoanTemplate(JlgBulkLoanTemplate jlgBulkLoanTemplate) {
        this.jlgBulkLoanTemplate = jlgBulkLoanTemplate;
        setUpLoanTemplate();
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
