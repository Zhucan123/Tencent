package com.example.zhucan.tencent.ui;


import android.app.TabActivity;
import android.media.Image;
import android.net.http.X509TrustManagerExtensions;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.zhucan.tencent.R;
import com.example.zhucan.tencent.ui.adaputer.expandableList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by zhucan on 2017/3/18.
 */

public class Main extends TabActivity {
    private ExpandableListView also;
    private ExpandableListView group;
    private ListView messageList;
    private ListView zoneList;

    String [] alsoGroup={"特别关心","常用群聊"};
    String [][] alsoChild={{"老张","拉王"},{"3年2班","学友吧"}};
    int [][] alsoImage={{R.drawable.head_1,R.drawable.head_2},{R.drawable.head_3,R.drawable.head_4}};

    String [] groupGroup={"我的好友","小学同学","一群同事","宿舍的战斗机","动漫迷"};
    String [][] groupChild={{"小飞","雪花啤酒","颜神"},{"婉儿","杂耍哥","清妹子"},{"王总","宋科长"},{"lol一号选手","暗裔剑魔"},
            {"迷之男神","恐龙克星","未来漫画家","青山刚昌"}};
    int [][] groupImage={{R.drawable.head_5,R.drawable.head_6,R.drawable.head_7},{R.drawable.head_8,R.drawable.head_9,R.drawable.head_17},
            {R.drawable.head_18,R.drawable.head_19},{R.drawable.head_20,R.drawable.head_21},
            {R.drawable.head_22,R.drawable.head_23,R.drawable.head_3,R.drawable.head_9,}};

    String[] messageName={"小飞","迷之男神","婉儿","宋科长","暗裔剑魔","未来漫画家","恐龙克星"};
    int [] messageImage={R.drawable.head_5,R.drawable.head_22,R.drawable.head_8,R.drawable.head_18,
            R.drawable.head_21,R.drawable.head_3,R.drawable.head_23};
    String[] messageBody={"今天你是不是开车上班","大兄弟撩妹不啊!","哥在不?","你下个月工资会长点","骚年郎,打撸搞起啊!","今天出了个不错的新番","蹦瞎卡拉卡...."};

    String[] zoneName={"游戏","日迹","看点","京东购物","阅读","音乐","直播","应用宝"};
    int [] zoneIcon={R.drawable.zone1,R.drawable.zone2,R.drawable.zone3,R.drawable.zone4,
            R.drawable.zone5,R.drawable.zone6,R.drawable.zone7,R.drawable.zone8,};

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        also=(ExpandableListView)findViewById(R.id.also);
        expandableList list=new expandableList(Main.this,alsoGroup,alsoChild,alsoImage);
        also.setAdapter(list);

        group=(ExpandableListView)findViewById(R.id.group);
        expandableList expandableList=new expandableList(Main.this,groupGroup,groupChild,groupImage);
        group.setAdapter(expandableList);

        messageList=(ListView)findViewById(R.id.messageList) ;
        List<Map<String,Object>> listitem=new ArrayList<>();
        for (int i=0;i<messageName.length;i++){
            Map<String,Object > item=new HashMap<>();
            item.put("head",messageImage[i]);
            item.put("name",messageName[i]);
            item.put("body",messageBody[i]);
            listitem.add(item);
        }
        SimpleAdapter adapter=new SimpleAdapter(Main.this,listitem,R.layout.messag_list,new String[]{
                "head","name","body"},new int[]{R.id.messageIcon,R.id.messageName,R.id.messageContent});
         messageList.setAdapter(adapter);

        zoneList=(ListView)findViewById(R.id.zoneList);
        List<Map<String,Object>> myItems=new ArrayList<>();
        for (int i=0;i<zoneIcon.length;i++){
            Map<String,Object> item=new HashMap<>();
            item.put("head",zoneIcon[i]);
            item.put("name",zoneName[i]);
            item.put("image",R.drawable.zone9);
            myItems.add(item);
        }
        SimpleAdapter simpleAdapter=new SimpleAdapter(Main.this,myItems,R.layout.zone_list,new String[]{
                "head","name","image"},new int[]{R.id.zoneImage,R.id.zoneText,R.id.zoneShow
        });
        zoneList.setAdapter(simpleAdapter);

        TabHost tabHost=getTabHost();
        TabHost.TabSpec tabSpec=tabHost.newTabSpec("tab1")
                .setIndicator(getTabView("消息",R.drawable.message)).setContent(R.id.tab1);
        tabHost.addTab(tabSpec);


        TabHost.TabSpec tabSpec1=tabHost.newTabSpec("tab2").
                setIndicator(getTabView("联系人",R.drawable.friend)).setContent(R.id.tab2);
        tabHost.addTab(tabSpec1);

        TabHost.TabSpec tabSpec2=tabHost.newTabSpec("tab3").
                setIndicator(getTabView("动态",R.drawable.zorm)).setContent(R.id.tab3);
        tabHost.addTab(tabSpec2);
        tabHost.setCurrentTab(0);


    }
    public View getTabView(String text,int image){
        View view= getLayoutInflater().inflate(R.layout.showtabwight, null);
        ImageView imageView=(ImageView)view.findViewById(R.id.tabImage);
        imageView.setBackgroundResource(image);
        TextView textView=(TextView)view.findViewById(R.id.tabText);
        textView.setText(text);
        return view;
    }
}

