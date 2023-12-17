package com.builtin.intentapp;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {

    public static final int RECEIVED = 0;
    public static final int SENT = 1;

    private List<ChatMessage> chatMessages;

    public ChatAdapter(List<ChatMessage> chatMessages) {
        this.chatMessages = chatMessages;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int layoutId;
        if (viewType == RECEIVED) {
            layoutId = (parent.getContext() instanceof MainActivity2) ? R.layout.item_sms_received_main2 : R.layout.item_sms_received;
        } else {
            layoutId = (parent.getContext() instanceof MainActivity2) ? R.layout.item_sms_sent_main2 : R.layout.item_sms_sent;
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ChatMessage chatMessage = chatMessages.get(position);

        holder.senderTextView.setText(chatMessage.getSender());
        holder.messageTextView.setText(chatMessage.getMessage());

        int gravity;
        if (chatMessage.getType() == RECEIVED) {
            gravity = (holder.itemView.getContext() instanceof MainActivity2) ?  Gravity.START : Gravity.END;
        } else {
            gravity = (holder.itemView.getContext() instanceof MainActivity2) ? Gravity.END : Gravity.START;

        }

        holder.messageTextView.setGravity(gravity);
    }

    @Override
    public int getItemCount() {
        return chatMessages.size();
    }

    @Override
    public int getItemViewType(int position) {
        return chatMessages.get(position).getType();
    }

    public void addMessage(String sender, String message, int type) {
        chatMessages.add(new ChatMessage(sender, message, type));
        notifyItemInserted(chatMessages.size() - 1);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView senderTextView;
        TextView messageTextView;

        ViewHolder(View itemView) {
            super(itemView);
            senderTextView = itemView.findViewById(R.id.senderTextView);
            messageTextView = itemView.findViewById(R.id.messageTextView);
        }
    }
}
