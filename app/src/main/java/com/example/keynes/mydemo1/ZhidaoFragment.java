package com.example.keynes.mydemo1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.keynes.adpter.ListDataAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 知道碎片界面
 * @author wwj_748
 *
 */
public class ZhidaoFragment extends Fragment {

	private ListView mListView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.main_tab1_fragment, container,false);

		mListView = (ListView)view.findViewById(R.id.listView1);


		mListView.setAdapter(new ListDataAdapter(getDataList(),getActivity()));

		return view;
	}

	private List<String> getDataList(){
		List<String> list = new ArrayList<String>();
		for(int i=0;i<100;i++){
			list.add("Hello" + System.currentTimeMillis());
		}
		return list;
	}

}
