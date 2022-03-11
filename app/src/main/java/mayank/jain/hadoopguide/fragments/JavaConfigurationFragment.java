package mayank.jain.hadoopguide.fragments;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ZoomControls;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import mayank.jain.hadoopguide.R;
import mayank.jain.hadoopguide.others.DataProvider;

import static mayank.jain.hadoopguide.others.DataProvider.JAVA_DATA_IMAGE;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link JavaConfigurationFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link JavaConfigurationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class JavaConfigurationFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private AdView mAdView;
    private OnFragmentInteractionListener mListener;
    private RecyclerView mRecyclerView;
    protected String[] mDataset;
    float originalx,originaly,x,y;
    ZoomControls zoom;
    public JavaConfigurationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment JavaConfigurationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static JavaConfigurationFragment newInstance(String param1, String param2) {
        JavaConfigurationFragment fragment = new JavaConfigurationFragment();
       /* Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);*/
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       /* if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_java_configuration, container, false);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.my_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(new SimpleAdapter());
        mAdView = (AdView) v.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        originalx = mRecyclerView.getScaleX();
        originaly =mRecyclerView.getScaleY();
        zoom = (ZoomControls) v.findViewById(R.id.zoomControls1);
        zoom.setOnZoomInClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                x = originalx;
                y = originaly;

                mRecyclerView.setScaleX((float) (x+0.5));
                mRecyclerView.setScaleY((float) (y+0.5));
            }
        });

        zoom.setOnZoomOutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(originalx < x && originaly < y) {
                    mRecyclerView.setScaleX((float) (x - 0.5));
                    mRecyclerView.setScaleY((float) (y - 0.5));
                }else {
                    mRecyclerView.setScaleX(originalx);
                    mRecyclerView.setScaleY(originaly);
                }
            }
        });

        return v;
    }
    class SimpleHolder extends RecyclerView.ViewHolder {

        TextView mTextView,mTextViewHeading;
        ImageView mImageView;


        public SimpleHolder(final View itemView) {
            super(itemView);
            this.mTextView = (TextView) itemView.findViewById(R.id.crdtextView);
            this.mImageView = (ImageView) itemView.findViewById(R.id.imageView);
            this.mTextViewHeading = (TextView) itemView.findViewById(R.id.headingtv);
        }
    }

    class SimpleAdapter extends RecyclerView.Adapter<JavaConfigurationFragment.SimpleHolder> {

        @Override
        public int getItemCount() {
            return DataProvider.JAVA_DATA_HEADING.length;
        }

        @Override
        public JavaConfigurationFragment.SimpleHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view_row, viewGroup, false);
            view.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    int pos = mRecyclerView.getChildAdapterPosition(v);
                    if (pos >= 0 && pos < getItemCount()) {
                        //Toast.makeText(getContext(), DataProvider.JAVA_DATA_HEADING[pos], Toast.LENGTH_SHORT).show();
                    }
                }
            });

            return new SimpleHolder(view);
        }

        @Override
        public void onBindViewHolder(SimpleHolder simpleHolder, int i) {
            simpleHolder.mTextView.setText(DataProvider.JAVA_DATA_BRIEF[i]);
            simpleHolder.mTextViewHeading.setText(DataProvider.JAVA_DATA_HEADING[i]);
          /*  Drawable d = getResources().getDrawable(DataProvider.JAVA_DATA_IMAGE[i]);
            simpleHolder.mImageView.setImageDrawable(d);*/
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) { //>= API 21
                simpleHolder.mImageView.setImageDrawable(getResources().getDrawable(JAVA_DATA_IMAGE[i],getContext().getTheme()));

                //myImgView.setImageDrawable(getResources().getDrawable(R.drawable.myimage, getApplicationContext().getTheme()));
            } else {
                //myImgView.setImageDrawable(getResources().getDrawable(R.drawable.myimage));
                simpleHolder.mImageView.setImageDrawable(getResources().getDrawable(JAVA_DATA_IMAGE[i]));
            }

        }

    }
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
