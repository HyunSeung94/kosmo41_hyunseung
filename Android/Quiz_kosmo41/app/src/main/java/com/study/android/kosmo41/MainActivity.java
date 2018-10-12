package com.study.android.kosmo41;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] names1 = { "정석진", "윤용백", "김지훈","오연주","최송이", "정상준", "박진수","김태형","남궁윤희","조성준","노현아","한태용","이영호","조윤희","이건후","한동인","유민상","김철언","송상운","정재엽","김현승","장희성"};
    String[] ages1 = {"1963.05.09", "1984.12.28", "1987.04.19","1988.02.06","1989.09.16","1990.10.24","1990.12.27","1991.04.30","1991.08.09","1992.02.01","1992.02.03","1992.05.04","1992.05.23","1992.10.30","1993.03.07","1993.03.12","1993.08.27","1993.12.12","1994.09.11","1994.12.09","1994.12.29","1995.11.16"};
    String[] Address1 = {"인천시 부평구 삼산동","서울시 동작구 상도로","서울시 구로구 구로동","경기도 부천시 원미구 도당동","인천시 서구 경서동","서울시 구로구 개봉동","경기도 고양시 덕양구 성사동","서울시 금천구 시흥동","인천시 부평구 갈산동","서울시 금천구 가산동","서울시 동작구 상도동","경기도 부천시 여월로","서울시 관악구 서림동","서울시 동작구 장승배기로","인천시 계양구 동양동","경기도 화성시 반월동","경기도 광명시 하안동","인천시 남구 우각로","서울시 금천구 독산동","서울시 강서구 신월동","경기도 부천시 소사구 송내동","인천시 서구 석남동"};
    String[] phonenum1 = {"010-3398-8966","010-2619-4044","010-7253-0739","010-9448-8471","010-3067-5351","010-2298-8695","010-7195-6144","010-7142-3010","010-9049-7786","010-4168-0412","010-4565-5661","010-2458-0504","010-2530-8438","010-5316-8250","010-9875-0307","010-4159-1876","010-4097-1056","010-8856-6185","010-8538-5853","010-3524-2947","010-2514-8593","010-9760-2240"};
    int[] sex = {1,1,1,2,2,1,1,1,2,1,2,1,1,2,1,1,1,1,1,1,1,1};
    int[] images = {R.drawable.face1,R.drawable.face3 };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // 3단계
        final MyAdapter adapter = new MyAdapter();

        ListView listView1 = findViewById(R.id.listView1);
        listView1.setAdapter(adapter);

        // 4 단계
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                Toast.makeText(getApplicationContext(),
                        "selected : " + phonenum1[position],
                        Toast.LENGTH_SHORT).show();

            }

        });
    }

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() { return names1.length;  }

        @Override
        public Object getItem(int position){
            return  names1[position];

        }

        @Override
        public long getItemId(int position) {
            return position;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

//            TextView view1 = new TextView ( getApplicationContext());
//            view1.setText(names[position]);
//            view1.setTextSize(40.0f);
//            view1.setTextColor(Color.BLUE);
//
//            //return view1;
//
           LinearLayout layout = new LinearLayout(getApplicationContext());
           layout.setOrientation(LinearLayout.VERTICAL);
//
//            layout.addView(view1);


            if(sex[position] == 1) {
                SingerItemView view = new SingerItemView(getApplicationContext());

                view.setName(names1[position]);
                view.setAge(ages1[position]);
                view.setImage(images[0]);
                view.setAddress(Address1[position]);
                layout.addView(view);

            } else if(sex[position] == 2) {
                SingerItemView1 view2 = new SingerItemView1(getApplicationContext());
                view2.setName2(names1[position]);
                view2.setAge2(ages1[position]);
                view2.setImage2(images[1]);
                view2.setAddress2(Address1[position]);
                layout.addView(view2);
            }




            return layout;

        }

    }
}
