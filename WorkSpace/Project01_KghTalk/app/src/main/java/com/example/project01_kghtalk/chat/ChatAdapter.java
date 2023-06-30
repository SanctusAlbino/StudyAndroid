package com.example.project01_kghtalk.chat;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project01_kghtalk.databinding.ItemChatRecvBinding;
import com.example.project01_kghtalk.databinding.ItemFriendRecvBinding;
import com.example.project01_kghtalk.friend.FriendAdapter;

import java.util.ArrayList;


public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {

    ItemChatRecvBinding binding;

    ArrayList<ChatDTO> list ;

    public ChatAdapter(ArrayList<ChatDTO> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemChatRecvBinding.inflate(inflater, parent, false);
        return new ChatAdapter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.chatProfile.setImageResource(list.get(position).getChatImgId());
        holder.binding.chatName.setText(list.get(position).getChat_name());
        holder.binding.chatMsg.setText(list.get(position).getChat_msg());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ItemChatRecvBinding binding;

        public ViewHolder(@NonNull ItemChatRecvBinding binding) {
            super(binding.getRoot());
            this.binding =binding;
        }
    }
}
