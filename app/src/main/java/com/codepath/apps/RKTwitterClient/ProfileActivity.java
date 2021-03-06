package com.codepath.apps.RKTwitterClient;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.widget.TextView;

import com.codepath.apps.RKTwitterClient.fragments.ProfileTimelineFragment;
import com.codepath.apps.RKTwitterClient.fragments.TweetsListFragment;
import com.codepath.apps.RKTwitterClient.models.Tweet;
import com.codepath.apps.RKTwitterClient.models.User;
import com.codepath.apps.RKTwitterClient.util.Util;
import com.loopj.android.image.SmartImageView;

public class ProfileActivity extends StatusTrackingActivity implements TweetsListFragment.TweetsListListener, TweetArrayAdapter.TweetActionsListener {

    private User mUser;

    @Override
    public void onTweetRetweeted(Tweet tweet) {

    }

    @Override
    public void onTweetFavorited(Tweet tweet) {
        
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUser = (User)getIntent().getSerializableExtra("user");

        setContentView(R.layout.activity_profile);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.vgProfileTweetsList, ProfileTimelineFragment.newInstance(3, mUser), ProfileTimelineFragment.FRAGMENT_NAME);
        ft.commit();

        final SmartImageView profileImage = (SmartImageView)findViewById(R.id.ivProfile);
        profileImage.setImageUrl(mUser.getProfileImageURL());
        SmartImageView profileBanner = (SmartImageView)findViewById(R.id.ivProfileBanner);
        profileBanner.setImageUrl(mUser.profileBannerUrl);


        TextView tvUserName = (TextView)findViewById(R.id.tvUserName);
        tvUserName.setTypeface(Util.getRobotoMedium(this));
        tvUserName.setText(mUser.getName());
        TextView tvUserScreenName =  (TextView)findViewById(R.id.tvUserScreenName);
        tvUserScreenName.setText("@" + mUser.getScreenName());

        TextView tvTweetCount = (TextView)findViewById(R.id.tvTweetCount);
        tvTweetCount.setText(String.format("%d", mUser.tweetCount));

        TextView tvFollowersCount = (TextView)findViewById(R.id.tvFollowersCount);
        tvFollowersCount.setText(String.format("%d", mUser.followerCount));

        TextView tvFollowingCount = (TextView)findViewById(R.id.tvFollowingCount);
        tvFollowingCount.setText(String.format("%d", mUser.followingCount));

    }

    @Override
    public void onConnectionRegained() {

    }

    @Override
    public void onConnectionLost() {

    }

    @Override
    public void onTweetClicked(Tweet tweet) {

    }

}
