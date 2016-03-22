package th.co.ask.eip_mobile.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import jp.wasabeef.glide.transformations.CropCircleTransformation;
import th.co.ask.eip_mobile.R;
import th.co.ask.eip_mobile.view.ProfileItemViewGroup;

public class ProfileFragment extends Fragment {
    private ImageView ivProfile;
    private TextView tvName;
    private TextView tvPosition;
    private ProfileItemViewGroup itemCode;
    private ProfileItemViewGroup itemComCode;
    private ProfileItemViewGroup itemPreBranch;
    private ProfileItemViewGroup itemDepartment;
    private ProfileItemViewGroup itemEmail;
    private TextView tvTitleCode;
    private TextView tvDescriptionCode;
    private TextView tvTitleComCode;
    private TextView tvDescriptionComCode;
    private TextView tvTitlePreBranch;
    private TextView tvDescriptionPreBranch;
    private TextView tvTitleDepartment;
    private TextView tvDescriptionDepartment;
    private TextView tvTitleEmail;
    private TextView tvDescriptionEmail;

    private int MENU_CODE = 0;
    private int MENU_COM_CODE = 1;
    private int MENU_PRE_BRANCH = 2;
    private int MENU_DEPARTMENT = 3;
    private int MENU_EMAIL = 4;
    private String[] mMunuTitle;

    public ProfileFragment() {
        super();
    }

    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(savedInstanceState);

        mMunuTitle = getContext().getResources().getStringArray(R.array.profileMenu);

        if (savedInstanceState != null)
            onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);
        initInstances(rootView, savedInstanceState);
        return rootView;
    }

    @SuppressWarnings("UnusedParameters")
    private void init(Bundle savedInstanceState) {
        // Init Fragment level's variable(s) here
    }

    @SuppressWarnings("UnusedParameters")
    private void initInstances(View rootView, Bundle savedInstanceState) {
        ivProfile = (ImageView) rootView.findViewById(R.id.ivProfile);
        Glide.with(this).load("https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTQLi4yBDP5oNiEFI1AhOxfPebPeqfzPUUcO8g-QYLIVeKPehq-lA")
                .bitmapTransform(new CropCircleTransformation(getActivity()))
                .placeholder(R.drawable.profile_placeholder)
                .error(R.drawable.profile_placeholder)
                .into(ivProfile);

        tvName = (TextView) rootView.findViewById(R.id.tvName);
        tvName.setText("Nitiwat Likidpongpaisarn");

        tvPosition = (TextView) rootView.findViewById(R.id.tvPosition);
        tvPosition.setText("Programmer");

        itemCode = (ProfileItemViewGroup) rootView.findViewById(R.id.itemCode);
        tvTitleCode = (TextView) itemCode.findViewById(R.id.tvTitle);
        tvDescriptionCode = (TextView) itemCode.findViewById(R.id.tvDescription);
        setMenuProfile(MENU_CODE);

        itemComCode = (ProfileItemViewGroup) rootView.findViewById(R.id.itemComCode);
        tvTitleComCode = (TextView) itemComCode.findViewById(R.id.tvTitle);
        tvDescriptionComCode = (TextView) itemComCode.findViewById(R.id.tvDescription);
        setMenuProfile(MENU_COM_CODE);

        itemPreBranch = (ProfileItemViewGroup) rootView.findViewById(R.id.itemPreBranch);
        tvTitlePreBranch = (TextView) itemPreBranch.findViewById(R.id.tvTitle);
        tvDescriptionPreBranch = (TextView) itemPreBranch.findViewById(R.id.tvDescription);
        setMenuProfile(MENU_PRE_BRANCH);

        itemDepartment = (ProfileItemViewGroup) rootView.findViewById(R.id.itemDepartment);
        tvTitleDepartment = (TextView) itemDepartment.findViewById(R.id.tvTitle);
        tvDescriptionDepartment = (TextView) itemDepartment.findViewById(R.id.tvDescription);
        setMenuProfile(MENU_DEPARTMENT);

        itemEmail = (ProfileItemViewGroup) rootView.findViewById(R.id.itemEmail);
        tvTitleEmail = (TextView) itemEmail.findViewById(R.id.tvTitle);
        tvDescriptionEmail = (TextView) itemEmail.findViewById(R.id.tvDescription);
        setMenuProfile(MENU_EMAIL);
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

    private void setMenuProfile(int positionMenu) {
        if (positionMenu == MENU_CODE) {
            tvTitleCode.setText(mMunuTitle[0]);
            tvDescriptionCode.setText("1000001255");
        } else if (positionMenu == MENU_COM_CODE) {
            tvTitleComCode.setText(mMunuTitle[1]);
            tvDescriptionComCode.setText("ASKH");
        } else if (positionMenu == MENU_PRE_BRANCH) {
            tvTitlePreBranch.setText(mMunuTitle[2]);
            tvDescriptionPreBranch.setText("ASKH");
        } else if (positionMenu == MENU_DEPARTMENT) {
            tvTitleDepartment.setText(mMunuTitle[3]);
            tvDescriptionDepartment.setText("ISA Department");
        } else if (positionMenu == MENU_EMAIL) {
            tvTitleEmail.setText(mMunuTitle[4]);
            tvDescriptionEmail.setText("nitiwat.li@ask.co.th");
        }
    }

}
