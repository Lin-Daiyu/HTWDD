package de.htwdd;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import de.htwdd.R;

import de.htwdd.types.TBuchSuche;

public class BiblioSearchArrayAdapter extends ArrayAdapter<String>
{
    private final Context context;

    private String[] titles;
    private TBuchSuche[] essen;
    ViewGroup parent;


    public BiblioSearchArrayAdapter(Context context, String[] titles, TBuchSuche[] buecher)
    {
        super(context, R.layout.notenrow4, titles);
        this.context = context;
        this.essen = buecher;
        this.titles = titles;


    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.notenrow4, parent, false);
        TextView titles_tv = (TextView) rowView.findViewById(R.id.pruftitel);
        TextView prices_tv = (TextView) rowView.findViewById(R.id.art);
        TextView art_tv = (TextView) rowView.findViewById(R.id.pruftag);
        ImageView image = (ImageView) rowView.findViewById(R.id.image);


        this.parent = parent;


        titles_tv.setText(titles[position]);
        prices_tv.setText(essen[position]._verfasser);
        if (essen[position]._pic != null) image.setImageBitmap(essen[position]._pic);
        if (essen[position]._info != null) art_tv.setText(Html.fromHtml(essen[position]._info));
        // web_tv.loadData(essen[position], "text/html", "utf-8");


        return rowView;
    }


}