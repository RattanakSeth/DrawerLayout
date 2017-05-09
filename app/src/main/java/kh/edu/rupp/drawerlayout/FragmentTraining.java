package kh.edu.rupp.drawerlayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by ratan on 4/20/2017.
 */

public class FragmentTraining extends Fragment {

    private RecyclerView recyclerView;
    private TextView contectName;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView =  inflater.inflate(R.layout.layout_training,container,false);
        contectName = (TextView)fragmentView.findViewById(R.id.nameofcontect);

        contectName.setText("i love you");

        return fragmentView;
    }
}
