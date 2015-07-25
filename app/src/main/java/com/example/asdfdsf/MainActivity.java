package com.example.asdfdsf;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
/**
 * 为了能够显示嵌套的ListView的条目，相关的数据适配器，必须集成子BaseAdapter()
 * @author Administrator
 *
 */
public class MainActivity extends Activity {

	private ListView lv;
	private MyAdapter2 adapter2;
	private MyAdapter adapter;
	MultiDirectionSlidingDrawer drawer;
	public static String[] ItemName = { "超市", "婴幼专场", "美食", "酒店", "休闲娱乐", "洗浴",
			"美容", "保健", "足浴按摩", "旅游", "菜市场", "摄影服务", "生活缴费", "购物", "运动健身",
			"出行工具", "金融ATM", "通信", "电子设备", "家用电器", "家庭汽车", "工程机车", "起重设备",
			"农机工具", "医疗", "苗圃花卉", "鱼鸟宠物", "家居饰品", "建筑材料", "建筑机械", "建筑工具",
			"家居建材", "代理机构", "土木机械", "木材市场", "电影演出", "房产楼盘", "消防器材", "电力设施",
			"车站", "当地特产", "教育", "化工", "办公", "收藏", "家纺", "机床设备", "殡仪", "广告传媒",
			"两性用品" };

