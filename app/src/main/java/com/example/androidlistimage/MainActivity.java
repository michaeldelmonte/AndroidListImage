package com.example.androidlistimage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView list;

    String[] itemname = {
            "Sakata",
            "Kagura",
            "Shimura",
            "Okita",
            "Mitsuba",
            "Kondo",
            "Toshiro",
    };

    int[] imgid = {
            R.mipmap.pic1 ,
            R.mipmap.pic2,
            R.mipmap.pic3,
            R.mipmap.pic4,
            R.mipmap.pic5,
            R.mipmap.pic6,
            R.mipmap.pic7
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomListAdapter adapter = new CustomListAdapter(this, itemname, imgid);
        list = (ListView) findViewById(R.id.list);

        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem = itemname[+i];

                ListDialogFragment listDialogFragment = ListDialogFragment.newInstance(itemname, imgid, i);
                listDialogFragment.show(getFragmentManager(), "dialog");
            }
        });
    }
}
