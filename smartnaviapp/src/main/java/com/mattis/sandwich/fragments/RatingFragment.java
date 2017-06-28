package com.mattis.sandwich.fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

/*import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;*/
import com.mattis.sandwich.R;
import com.mattis.sandwich.tools.AnalyticsApplication;
import com.mattis.sandwich.tools.Config;

/**
 * Fragment to show Rating Dialog.
 *
 * @author Christian
 */
public class RatingFragment extends Fragment {

    //private onRatingFinishedListener mListener;
    private View fragmentView;
    //private Tracker mTracker;

    public RatingFragment() {
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentView = view;

        // Obtain the shared Tracker instance.
        AnalyticsApplication application = (AnalyticsApplication) this.getActivity().getApplication();
       /* mTracker = application.getDefaultTracker();
        mTracker.setScreenName("RatingFragment");
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());*/

        showRateDialog();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rating, container, false);
    }

    /*@Override
    public void onAttach(Context context) {
        /*super.onAttach(context);
        /*if (context instanceof onRatingFinishedListener) {
            mListener = (onRatingFinishedListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }/*
    }*/

    @Override
    public void onDetach() {
        super.onDetach();
        //mListener = null;
    }

    private void showRateDialog() {
        Button rateButton1 = (Button) fragmentView.findViewById(R.id.rateButton);
        if (rateButton1 != null) {
            rateButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /*mTracker.send(new HitBuilders.EventBuilder()
                            .setCategory("Action")
                            .setAction("Rating_No")
                            .build());/*
                    SharedPreferences prefs = RatingFragment.this.getActivity().getSharedPreferences(RatingFragment.this.getActivity().getPackageName() + "_preferences", 0);
                    int notRated = prefs.getInt("ratingDenied", 0) + 1;
                    if (BuildConfig.debug)
                        Log.i("RateDialog", "Not Rated: " + notRated);
                    prefs.edit().putInt("ratingDenied", notRated).apply();

                    if (notRated == 1) {
                        prefs.edit().putInt("appLaunchCounter", -2).apply();
                    } else if (notRated == 2) {
                        prefs.edit().putInt("appLaunchCounter", -5).apply();
                    } else if (notRated == 3) {
                        prefs.edit().putInt("appLaunchCounter", -5).apply();
                    } else if (notRated >= 4) {
                        prefs.edit().putBoolean("neverShowRatingAgain", true).apply();
                    }
                    if (mListener != null) {
                        mListener.onRatingFinished();
                    }*/
                }
            });
        }
        Button rateButton3 = (Button) fragmentView.findViewById(R.id.rateButton2);
        if (rateButton3 != null) {
            rateButton3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SharedPreferences prefs = RatingFragment.this.getActivity().getSharedPreferences(RatingFragment.this.getActivity().getPackageName() + "_preferences", 0);
                    /*mTracker.send(new HitBuilders.EventBuilder()
                            .setCategory("Action")
                            .setAction("Rating_Yes")
                            .build());
                    prefs.edit().putInt("ratingDenied", 100).apply();
                    prefs.edit().putBoolean("neverShowRatingAgain", true).apply();
                    if (mListener != null) {
                        mListener.onRatingFinished();
                    }*/
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + Config.APP_PNAME)));
                }
            });
        }

        ImageView stars = (ImageView) fragmentView.findViewById(R.id.stars);
        if (stars != null) {
            stars.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SharedPreferences prefs = RatingFragment.this.getActivity().getSharedPreferences(RatingFragment.this.getActivity().getPackageName() + "_preferences", 0);
                    prefs.edit().putInt("ratingDenied", 100).apply();
                    /*mTracker.send(new HitBuilders.EventBuilder()
                            .setCategory("Action")
                            .setAction("Rating_Yes")
                            .build());
                    prefs.edit().putBoolean("neverShowRatingAgain", true).apply();
                    if (mListener != null) {
                        mListener.onRatingFinished();
                    }*/
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + Config.APP_PNAME)));
                }
            });
        }
    }

    public interface onRatingFinishedListener {
        void onRatingFinished();
    }
}
