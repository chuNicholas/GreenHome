package greenhome.greenhome;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by gabriel on 2/17/2018.
 */

public class GoalsFragment extends Fragment {
    public static final String TAB = "GoalsFragment";
    

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.goals_tab_fragment,container,false);


        return view;
    }
}
