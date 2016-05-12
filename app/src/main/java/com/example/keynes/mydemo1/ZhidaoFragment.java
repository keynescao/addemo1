package com.example.keynes.mydemo1;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.keynes.adpter.ListDataAdapter;
import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.bitmap.PauseOnScrollListener;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 知道碎片界面
 * @author wwj_748
 *
 */
public class ZhidaoFragment extends Fragment {

	private PullToRefreshListView mListView;

	private LinkedList<String> listData = new LinkedList<String>();

	private ListDataAdapter dataAdapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.main_tab1_fragment, container,false);

		mListView = (PullToRefreshListView )view.findViewById(R.id.listView1);

		ILoadingLayout  layoutlab =  mListView.getLoadingLayoutProxy(true,false);
		layoutlab.setPullLabel("下拉刷新...");
		layoutlab.setRefreshingLabel("加载中...");
		layoutlab.setReleaseLabel("松开刷新...");


		BitmapUtils bitmapUtils = new BitmapUtils(getContext());
		mListView.setOnScrollListener(new PauseOnScrollListener(bitmapUtils,false,true));

		mListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
			@Override
			public void onRefresh(PullToRefreshBase<ListView> refreshView) {
				new LoadData().execute();
			}

		});
		listData = getDataList();
		dataAdapter = new ListDataAdapter(listData,getActivity());
		mListView.setAdapter(dataAdapter);


		return view;
	}

	class LoadData extends AsyncTask<Void,Void,LinkedList<String>>{
		@Override
		protected LinkedList<String> doInBackground(Void... params) {
			try {
				Thread.sleep(1000);
			}catch (Exception ex){

			}
			return getDataList1();

		}

		@Override
		protected void onPostExecute(LinkedList<String> s) {

			listData.addAll(0,s);
			dataAdapter.notifyDataSetChanged();
			mListView.onRefreshComplete();
			super.onPostExecute(s);
		}
	}
	private LinkedList<String> getDataList1(){
		LinkedList<String> list = new LinkedList<String>();
		String []imgs = {
				"http://list.image.baidu.com/t/image_category/galleryimg/menstar/hk/wu_zun.jpg",
				"http://list.image.baidu.com/t/image_category/galleryimg/menstar/hk/wu_zun.jpg",
				"http://list.image.baidu.com/t/image_category/galleryimg/menstar/hk/wu_zun.jpg",
				"http://list.image.baidu.com/t/image_category/galleryimg/menstar/hk/wu_zun.jpg",
				"http://list.image.baidu.com/t/image_category/galleryimg/menstar/hk/wu_zun.jpg"
		};
		int idx = 0;
		for(int i=0;i<5;i++){
			idx = i%5;
			if(idx <5){
				list.add(imgs[idx] +"|Hello" + System.currentTimeMillis() +"=" +i);
			}else{
				list.add("0|Hello" + System.currentTimeMillis() +"=" + i);
			}
		}
		return list;
	}

	private LinkedList<String> getDataList(){
		LinkedList<String> list = new LinkedList<String>();
		String []imgs = {
				"http://list.image.baidu.com/t/image_category/galleryimg/menstar/hk/wang_li_hong.jpg",
				"http://list.image.baidu.com/t/image_category/galleryimg/menstar/hk/wu_zun.jpg",
				"http://list.image.baidu.com/t/image_category/galleryimg/menstar/hk/he_run_dong.jpg",
				"http://list.image.baidu.com/t/image_category/galleryimg/menstar/hk/jin_cheng_wu.jpg",
				"http://list.image.baidu.com/t/image_category/galleryimg/menstar/hk/wu_yan_zu.jpg"
		};
		int idx = 0;
		for(int i=0;i<8;i++){
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
