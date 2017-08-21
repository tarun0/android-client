package com.mifos.mifosxdroid.adapters;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.mifos.mifosxdroid.R;
import com.mifos.mifosxdroid.injection.ActivityContext;
import com.mifos.objects.jlg.ClientJLG;
import com.mifos.objects.jlg.GroupJLG;
import com.mifos.objects.jlg.LoanPurposeOptions;
import com.mifos.objects.templates.jlg.MemberVariation;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Tarun on 18-08-17.
 */

public class JLGLoanAdapter extends RecyclerView.Adapter<JLGLoanAdapter.ViewHolder> {

    @Nullable
    private List<MemberVariation> memberVariations;

    @Nullable
    private List<ClientJLG> clients;
    private List<LoanPurposeOptions> loanPurposeOptionsList;
    private List<String> loanPurposeList;
    private Double approvedPrincipal;
    private GroupJLG group;

    private Context context;

    @Inject
    public JLGLoanAdapter(@ActivityContext Context context) {
        this.context = context;
    }

    public void setMemberVariations(@Nullable List<MemberVariation> memberVariations) {
        this.memberVariations = memberVariations;
    }

    public void setApprovedPrincipal(Double approvedPrincipal) {
        this.approvedPrincipal = approvedPrincipal;
    }

    public void setClients(@Nullable List<ClientJLG> clients) {
        this.clients = clients;
    }

    public void setLoanPurposeOptionsList(List<LoanPurposeOptions> loanPurposeOptionsList) {
        this.loanPurposeOptionsList = loanPurposeOptionsList;
    }

    public void setLoanPurposeList(List<String> loanPurposeList) {
        this.loanPurposeList = loanPurposeList;
    }

    public void setGroup(GroupJLG group) {
        this.group = group;
    }

    @Override
    public JLGLoanAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_jlg_bulk_loan, parent, false);
        return new JLGLoanAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(JLGLoanAdapter.ViewHolder holder, int position) {

        if (holder != null && clients.size() > 0) {
            //MemberVariation memberVariation = memberVariations.get(position);
            ClientJLG clientJLG = clients.get(position);

            holder.tvClientId.setText(String.format(Locale.getDefault(), "%d", clientJLG.getId()));
            holder.tvClientName.setText(clientJLG.getDisplayName());
            holder.etOriginalLoan.setText(String.format(Locale.getDefault(), "%f", approvedPrincipal));
        }
    }

    @Override
    public int getItemCount() {
        return clients != null ? clients.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
            implements Spinner.OnItemSelectedListener {

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);

            ArrayAdapter<String> adapter = new ArrayAdapter<>(context,
                    android.R.layout.simple_spinner_item, loanPurposeList);
            spLoanPurpose.setAdapter(adapter);
            spLoanPurpose.setOnItemSelectedListener(this);
        }

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            //Act as required
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }

        @BindView(R.id.cb)
        CheckBox cb;

        @BindView(R.id.tv_client_name)
        TextView tvClientName;

        @BindView(R.id.tv_client_id)
        TextView tvClientId;

        @BindView(R.id.et_original_loan)
        TextInputEditText etOriginalLoan;

        @BindView(R.id.sp_loan_purpose)
        Spinner spLoanPurpose;
    }
}
