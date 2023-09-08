package com.example.morseify;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationBarView;

import org.json.JSONArray;

import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link morseConverterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class morseConverterFragment extends Fragment implements View.OnClickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final int count=0;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View mView;
    private ImageButton convertButton;
    private int textCount;
    private String convertText;
    HashMap<String, String> map = new HashMap<>();
    NavigationBarView navigationBarView;


    public morseConverterFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment morseConverterFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static morseConverterFragment newInstance(String param1, String param2) {
        morseConverterFragment fragment = new morseConverterFragment();
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

        map.put("A",".-");
        map.put("B","-...");
        map.put("C","-.-.");
        map.put("D","-..");
        map.put("E",".");
        map.put("F","..-.");
        map.put("G","--.");
        map.put("H","....");
        map.put("I","..");
        map.put("J",".---");
        map.put("K","-.-");
        map.put("L",".-..");
        map.put("M","--");
        map.put("N","-.");
        map.put("O","---");
        map.put("P",".--.");
        map.put("Q","--.-");
        map.put("R",".-.");
        map.put("S","...");
        map.put("T","-");
        map.put("U","..-");
        map.put("V","...-");
        map.put("W",".--");
        map.put("X","-..-");
        map.put("Y","-.--");
        map.put("Z","--..");
        map.put("1",".----");
        map.put("2","..---");
        map.put("3","...--");
        map.put("4","....-");
        map.put("5",".....");
        map.put("6","-....");
        map.put("7","--...");
        map.put("8","---..");
        map.put("9","----.");
        map.put("0","-----");
        map.put("'","--..---");
        map.put(".",".-.-.-");
        map.put(" ", "\\");
        map.put("\n","\n");

//        NavigationBarView.OnItemSelectedListener listener = new NavigationBarView.OnItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                Log.v("Tag","Inside nav lister");
//                if (item.getItemId() == R.id.item_1) {
//                    Log.v("Tag","Inside Info selected");
//                    Toast.makeText(getContext(), "Info selected", Toast.LENGTH_SHORT).show();
//                } else {
//                    throw new IllegalStateException("Unexpected value: " + item.getItemId());
//                }
//                return false;
//            }
//        };
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_morse_converter, container, false);
        convertButton = (ImageButton) mView.findViewById(R.id.imageButton);
        convertButton.setOnClickListener(this);
        return mView;
    }

    @Override
    public void onClick(View v) {
        EditText editText = mView.findViewById(R.id.editText);
        String text = editText.getText().toString();
        Log.v("Tag", text);
        textCount = text.length();
        int i = 0;
        convertText = "";
        Activity activity = getActivity();
        while((textCount--)>0){
            char character = text.charAt(i++);
            convertText = convertText + " " + map.get(String.valueOf(character).toUpperCase());
        }
        TextView textView = mView.findViewById(R.id.morseTextMain);
        textView.setText(convertText);
    }
}