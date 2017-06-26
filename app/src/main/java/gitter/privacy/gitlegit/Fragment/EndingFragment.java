package gitter.privacy.gitlegit.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import gitter.privacy.gitlegit.MainActivity;
import gitter.privacy.gitlegit.R;

/**
 * Created by jahmale_c on 21/06/2017.
 */

public class EndingFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        parentView = bindXMLToFragment(R.layout.ending_fragment,inflater,container);
        ((MainActivity)getActivity()).setStoryContainerVisible(false);

        return parentView;
    }
}
