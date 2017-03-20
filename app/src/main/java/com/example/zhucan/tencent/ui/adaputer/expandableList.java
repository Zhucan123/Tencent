package com.example.zhucan.tencent.ui.adaputer;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zhucan.tencent.R;

/**
 * Created by zhucan on 2017/3/19.
 */

public class expandableList extends BaseExpandableListAdapter{
    String[] group;
    String[][]child;
    int[][] image;
    Context context;
    public expandableList(Context contexts,String[]group, String[][]child, int[][]image){
        this.child=child;
        this.group=group;
        this.image=image;
        this.context=contexts;
    }
    @Override
    public Object getChild(int groupPosition,int childPosition){
        return child[groupPosition][childPosition];
    }
    @Override
    public long getChildId(int groupPosition,int childPosition){
        return childPosition;
    }
    @Override
    public int getChildrenCount(int groupPosition){
        return child[groupPosition].length;
    }
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
                             View convertView,ViewGroup parent){
        View view= LayoutInflater.from(context).inflate(R.layout.expanda_child,null);
        ImageView imageView=(ImageView)view.findViewById(R.id.childImage);
        imageView.setImageResource(image[groupPosition][childPosition]);
        TextView textView=(TextView)view.findViewById(R.id.child);
        textView.setText(child[groupPosition][childPosition]);
        TextView textView1=(TextView)view.findViewById(R.id.onLine);
        textView1.setText("[手机在线]");

        return view;
    }


    @Override
    public Object getGroup(int groupPosition){
        return group[groupPosition];
    }
    @Override
    public long getGroupId(int groupPosition){
        return groupPosition;
    }
    @Override
    public int getGroupCount(){
        return group.length;
    }
    @Override
    public View getGroupView(int groupPosition, boolean isLastChild,
                             View convertView,ViewGroup parent){
        View view=LayoutInflater.from(context).inflate(R.layout.expanda_group,null);
        TextView textView=(TextView)view.findViewById(R.id.groupName);
        textView.setText(group[groupPosition]);
        TextView textView1=(TextView)view.findViewById(R.id.groupNumber);
        textView1.setText(child[groupPosition].length+"/"+child[groupPosition].length);
        return view;
    }
    @Override
    public boolean isChildSelectable(int groupPosition,int childPosition){
        return true;
    }
    @Override
    public boolean hasStableIds(){
        return true;
    }
}

