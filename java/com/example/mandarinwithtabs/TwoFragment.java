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
public class TwoFragment extends Fragment {

    ArrayList<Word> familyList;

    public TwoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView=inflater.inflate(R.layout.fragment_fragment_two, container, false);


        familyList=new ArrayList<>();
        familyList.add(new Word("Father", "父亲",R.drawable.family_father));
        familyList.add(new Word("Mother","妈妈",R.drawable.family_mother));
        familyList.add(new Word("Son","儿子",R.drawable.family_son));
        familyList.add(new Word("Daughter","女儿",R.drawable.family_daughter));
        familyList.add(new Word("Younger brother","弟弟",R.drawable.family_younger_brother));
        familyList.add(new Word("Younger sister","妹妹",R.drawable.family_younger_sister));
        familyList.add(new Word("Grandmother","姥姥",R.drawable.family_grandmother));
        familyList.add(new Word("Grandfather","爷爷",R.drawable.family_grandfather));
        familyList.add(new Word("Elder brother","哥哥",R.drawable.family_older_brother));
        ListView listView=rootView.findViewById(R.id.familyList);
        WordAdapter adapter=new WordAdapter(getActivity(), familyList,R.color.green);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                Toast.makeText(getActivity(),familyList.get(pos).getmDefaultTranslation() ,Toast.LENGTH_SHORT ).show();
            }
        });
        return rootView;
    }

}
