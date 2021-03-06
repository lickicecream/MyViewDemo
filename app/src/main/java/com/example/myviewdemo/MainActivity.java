package com.example.myviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private  MyListView myListView;

    private  MyAdapter myAdapter;

    private List<String> contentList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initList();
        myListView=(MyListView) findViewById(R.id.my_list_view);
        myListView.setOnDeleteListener(new MyListView.OnDeleteListener() {
            @Override
            public void onDelete(int mSelectedItem) {
                contentList.remove(mSelectedItem);
                myAdapter.notifyDataSetChanged();
            }
        });
        myAdapter=new MyAdapter(this,0,contentList);
        myListView.setAdapter(myAdapter);
    }

    private void initList(){
        contentList.add("Content Item 1");
        contentList.add("Content Item 2");
        contentList.add("Content Item 3");
        contentList.add("Content Item 4");
        contentList.add("Content Item 5");
        contentList.add("Content Item 6");
        contentList.add("Content Item 7");
        contentList.add("Content Item 8");
        contentList.add("Content Item 9");
        contentList.add("Content Item 10");
        contentList.add("Content Item 11");
        contentList.add("Content Item 12");
        contentList.add("Content Item 13");
        contentList.add("Content Item 14");
        contentList.add("Content Item 15");
        contentList.add("Content Item 16");
        contentList.add("Content Item 17");
        contentList.add("Content Item 18");
        contentList.add("Content Item 19");
        contentList.add("Content Item 20");

    }
}