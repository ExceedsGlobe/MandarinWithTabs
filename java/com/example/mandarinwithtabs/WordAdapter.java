package com.example.mandarinwithtabs;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * {@link WordAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Word} objects.
 */
public class WordAdapter extends ArrayAdapter<Word> {
int color;

    /**
     * Create a new {@link WordAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param numbersList is the list of {@link Word}s to be displayed.
     * @param color is the resource ID for the background color for this list of words
     */
    public WordAdapter(Activity context,ArrayList<Word> numbersList,int color) {
        super(context,0,numbersList);
        this.color=color;
    }

    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
       //Inflating the view
        View root= LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent,false);
        // Get the {@link Word} object located at this position in the list
        Word currentWord=getItem(position);
        // Find the TextView in the list_item.xml layout with the ID default_lang_txtView.
        TextView defaultTrans=(TextView)root.findViewById(R.id.default_lang);

        TextView mandarinTrans=root.findViewById(R.id.mandarin_lang);
        ImageView image=root.findViewById(R.id.imageView);
        // Get the default translation from the currentWord object and set this text on
        // the default TextView.
        defaultTrans.setText(currentWord.getmDefaultTranslation());
        mandarinTrans.setText(currentWord.getmMandarinTranslation());

        if (currentWord.getmImageResourceID()!=-1){
            image.setVisibility(View.VISIBLE);
            image.setImageResource(currentWord.getmImageResourceID());

        }else{

            image.setVisibility(View.GONE);
        }
        // Set the theme color for the list item
        View viewContainer =root.findViewById(R.id.container);
// Find the color that the resource ID maps to
        int colour= ContextCompat.getColor(getContext(),color);
        // Set the background color of the text container View
        viewContainer.setBackgroundColor(colour);
        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return root;

    }
}
