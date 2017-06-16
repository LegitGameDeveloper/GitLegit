package gitter.privacy.gitlegit.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import gitter.privacy.gitlegit.MainActivity;
import gitter.privacy.gitlegit.R;

/**
 * Created by jahmale_c on 15/06/2017.
 */

public class FillOutFormFragment extends BaseFragment {

    public static final String TAG = "FillOutFormFragment";

    @BindView(R.id.username_input)
    EditText usernameInput;
    @BindView(R.id.userlastname_input)
    EditText userLastNameInput;
    @BindView(R.id.socialsecurity_input)
    EditText userSocialSecurityInput;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        parentView = bindXMLToFragment(R.layout.fill_out_form_view, inflater, container);
        ButterKnife.bind(this, parentView);

        setStoryText();

        return parentView;
    }

    public void setStoryText(){
        ((MainActivity)getActivity()).setStoryContainerVisible(true);
        ((MainActivity)getActivity()).setStoryText(getString(R.string.fill_form_text_1), "John");
    }

    @OnClick(R.id.sendFormBtn)
    public void sendFormBtn(){

        //TODO: make sure the form is checked and sent if good

    }

}
