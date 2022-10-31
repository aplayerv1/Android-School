package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "Name";
    private static final String ARG_PARAM2 = "Height";
    private static final String ARG_PARAM3 = "Mass";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String mParam3;
    public DetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailsFragment newInstance(String param1, String param2,String param3) {
        DetailsFragment fragment = new DetailsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putString(ARG_PARAM3, param3);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details,container,false);

        TextView tv = (TextView) view.findViewById(R.id.textView6);
//        TextView tv1 = (TextView)container.findViewById(R.id.textView4);
//        TextView tv2 = (TextView)container.findViewById(R.id.textView5);


        Bundle b = getArguments();

        tv.setText(getArguments().getString("name"));
//        tv1.setText(getArguments().getString("height"));
//        tv2.setText(getArguments().getString("mass"));

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false);

    }

}