package com.example.englishmahyou011;

import android.content.Context;
import androidx.core.content.ContextCompat;
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
public class  WordAdapter extends ArrayAdapter<Word>  {
    /** Resource ID for the background color for this list of words */
    private int mColorResourceId;
    /**
     * Create a new {@link WordAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param words is the list of {@link Word}s to be displayed.
     */
    // public WordAdapter(Context context, ArrayList<Word> words) {
    //super(context, 0, words);
    //  }
    public WordAdapter(Context context, ArrayList<Word> words, int colorResourceId) {
        super(context, 0, words);
        mColorResourceId = colorResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID miwok_text_view.
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        // Get the Miwok translation from the currentWord object and set this text on
        // the Miwok TextView.
        miwokTextView.setText(currentWord.getMiwokTranslation());



        // Find the TextView in the list_item.xml layout with the ID default_text_view.
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the default translation from the currentWord object and set this text on
        // the default TextView.
        defaultTextView.setText(currentWord.getDefaultTranslation());



// Find the TextView in the list_item.xml layout with the ID arabe_text_view.
        TextView arabeTextView = (TextView) listItemView.findViewById(R.id.arab_text_view);
        // Get the default translation from the currentWord object and set this text on
        // the default TextView.
        arabeTextView.setText(currentWord.getArabe());


        // Find the TextView in the list_item.xml layout with the ID miwok_text_view.
        ImageView imageview = (ImageView) listItemView.findViewById(R.id.image);
        // Get the Miwok translation from the currentWord object and set this text on
        // the Miwok TextView.
        if (currentWord.hasImage()) {
            imageview.setImageResource(currentWord.getImageResourceId());
            imageview.setVisibility(View.VISIBLE);}
        else {
            imageview.setVisibility(View.GONE);
        }
        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);


        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }
}
