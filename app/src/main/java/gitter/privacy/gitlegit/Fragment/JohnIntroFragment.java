package gitter.privacy.gitlegit.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import gitter.privacy.gitlegit.MainActivity;
import gitter.privacy.gitlegit.R;

/**
 * Created by jahmale_c on 15/06/2017.
 */

public class JohnIntroFragment extends BaseFragment {

    public static final String TAG = "JohnIntroFragment";
    private boolean containerIsVisible = false;
    private int textCounter = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setTextContainerListener();
        return bindXMLToFragment(R.layout.john_intro_view, inflater, container);
    }

    public void setTextContainerListener(){
        ((MainActivity)getActivity()).setmStoryContainerListener(storyListener);
        ((MainActivity)getActivity()).setStoryText(getString(R.string.john_introduction_info_1),"");
        textCounter++;
    }

    private View.OnClickListener storyListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(!containerIsVisible){
                ((MainActivity)getActivity()).setStoryContainerVisible(true);
                containerIsVisible = true;
            }

            switch (textCounter){
                case 0:
                    ((MainActivity)getActivity()).setStoryText(getString(R.string.john_introduction_info_1),"");
                    break;
                case 1:
                    ((MainActivity)getActivity()).setStoryText(getString(R.string.john_introduction_info_2),"");
                    break;
                case 2:
                    ((MainActivity)getActivity()).setStoryText(getString(R.string.john_introduction_1),"John");
                    break;
                case 3:
                    ((MainActivity)getActivity()).setStoryText(getString(R.string.john_introduction_2),"John");
                    break;
                default:
                    Log.e(TAG, "playStory: unknown story counter for introduction given, why u do dis");
            }

            textCounter++;
        }
    };
}
