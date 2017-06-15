package gitter.privacy.gitlegit.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;
import gitter.privacy.gitlegit.R;

/**
 * Created by jahmale_c on 15/06/2017.
 */

public class SearchingForJobFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        parentView = bindXMLToFragment(R.layout.linked_in_view, inflater, container);
        ButterKnife.bind(this, parentView);

        return parentView;
    }

    @OnClick(R.id.cleaner_job)
    public void goToCleanerJobDetail(){
        Toast.makeText(getActivity(), "cleaner? ok", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.volunteer_job)
    public void goToVolunteerJobDetail(){
        Toast.makeText(getActivity(), "volunteer? ok", Toast.LENGTH_SHORT).show();
    }

}
