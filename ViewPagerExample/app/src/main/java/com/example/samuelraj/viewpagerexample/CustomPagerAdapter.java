package com.example.samuelraj.viewpagerexample;

import android.content.Context;
import android.support.annotation.Size;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

public class CustomPagerAdapter extends PagerAdapter {

    public Context context;
    public ViewGroup viewGroup;
    int pages_total = 4;

    int[] pages = new int[]{
            R.layout.slide_1,
            R.layout.slide_2,
            R.layout.slide_3,
            R.layout.slide_4
    };

    public CustomPagerAdapter(Context context,ViewGroup viewGroup)
    {
        this.context = context;
        this.viewGroup = viewGroup;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position)
    {
        RelativeLayout layout =(RelativeLayout) View.inflate(context,pages[position],null);
        Button button = new Button(context);
        button.setLayoutParams(new ViewGroup.LayoutParams(ViewPager.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        button.setText("Next");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewPager viewPager = (ViewPager) viewGroup;
                int next;
                if(position >= pages_total)
                {
                    next = 0;
                }
                else
                {
                    next = position + 1;
                }
                viewPager.setCurrentItem(next);
            }
        });
        layout.addView(button);
        container.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(ViewGroup container,int position,Object object)
    {
        container.removeView((RelativeLayout)object);
    }

    @Override
    public int getCount() {
        return pages_total;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
