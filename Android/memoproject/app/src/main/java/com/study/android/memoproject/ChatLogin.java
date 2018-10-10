package com.study.android.memoproject;

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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ChatLogin extends AppCompatActivity {

    // 로그인 및 채팅 방 리스트 화면
    private FirebaseAuth mAuth;
    private EditText user_chat, user_edit;
    private Button user_next;
    private ListView chat_list;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatlogin);
        mAuth = FirebaseAuth.getInstance();
        user_chat = (EditText) findViewById(R.id.user_chat);
       // user_edit = (EditText) findViewById(R.id.user_edit);
        user_next = (Button) findViewById(R.id.user_next);
        chat_list = (ListView) findViewById(R.id.chat_list);

        user_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //user_edit.getText().toString().equals("") ||
                if ( user_chat.getText().toString().equals(""))
                    return;

                Intent intent = new Intent(ChatLogin.this, ChatActivity.class);
               // intent.putExtra("chatName", adapter.getItem(position));
                intent.putExtra("chatName", user_chat.getText().toString());
                //intent.putExtra("userName", user_edit.getText().toString());
                intent.putExtra("userName", mAuth.getCurrentUser().getEmail());
                startActivity(intent);
            }
        });

        showChatList();

    }

    private void showChatList() {
        // 리스트 어댑터 생성 및 세팅
        final ArrayAdapter<String> adapter

                = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1);
        chat_list.setAdapter(adapter);
        adapter.notifyDataSetChanged();//새로고침
        chat_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                Intent intent = new Intent(ChatLogin.this, ChatActivity.class);
                intent.putExtra("chatName", adapter.getItem(position));
                //intent.putExtra("chatName", user_chat.getText().toString());
                //intent.putExtra("userName", user_edit.getText().toString());
                intent.putExtra("userName", mAuth.getCurrentUser().getEmail());
                startActivity(intent);

//                Toast.makeText(getApplicationContext(),
//                        "selected : " + adapter.getItem(position)+mAuth.getCurrentUser().getEmail(),
//                        Toast.LENGTH_SHORT).show();
            }
        });
        adapter.notifyDataSetChanged();//새로고침
        // 데이터 받아오기 및 어댑터 데이터 추가 및 삭제 등..리스너 관리
        databaseReference.child("chat").addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Log.e("LOG", "dataSnapshot.getKey() : " + dataSnapshot.getKey());
                adapter.add(dataSnapshot.getKey());
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}