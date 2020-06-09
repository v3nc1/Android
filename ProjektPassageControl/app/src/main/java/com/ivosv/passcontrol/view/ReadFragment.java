package com.ivosv.passcontrol.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.ivosv.passcontrol.R;
import com.ivosv.passcontrol.adapter.EntryClickListener;
import com.ivosv.passcontrol.adapter.PassEntryAdapter;
import com.ivosv.passcontrol.model.PassEntry;
import com.ivosv.passcontrol.viewmodel.PassEntryViewModel;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ReadFragment extends Fragment {


    @BindView(R.id.swipeContainer)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.lista)
    ListView listView;


    private PassEntryViewModel model;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pregled_fragment,
                container, false);
        ButterKnife.bind(this,view);

        model = ((MainActivity)getActivity()).getModel();

        defList();
        defSwipe();
        refreshData();


        return view;
    }

    private void refreshData(){
        model.getEntryRecords().observe(this, new Observer<List<PassEntry>>() {
            @Override
            public void onChanged(@Nullable List<PassEntry> passEntryList) {
                swipeRefreshLayout.setRefreshing(false);
                ((PassEntryAdapter)listView.getAdapter()).setEntrys(passEntryList);
                ((PassEntryAdapter)listView.getAdapter()).osvjeziEntrys();

            }
        });
    }
    private void defSwipe() {
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshData();
            }
        });

    }

    private void defList() {

        listView.setAdapter( new PassEntryAdapter(getActivity(), R.layout.red, new EntryClickListener() {
            @Override
            public void onItemClick(PassEntry record) {
                model.setEntry(record);
                ((MainActivity)getActivity()).cud();
            }
        }));
    }

    @OnClick(R.id.newEntry)
    public void newEntry(){

        model.setEntry(new PassEntry());
        ((MainActivity)getActivity()).cud();
    }







}
