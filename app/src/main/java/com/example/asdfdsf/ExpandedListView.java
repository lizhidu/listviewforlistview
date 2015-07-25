package com.example.asdfdsf;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.ListView;
/**
 * 可以展开的listview
 * 为了实现listview的动态的展开和收回，必须重写OnMeasure()方法，
 * 同时相关布局文件要使用LinearLayout布局，只有LinearLayout才会走OnMeasure()方法
 * @author Administrator
 *
 */
public class ExpandedListView extends ListView{

	public ExpandedListView(Context context) {
		super(context);
		setBackgroundColor(Color.argb(100, 0, 55, 55));
	}
	
	
	
	public ExpandedListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}


	public ExpandedListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}


	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
				MeasureSpec.AT_MOST);

		super.onMeasure(widthMeasureSpec, expandSpec);
	}
}

