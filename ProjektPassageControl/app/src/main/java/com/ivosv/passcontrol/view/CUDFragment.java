package com.ivosv.passcontrol.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.ivosv.passcontrol.R;
import com.ivosv.passcontrol.viewmodel.PassEntryViewModel;

public class CUDFragment extends Fragment {

    static final int SLIKANJE=1;
    private String pictureRoute;

    @BindView(R.id.txtEntryTime)
    TextView entryTime;
    @BindView(R.id.txtExitTime)
    TextView exitTime;
    @BindView(R.id.txtName)
    EditText name;
    @BindView(R.id.txtLastName)
    EditText lastName;
    @BindView(R.id.btnTakePicture)
    Button picture;
    @BindView(R.id.txtEntryReason)
    EditText entryReason;
    @BindView(R.id.btnSave)
    Button save;
    @BindView(R.id.btnCancle)
    Button cancle;

    PassEntryViewModel passEntryViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View view = inflater.inflate(R.layout.new_entry_form, container, false);
        ButterKnife.bind(this, view);

        passEntryViewModel = ((MainActivity) getActivity()).getModel();

        if (passEntryViewModel.getEntry().getId() == 0) {
            definirajNoviFAlert();
            return view;
        }

        definirajMijenjanjeBrisanjeFAlert();

        return view;

    }


}
