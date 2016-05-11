package com.example.keynes.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.keynes.mydemo1.R;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by keynes on 2016/4/14.
 */
public class ListDataAdapter extends BaseAdapter {

    private List<String> data;
    private Context mContext;
    private LayoutInflater layoutInflater;

    public ListDataAdapter(List<String> list, Context mContext){
        this.data = list;
        this.mContext = mContext;
        this.layoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HoldTag tag;
        if(convertView == null){
            tag = new HoldTag();
            convertView = layoutInflater.inflate(R.layout.items,null);
            tag.textView = (TextView)convertView.findViewById(R.id.question);
            convertView.setTag(tag);
        }else{
            tag = (HoldTag)convertView.getTag();
        }

        tag.textView.setText(data.get(position));
        return convertView;
    }


    class HoldTag{
        TextView textView;
    }
}
