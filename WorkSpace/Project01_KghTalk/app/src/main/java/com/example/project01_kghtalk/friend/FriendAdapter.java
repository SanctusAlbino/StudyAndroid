package com.example.project01_kghtalk.friend;

import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project01_kghtalk.MainActivity;
import com.example.project01_kghtalk.databinding.ItemFriendRecvBinding;

import java.util.ArrayList;

//2.만들어둔 뷰홀더 이용해서 어댑터 상속받기
public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.ViewHolder> {

    ItemFriendRecvBinding binding;

    ArrayList<FriendDTO> list;

    Context context;


    public FriendAdapter(ArrayList<FriendDTO> list, Context context) {
        this.list =list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemFriendRecvBinding.inflate(inflater, parent, false);
        return new ViewHolder(binding);
    }

    //리사이클러뷰의 칸마다의 데이터연결이나 이벤트 연결을 하는 메소드.
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        holder.binding.imgvProfile.setImageResource(list.get(i).getResImgId());
        holder.binding.tvName.setText(list.get(i).getName());

        holder.binding.lnFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent( context, FriendDetailActivity.class);
                intent.putExtra("dto", list.get(i));
                //web (customer List하면 아이템 하나 클릭=>???) : get방식으로 id값을 controller에 전달 -> id를 통해서 데이터 한건 조회 -> vo

                //인텐트 객체를 통해서 선택 된 아이템을 => FriendDetailActivity로 전송

                context.startActivity(intent);
            }
        });

        String[] dialogItem = {"즐겨찾기에 추가", "이름변경", "숨김", "차단"};
        holder.binding.lnFriend.setOnLongClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle(list.get(i).getName()); //제목부분
            builder.setItems(dialogItem, ((dialog, idx) -> {
                if(dialogItem[idx].equals("차단")){
                    list.remove(i);
                    notifyDataSetChanged();//adapter에 있는 메소드 notifyDataSetChanged(); <=내부에 있는 리스트가 바뀌었다는것을 어댑터에 전달하고 어댑터는 내용을 다시 그린다.
                    dialog.dismiss(); //다이얼로그를 안보이게 처리
                }
            }));
            builder.create().show();

            return true;
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    //1. 웨젯들을 묶어서 저장해놓을 객체 ViewHolder
    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemFriendRecvBinding binding;
        public ViewHolder(@NonNull ItemFriendRecvBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
