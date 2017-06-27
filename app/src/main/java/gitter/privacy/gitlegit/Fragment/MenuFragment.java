package gitter.privacy.gitlegit.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.OnClick;
import gitter.privacy.gitlegit.MainActivity;
import gitter.privacy.gitlegit.R;

/**
 * Created by jahmale_c on 27/06/2017.
 */

public class MenuFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        parentView = bindXMLToFragment(R.layout.menu_background, inflater,container);
        ((MainActivity)getActivity()).setMainBackgroundImage(0);
        ((MainActivity)getActivity()).setStoryContainerVisible(false);

        return parentView;
    }

    @OnClick(R.id.jobHuntStory)
    public void doJobHunt(){
        ((MainActivity)getActivity()).switchToDifferentScreen(new JobIntroFragment(), "JobIntroFragment", false);
    }

    @OnClick(R.id.foodHuntStory)
    public void doFoodHunt(){

    }
}
