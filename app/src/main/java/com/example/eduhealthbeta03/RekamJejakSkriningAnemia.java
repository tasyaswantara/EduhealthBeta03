package com.example.eduhealthbeta03;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RekamJejakSkriningAnemia#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RekamJejakSkriningAnemia extends Fragment {

    private CheckBox[] checkBoxes = new CheckBox[24]; // Jumlah CheckBox disesuaikan

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RekamJejakSkriningAnemia() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RekamJejakSkriningAnemia.
     */
    // TODO: Rename and change types and number of parameters
    public static RekamJejakSkriningAnemia newInstance(String param1, String param2) {
        RekamJejakSkriningAnemia fragment = new RekamJejakSkriningAnemia();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rekam_jejak_skrining_anemia, container, false);


        for (int i = 0; i < checkBoxes.length; i++) {
            int checkBoxId = getResources().getIdentifier("checkbox" + (i + 1), "id", getActivity().getPackageName());
            checkBoxes[i] = view.findViewById(checkBoxId);
        }

        // Pengaturan hanya satu checkbox dapat dipilih per baris
        setSingleSelection(new CheckBox[]{checkBoxes[0], checkBoxes[1]});
        setSingleSelection(new CheckBox[]{checkBoxes[2], checkBoxes[3]});
        setSingleSelection(new CheckBox[]{checkBoxes[4], checkBoxes[5]});
        setSingleSelection(new CheckBox[]{checkBoxes[6], checkBoxes[7]});
        setSingleSelection(new CheckBox[]{checkBoxes[8], checkBoxes[9]});
        setSingleSelection(new CheckBox[]{checkBoxes[10], checkBoxes[11]});
        setSingleSelection(new CheckBox[]{checkBoxes[12], checkBoxes[13]});
        setSingleSelection(new CheckBox[]{checkBoxes[14], checkBoxes[15]});
        setSingleSelection(new CheckBox[]{checkBoxes[16], checkBoxes[17]});
        setSingleSelection(new CheckBox[]{checkBoxes[18], checkBoxes[19]});
        setSingleSelection(new CheckBox[]{checkBoxes[20], checkBoxes[21]});
        setSingleSelection(new CheckBox[]{checkBoxes[22], checkBoxes[23]});


        return view;
    }

    private void setSingleSelection(CheckBox[] checkBoxes) {
        for (CheckBox checkBox : checkBoxes) {
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        for (CheckBox cb : checkBoxes) {
                            if (cb != buttonView) {
                                cb.setChecked(false);
                            }
                        }
                    }
                }
            });
        }
    }
}
