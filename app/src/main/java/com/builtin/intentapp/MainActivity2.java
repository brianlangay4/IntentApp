package com.builtin.intentapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity2 extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ChatAdapter chatAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        // Use the same instance of ChatManager in both activities
        chatAdapter = new ChatAdapter(ChatManager.getInstance().getChatMessages());
        recyclerView.setAdapter(chatAdapter);

        EditText replyEditText = findViewById(R.id.replyEditText);
        Button replyButton = findViewById(R.id.replyButton);

        replyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String replyMessage = replyEditText.getText().toString();

                // Add the received message to the shared list and notify the adapter
                ChatManager.getInstance().addMessage("Second", replyMessage, ChatAdapter.RECEIVED);
                chatAdapter.notifyDataSetChanged();

                // Clear the replyEditText after sending the message
                replyEditText.setText("");

                // Open MainActivity after replying
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
}
