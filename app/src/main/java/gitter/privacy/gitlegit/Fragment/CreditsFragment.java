package gitter.privacy.gitlegit.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.OnClick;
import gitter.privacy.gitlegit.MainActivity;
import gitter.privacy.gitlegit.R;

/**
 * Created by jahmale_c on 27/06/2017.
 */

public class CreditsFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        parentView = bindXMLToFragment(R.layout.credits_fragment_view, inflater, container);
        ButterKnife.bind(this, parentView);
        return parentView;
    }

    @OnClick(R.id.backToMain)
    public void switchToMain(){
        ((MainActivity)getActivity()).switchToDifferentScreen(new MenuFragment(), "MenuFr", false);
    }
}
