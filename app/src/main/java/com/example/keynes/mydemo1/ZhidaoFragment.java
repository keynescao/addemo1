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
		String []imgs = {
				"http://list.image.baidu.com/t/image_category/galleryimg/menstar/hk/wang_li_hong.jpg",
				"http://list.image.baidu.com/t/image_category/galleryimg/menstar/hk/wu_zun.jpg",
				"http://list.image.baidu.com/t/image_category/galleryimg/menstar/hk/he_run_dong.jpg",
				"http://list.image.baidu.com/t/image_category/galleryimg/menstar/hk/jin_cheng_wu.jpg",
				"http://list.image.baidu.com/t/image_category/galleryimg/menstar/hk/wu_yan_zu.jpg"
		};
		int idx = 0;
		for(int i=0;i<100;i++){
			idx = i%5;
			if(idx <5){
				list.add(imgs[idx] +"|Hello" + System.currentTimeMillis() +"=" +i);
			}else{
				list.add("0|Hello" + System.currentTimeMillis() +"=" + i);
			}
		}
		return list;
	}

}
