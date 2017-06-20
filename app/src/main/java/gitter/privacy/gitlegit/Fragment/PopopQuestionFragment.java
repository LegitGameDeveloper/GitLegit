package gitter.privacy.gitlegit.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import gitter.privacy.gitlegit.MainActivity;
import gitter.privacy.gitlegit.R;

/**
 * Created by Ryan on 16/06/2017.
 */

public class PopopQuestionFragment extends BaseFragment {
    public static final String TAG = "PopopQuestionFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        parentView = bindXMLToFragment(R.layout.choose_view, inflater, container);
        ButterKnife.bind(this, parentView);
        ((MainActivity)getActivity()).setStoryContainerVisible(false);

        return parentView;
    }
}

