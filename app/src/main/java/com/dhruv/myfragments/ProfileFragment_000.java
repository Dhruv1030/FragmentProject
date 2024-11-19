package com.dhruv.myfragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import androidx.cardview.widget.CardView;
import android.widget.Toast;

public class ProfileFragment_000 extends Fragment {

    private TextView userNameTv, userEmailTv, userBioTv, followerCountTv;
    private ImageView profileImageView;
    private Button editProfileBtn, followBtn;
    private CardView statsCard;
    private int followerCount = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        // Initialize views
        userNameTv = view.findViewById(R.id.userNameTv);
        userEmailTv = view.findViewById(R.id.userEmailTv);
        userBioTv = view.findViewById(R.id.userBioTv);
        followerCountTv = view.findViewById(R.id.followerCountTv);
        profileImageView = view.findViewById(R.id.profileImageView);
        editProfileBtn = view.findViewById(R.id.editProfileBtn);
        followBtn = view.findViewById(R.id.followBtn);
        statsCard = view.findViewById(R.id.statsCard);

        // Set initial data
        userNameTv.setText("DHRUV PATEL");
        userEmailTv.setText("dp14798@gmail.com");
        userBioTv.setText("Android Developer | Coffee Lover | Tech Enthusiast");
        updateFollowerCount();

        // Button click listeners
        editProfileBtn.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Edit Profile Clicked", Toast.LENGTH_SHORT).show();
        });

        followBtn.setOnClickListener(v -> {
            followerCount++;
            updateFollowerCount();
            Toast.makeText(getContext(), "Following!", Toast.LENGTH_SHORT).show();
        });

        return view;
    }

    private void updateFollowerCount() {
        followerCountTv.setText(followerCount + " Followers");
    }
}
