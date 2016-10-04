package mvp.globalweather.cleanarchitecture.stefano.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;


import mvp.globalweather.cleanarchitecture.stefano.R;
import mvp.globalweather.cleanarchitecture.stefano.model.cities.Postalcodes;

public class CityListAdapter extends ArrayAdapter {

private ArrayAdapterCallback callback;

    public CityListAdapter(final List<Postalcodes> cities, final Context context) {
        super(context, 0, cities);

    }


    @Override
    public boolean isEnabled(final int position) {
        return false;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            convertView = layoutInflater.inflate(R.layout.city_list_item, null);
            viewHolder = new ViewHolder();
            viewHolder.city = (TextView) convertView.findViewById(R.id.city);
            viewHolder.item = (LinearLayout) convertView.findViewById(R.id.item);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final Postalcodes postalcodes = (Postalcodes) getItem(position);
        viewHolder.city.setText(postalcodes.getPlaceName()+" - ("+postalcodes.getCountryCode()+")");

        viewHolder.item.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(callback != null) {

                    callback.LoadCity( ((Postalcodes) getItem(position)).getLat(),((Postalcodes) getItem(position)).getLng());
                }
            }
        });
        return convertView;
    }

    public void setCallback(ArrayAdapterCallback callback){

        this.callback = callback;
    }

    /**
     * Cache to avoid doing expensive findViewById() calls for each getView().
     */
    private class ViewHolder {
        private TextView city;
        public LinearLayout item;
    }




}
