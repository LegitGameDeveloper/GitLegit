package gitter.privacy.gitlegit.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import gitter.privacy.gitlegit.MainActivity;
import gitter.privacy.gitlegit.R;

/**
 * Created by jahmale_c on 20/06/2017.
 */

public class SearchEngineFragment extends BaseFragment {

    public static final String TAG = "SearchEngineFragment";
    @BindView(R.id.search_et)
    EditText searchBar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        parentView = bindXMLToFragment(R.layout.search_results_view, inflater,container);
        ButterKnife.bind(this, parentView);
        
        ((MainActivity)getActivity()).setStoryContainerVisible(true);
        ((MainActivity)getActivity()).setStoryText(getString(R.string.search_engine_text1),"John");

        ((MainActivity)getActivity()).setmStoryContainerListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // doesn't do anything
            }
        });
        
        return parentView;
    }

    @OnClick(R.id.search_btn)
    public void doSearch(){
        String textToEvaluate = searchBar.getText().toString();
        textToEvaluate = textToEvaluate.trim().replaceAll(" +", " ");

        if(textToEvaluate.equalsIgnoreCase("apply for job")){
            //todo: change view to the 'two results' view
            Toast.makeText(getActivity(), "Alright, let's make job, yes?", Toast.LENGTH_SHORT).show();
        }else{
            //todo: change the view to 'no results found'
            Toast.makeText(getActivity(), searchBar.getText().toString().trim(),Toast.LENGTH_SHORT).show();
        }

    }
}
