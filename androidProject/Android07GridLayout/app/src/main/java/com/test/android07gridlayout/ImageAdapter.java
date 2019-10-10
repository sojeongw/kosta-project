package com.test.android07gridlayout;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;

/**
 * Created by Administrator on 2017-09-14.
 */

class ImageAdapter extends BaseAdapter {
    private Context c;
    static Integer[] imgs = new Integer[]{
            // 얘가 가리키는 건 실제로는 이미지이나 정수값을 갖고 있기 때문에 integer 배열로 처리
            R.drawable.sample_0, R.drawable.sample_1, R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5, R.drawable.sample_6, R.drawable.sample_7,
            R.drawable.sample_0, R.drawable.sample_1, R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5, R.drawable.sample_6, R.drawable.sample_7,
            R.drawable.sample_0, R.drawable.sample_1, R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5, R.drawable.sample_6, R.drawable.sample_7,
            R.drawable.sample_0, R.drawable.sample_1, R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5, R.drawable.sample_6, R.drawable.sample_7
    };

    public ImageAdapter(Context c) {
        this.c = c;
    }

    @Override
    public int getCount() {
        return imgs.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView iv = null;
        if(convertView==null){
            iv = new ImageView(c);
            // 이미지 사이즈를 그리드에 맞게 하기
            iv.setLayoutParams(new GridView.LayoutParams(100, 100));
            iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
            iv.setPadding(8, 8, 8, 8);
        } else {
            iv = (ImageView) convertView;
        }

        // sample_0은 ims의 0번 방에 들어있으니까
        iv.setImageResource(imgs[position]);
        return iv;
    }
}
