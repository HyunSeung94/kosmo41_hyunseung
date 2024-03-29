package com.study.android.memoproject;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ChatLogin extends AppCompatActivity {

    // 로그인 및 채팅 방 리스트 화면
    private FirebaseAuth mAuth;
    private ListView chat_list;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    int clickcheck =0;
    String CHAT_NAME;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatlogin);
        mAuth = FirebaseAuth.getInstance();
        chat_list = (ListView) findViewById(R.id.chat_list);



//        user_next.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //user_edit.getText().toString().equals("") ||
//                if ( user_chat.getText().toString().equals(""))
//                    return;
//
//                Intent intent = new Intent(ChatLogin.this, ChatActivity.class);
//                intent.putExtra("chatName", user_chat.getText().toString());
//                intent.putExtra("userName", mAuth.getCurrentUser().getEmail());
//                startActivity(intent);
//            }
//        });

        showChatList();



    }

    public void onBtnClicked(View v) {

        final Dialog loginDialog = new Dialog(this);
        loginDialog.setContentView(R.layout.room);
        loginDialog.setTitle("방생성");

        final EditText roomname = loginDialog.findViewById(R.id.Roomname);

        BootstrapButton button1 = loginDialog.findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (roomname.getText().toString().trim().length() > 0) {
                    Toast.makeText(getApplicationContext(), "방생성",
                            Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(ChatLogin.this, ChatActivity.class);
                    intent.putExtra("chatName", roomname.getText().toString());
                    intent.putExtra("userName", mAuth.getCurrentUser().getEmail());
                    startActivity(intent);
                    loginDialog.cancel();
                } else {
                    Toast.makeText(getApplicationContext(), "다시 입력하세요.",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
        BootstrapButton button2 = loginDialog.findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginDialog.cancel();
            }
        });
        loginDialog.show();

}

    private void showChatList() {
        // 리스트 어댑터 생성 및 세팅
        final ArrayAdapter<String> adapter

                = new ArrayAdapter<String>(this, R.layout.singer_item_view, R.id.textView1);
        chat_list.setAdapter(adapter);
        adapter.clear();
        adapter.notifyDataSetChanged();//새로고침


        //단일 클릭
        chat_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                clickcheck =0;
                Intent intent = new Intent(ChatLogin.this, ChatActivity.class);
                intent.putExtra("chatName", adapter.getItem(position));
                intent.putExtra("userName", mAuth.getCurrentUser().getEmail());
                startActivity(intent);
                //intent.putExtra("chatName", user_chat.getText().toString());
                //intent.putExtra("userName", user_edit.getText().toString());

//                Toast.makeText(getApplicationContext(),
//                        "selected : " + adapter.getItem(position)+mAuth.getCurrentUser().getEmail(),
//                        Toast.LENGTH_SHORT).show();
            }
        });

        //길게 클릭
        chat_list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(ChatLogin.this);
                CHAT_NAME = adapter.getItem(position);
                builder.setMessage(CHAT_NAME+" 방을 삭제하시겠습니까?")
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("알림")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //방삭제

                                databaseReference.child("/chat/" + CHAT_NAME).setValue(null);
                                Toast.makeText(ChatLogin.this, "방삭제", Toast.LENGTH_SHORT).show();
                                adapter.notifyDataSetChanged();//새로고침
                                dialog.cancel();
                                showChatList();
                                clickcheck ++;
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                clickcheck ++;
                            }
                        });
                android.support.v7.app.AlertDialog alert = builder.create();
                alert.show();
                clickcheck ++;
                return false;
            }
        });


        adapter.notifyDataSetChanged();//새로고침


        // 데이터 받아오기 및 어댑터 데이터 추가 및 삭제 등..리스너 관리
        databaseReference.child("chat").addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Log.e("LOG", "dataSnapshot.getKey() : " + dataSnapshot.getKey());
                adapter.notifyDataSetChanged();
                adapter.add(dataSnapshot.getKey());
                chat_list.setAdapter(adapter);

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}