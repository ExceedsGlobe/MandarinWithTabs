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
public class FourFragment extends Fragment {

    ListView listView;
    ArrayList<Word> phrasesList;
    public FourFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_four, container, false);
        // Inflate the layout for this fragment
        listView=root.findViewById(R.id.phrases_list);
        phrasesList=new ArrayList<>();
        phrasesList.add(new Word("thank you so much","非常感谢。"));
        phrasesList.add(new Word("I really appreciate…","我真的很感激…"));
        phrasesList.add(new Word("where are you?","你在哪？"));
        phrasesList.add(new Word("are you coming","你来吗"));
        phrasesList.add(new Word("What do you think?","你怎么看？"));
        phrasesList.add(new Word("Thank you. That helps a lot.","谢谢。这有很大帮助。"));
        phrasesList.add(new Word("Nice to meet you.","谢谢。这有很大帮助。"));
        phrasesList.add(new Word("How can I help you?","很高兴见到你。"));
        phrasesList.add(new Word(" I’ll be with you in a moment.","我怎么帮你？ 我马上就会和你在一起。"));
        phrasesList.add(new Word ("Oh really  Actually, I thought…,","（哦，真的吗？）实际上，我想.."));
        WordAdapter wordAdapter=new WordAdapter(getActivity(),phrasesList ,R.color.blue );
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                Toast.makeText(getActivity(),phrasesList.get(pos).getmDefaultTranslation() ,Toast.LENGTH_SHORT ).show();
            }
        });
        listView.setAdapter(wordAdapter);
        return root;
    }

}
