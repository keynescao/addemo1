package com.example.keynes.adpter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.keynes.ImageUtil;
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
        final HoldTag tag;
        if(convertView == null){
            tag = new HoldTag();
            convertView = layoutInflater.inflate(R.layout.items,null);
            tag.textView = (TextView)convertView.findViewById(R.id.question);
            tag.imageView = (ImageView)convertView.findViewById(R.id.questimg);
            convertView.setTag(tag);
        }else{
            tag = (HoldTag)convertView.getTag();
        }

        String value[] = data.get(position).split("\\|");
        tag.textView.setText(value[1]);

        String url  = value[0];
        if(url.length()>1){
            ImageUtil.loadImageDrawable(url, new ImageUtil.ImageLoadListener() {
                @Override
                public void load(Drawable drawable) {
                    //tag.imageView.setImageDrawable(drawable);
                    tag.imageView.setBackground(drawable);
                    tag.imageView.setOnClickListener(new ImageView.OnClickListener(){
                        @Override
                        public void onClick(View v) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                            builder.setMessage(String.valueOf(System.currentTimeMillis()))
                                    .setTitle("TimeUnix")
                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    })
                                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    })
                                    .create()
                                    .show();
                        }
                    });
                }
            });
        }else{
            tag.imageView.setImageResource(R.drawable.btn_know_nor);
        }
        return convertView;
    }


    class HoldTag{
        TextView textView;
        ImageView imageView;
    }
}
