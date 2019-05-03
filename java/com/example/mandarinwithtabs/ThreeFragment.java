package com.example.mandarinwithtabs;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ThreeFragment extends Fragment {

    ListView listView;
    ArrayList<Word> colorsList;
    public ThreeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_fragment_three, container, false);
        listView = root.findViewById(R.id.colors_list);
        colorsList = new ArrayList<>();
        colorsList.add(new Word("Red", "红色-Hóngsè",R.drawable.color_red));
        colorsList.add(new Word("Green", "绿色-Lǜsè",R.drawable.color_green));
        colorsList.add(new Word("Brown", "棕色-Zōngsè",R.drawable.color_brown));
        colorsList.add(new Word("Grey", "灰色-Huīsè",R.drawable.color_gray));
        colorsList.add(new Word("Black", "黑色-Hēisè",R.drawable.color_black));
        colorsList.add(new Word("White", "白色-Báisè",R.drawable.color_white));
        colorsList.add(new Word("Yellow", "黄色-Huángsè",R.drawable.color_mustard_yellow));
        WordAdapter adapter = new WordAdapter(getActivity(), colorsList,R.color.purple);
        listView.setAdapter(adapter);
        // Inflate the layout for this fragment
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                Toast.makeText(getActivity(),colorsList.get(pos).getmDefaultTranslation() ,Toast.LENGTH_SHORT ).show();
            }
        });
        return root;
    }

}