	int[] images = { R.drawable.market, R.drawable.baby, R.drawable.food,
			R.drawable.hotel, R.drawable.game, R.drawable.bath,
			R.drawable.hairdressing, R.drawable.health, R.drawable.foot,
			R.drawable.travel, R.drawable.vegetable, R.drawable.camera,
			R.drawable.pay, R.drawable.shopping, R.drawable.sport,
			R.drawable.trip, R.drawable.atm, R.drawable.call,
			R.drawable.electronic, R.drawable.home_electronic, R.drawable.car,
			R.drawable.truck, R.drawable.crane, R.drawable.agricultural,
			R.drawable.medical, R.drawable.flower, R.drawable.pet,
			R.drawable.accessories, R.drawable.material, R.drawable.machinery,
			R.drawable.buildingtool, R.drawable.building_materials,
			R.drawable.agency, R.drawable.construction, R.drawable.wood,
			R.drawable.film, R.drawable.premises, R.drawable.firecontrol,
			R.drawable.facilities, R.drawable.station, R.drawable.specialty,
			R.drawable.education, R.drawable.chemical, R.drawable.office,
			R.drawable.collect, R.drawable.textiles, R.drawable.machine_tool,
			R.drawable.funeral, R.drawable.advertisement, R.drawable.sex };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
		setContentView(R.layout.activity_main);
		lv = (ListView) findViewById(R.id.content);
//		lv.setDivider(null);
		adapter = new MyAdapter(MainActivity.this,images,ItemName);
		lv.setAdapter(adapter);
		adapter.notifyDataSetChanged();
		adapter2 = new MyAdapter2();
		drawer = (MultiDirectionSlidingDrawer) findViewById(R.id.drawer);
		drawer.animateOpen();
	}

	private class MyAdapter extends BaseAdapter {

		private int[] images;
		private String[] itemName;
		private Context context;
		private LayoutInflater mInflater;

		public MyAdapter(Context context, int[] images, String[] itemName) {
			this.context = context;
			this.images = images;
			this.itemName = itemName;
			this.mInflater = LayoutInflater.from(this.context);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 10;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@SuppressLint("ViewHolder")
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			convertView = mInflater.inflate(R.layout.slider_inner_item, null);
			final LinearLayout ll1 = (LinearLayout) convertView
					.findViewById(R.id.ll1);
			LinearLayout ll2 = (LinearLayout) convertView
					.findViewById(R.id.ll2);
			LinearLayout ll3 = (LinearLayout) convertView
					.findViewById(R.id.ll3);
			LinearLayout ll4 = (LinearLayout) convertView
					.findViewById(R.id.ll4);
			LinearLayout ll5 = (LinearLayout) convertView
					.findViewById(R.id.ll5);

			ImageView iv1 = (ImageView) convertView.findViewById(R.id.iv1);
			ImageView iv2 = (ImageView) convertView.findViewById(R.id.iv2);
			ImageView iv3 = (ImageView) convertView.findViewById(R.id.iv3);
			ImageView iv4 = (ImageView) convertView.findViewById(R.id.iv4);
			ImageView iv5 = (ImageView) convertView.findViewById(R.id.iv5);

			TextView title1 = (TextView) convertView.findViewById(R.id.title1);
			TextView title2 = (TextView) convertView.findViewById(R.id.title2);
			TextView title3 = (TextView) convertView.findViewById(R.id.title3);
			TextView title4 = (TextView) convertView.findViewById(R.id.title4);
			TextView title5 = (TextView) convertView.findViewById(R.id.title5);

			title1.setText(itemName[position * 5]);
			title2.setText(itemName[position * 5 + 1]);
			title3.setText(itemName[position * 5 + 2]);
			title4.setText(itemName[position * 5 + 3]);
			title5.setText(itemName[position * 5 + 4]);

			iv1.setBackgroundResource(images[position * 5]);
			iv2.setBackgroundResource(images[position * 5 + 1]);
			iv3.setBackgroundResource(images[position * 5 + 2]);
			iv4.setBackgroundResource(images[position * 5 + 3]);
			iv5.setBackgroundResource(images[position * 5 + 4]);
			
			ll1.setTag(position * 5);
			ll2.setTag(position * 5 + 1);
			ll3.setTag(position * 5 + 2);
			ll4.setTag(position * 5 + 3);
			ll5.setTag(position * 5 + 4);

			/**
			 * 记录两次点击的是否是同一个position，但是要用int值的话，是没有办法处理的，无奈之下使用一个数组实现了
			 */
			final String[] lastPosition = { "abc" };

			final ListView lv2 = (ListView) convertView
					.findViewById(R.id.lv_lv1);
			ll1.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					adapter2.notifyDataSetChanged();
					System.out.println("点击了第一个按钮");
					if (lastPosition[0].endsWith(v.getTag() + "")) {
						lv2.setVisibility(View.GONE);
						lastPosition[0] = "abc";
					} else {
						lv2.setVisibility(View.VISIBLE);
						lv2.setAdapter(adapter2);
						adapter2.notifyDataSetChanged();

						lastPosition[0] = v.getTag() + "";
					}

				}
			});
			ll2.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					System.out.println("点击了第2个按钮");
					System.out.println("lastPosition:" + lastPosition[0]);
					if (lastPosition[0].endsWith(v.getTag() + "")) {
						lv2.setVisibility(View.GONE);
						lastPosition[0] = "abc";
					} else {
						lv2.setVisibility(View.VISIBLE);
						lv2.setAdapter(new MyAdapter2());
						lastPosition[0] = v.getTag() + "";
					}
				}
			});
			ll3.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					System.out.println("点击了第3个按钮");
					if (lastPosition[0].endsWith(v.getTag() + "")) {
						lv2.setVisibility(View.GONE);
						lastPosition[0] = "abc";
					} else {
						lv2.setVisibility(View.VISIBLE);
						lv2.setAdapter(new MyAdapter2());
						lastPosition[0] = v.getTag() + "";
					}
				}
			});
			ll4.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					System.out.println("点击了第4个按钮");
					if (lastPosition[0].endsWith(v.getTag() + "")) {
						lv2.setVisibility(View.GONE);
						lastPosition[0] = "abc";
					} else {
						lv2.setVisibility(View.VISIBLE);
						lv2.setAdapter(new MyAdapter2());
						lastPosition[0] = v.getTag() + "";
					}
				}
			});

			ll5.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					System.out.println("点击了第5个按钮");
					if (lastPosition[0].endsWith(v.getTag() + "")) {
						lv2.setVisibility(View.GONE);
						lastPosition[0] = "abc";
					} else {
						lv2.setVisibility(View.VISIBLE);
						lv2.setAdapter(new MyAdapter2());
						lastPosition[0] = v.getTag() + "";
					}
				}
			});

			// if (lv2.getVisibility()==View.VISIBLE) {
			lv2.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					// TODO Auto-generated method stub
					Toast.makeText(MainActivity.this, "我被点击了", 0).show();
				}
			});
			// }
			return convertView;
		}

	}

	private class MyAdapter2 extends BaseAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 4;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@SuppressLint("ViewHolder")
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			convertView = View.inflate(MainActivity.this, R.layout.slider_inner_item_inner_item, null);
			return convertView;
		}

	}

}
