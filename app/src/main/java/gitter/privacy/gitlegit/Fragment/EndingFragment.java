package gitter.privacy.gitlegit.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import gitter.privacy.gitlegit.MainActivity;
import gitter.privacy.gitlegit.R;

/**
 * Created by jahmale_c on 21/06/2017.
 */

public class EndingFragment extends BaseFragment {

    private Handler handler;

    @BindView(R.id.time_pass_bg)
    ViewGroup timePassBackground;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        parentView = bindXMLToFragment(R.layout.ending_fragment,inflater,container);
        ButterKnife.bind(this, parentView);
        ((MainActivity)getActivity()).setStoryContainerVisible(false);
        handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                timePassBackground.setVisibility(View.GONE);
                if(((MainActivity)getActivity()).isWrongApplicationSent() || ((MainActivity)getActivity()).isWrongWebsiteChosen()){
                    Toast.makeText(getActivity(), "u failed", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getActivity(), "U MADE IT", Toast.LENGTH_SHORT).show();
                }
            }
        },1000);

        return parentView;
    }
}
