package com.example.project01_kghtalk;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.project01_kghtalk.Opentalk.OpenTalkMainFragment;
import com.example.project01_kghtalk.chat.ChatFragment;
import com.example.project01_kghtalk.databinding.ActivityMainBinding;
import com.example.project01_kghtalk.friend.FriendFragment;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ActionBar actionBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        actionBar = getSupportActionBar();
        actionBar.setElevation(0f);
        actionBar.setTitle("친구");

        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.container, new FriendFragment()).commit();

        binding.bottomNavigation.setOnItemSelectedListener(item -> {
            Fragment fragment = null;

            if(item.getItemId()==R.id.tab_1){
                fragment = new FriendFragment();
                actionBar.setTitle("친구");
            }else if(item.getItemId()==R.id.tab_2){
                actionBar.setTitle("채팅");
                //package chat추가 후 ChatFragment 추가, ChatFragment에 리사이클러뷰를 이용하여 카카오톡의 채팅목록을 구현하기.
                fragment = new ChatFragment();
            }else if(item.getItemId()==R.id.tab_3){
                actionBar.setTitle("오픈채팅");
                fragment = new OpenTalkMainFragment();
            }else if(item.getItemId()==R.id.tab_4){
                actionBar.setTitle("쇼핑");
            }else if(item.getItemId()==R.id.tab_5){
                actionBar.setTitle("더보기");
            }else {
                return false;//메뉴가 바뀐는 처리를 취하한다. (들어올 가능성 없음)
            }
            if(fragment==null){
                Toast.makeText(this, "아직 메뉴가 준비가 안되었습니다.", Toast.LENGTH_SHORT).show();
            }else{
                manager.beginTransaction().replace(R.id.container, fragment).commit();
            }

            return true;
        });//람다식의 메소드가 이해가 안간다면 new 를 통해서 interface구조를 먼저 확인해볼것






    }


//    public void changeFrag(Fragment fragment){
//        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
//    }
}