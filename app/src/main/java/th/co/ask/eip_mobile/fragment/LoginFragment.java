package th.co.ask.eip_mobile.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.andexert.library.RippleView;

import th.co.ask.eip_mobile.R;


public class LoginFragment extends Fragment implements RippleView.OnRippleCompleteListener, CompoundButton.OnCheckedChangeListener {
    private EditText edtUsername;
    private EditText edtPassword;
    private CheckBox cbShowPassword;
    private RippleView rvSignin;
    private RippleView rvClear;
    private Button btnSignin;
    private Button btnClear;
    private LinearLayout linearLogin;



    public interface LoginListener{
        void onClickListener();
    }

    public LoginFragment() {
        super();
    }

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(savedInstanceState);

        if (savedInstanceState != null)
            onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);
        initInstances(rootView, savedInstanceState);
        return rootView;
    }

    @SuppressWarnings("UnusedParameters")
    private void init(Bundle savedInstanceState) {
        // Init Fragment level's variable(s) here
    }

    @SuppressWarnings("UnusedParameters")
    private void initInstances(View rootView, Bundle savedInstanceState) {
        edtUsername = (EditText) rootView.findViewById(R.id.edtUsername);
        edtPassword = (EditText) rootView.findViewById(R.id.edtPassword);
        cbShowPassword = (CheckBox) rootView.findViewById(R.id.cbShowPassword);
        rvSignin = (RippleView) rootView.findViewById(R.id.rvSignin);
        rvClear = (RippleView) rootView.findViewById(R.id.rvClear);
        btnSignin = (Button) rootView.findViewById(R.id.btnSignin);
        btnClear = (Button) rootView.findViewById(R.id.btnClear);
        linearLogin = (LinearLayout) rootView.findViewById(R.id.linearLogin);

        cbShowPassword.setOnCheckedChangeListener(this);
        rvSignin.setOnRippleCompleteListener(this);
        rvClear.setOnRippleCompleteListener(this);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save Instance (Fragment level's variables) State here
    }

    @SuppressWarnings("UnusedParameters")
    private void onRestoreInstanceState(Bundle savedInstanceState) {
        // Restore Instance (Fragment level's variables) State here
    }

    private void clearField() {
        edtUsername.getText().clear();
        edtPassword.getText().clear();
        cbShowPassword.setChecked(false);
    }

    private void setShowPassword(boolean isChecked) {
        edtPassword.setInputType(!isChecked ? InputType.TYPE_TEXT_VARIATION_PASSWORD : InputType.TYPE_CLASS_TEXT);
        edtPassword.setTransformationMethod(!isChecked ? PasswordTransformationMethod.getInstance() : null);

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (buttonView.equals(cbShowPassword)) {
            setShowPassword(isChecked);
        }
    }

    @Override
    public void onComplete(RippleView rippleView) {
        if (rippleView.equals(rvSignin)) {
            //TODO : Sigin
            ((LoginListener)getActivity()).onClickListener();
        } else if (rippleView.equals(rvClear)) {
            clearField();
        }
    }
}
