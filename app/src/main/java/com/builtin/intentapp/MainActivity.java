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

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private EditText messageEditText;
    private ChatAdapter chatAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        messageEditText = findViewById(R.id.messageEditText);
        Button sendMessageButton = findViewById(R.id.sendMessageButton);

        // Inside MainActivity
        sendMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = messageEditText.getText().toString();

                // Add the sent message to the shared list and notify the adapter
                ChatManager.getInstance().addMessage("Main", message, ChatAdapter.SENT);
                chatAdapter.notifyDataSetChanged();

                // Create an intent to open the SecondActivity
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                // Pass the message to the second activity
                intent.putExtra("SENDER", "Second");
                intent.putExtra("MESSAGE", message);
                startActivityForResult(intent, 1);

                // Clear the messageEditText after sending the message
                messageEditText.setText("");
            }
        });



        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Use the same instance of ChatManager in both activities
        chatAdapter = new ChatAdapter(ChatManager.getInstance().getChatMessages());
        recyclerView.setAdapter(chatAdapter);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            String sender = data.getStringExtra("SENDER");
            String message = data.getStringExtra("MESSAGE");

            // Add the sent message to the shared list and notify the adapter
            chatAdapter.addMessage(sender, message, ChatAdapter.SENT);

            // Add the received message to the shared list and notify the adapter
            chatAdapter.addMessage("Receiver", message, ChatAdapter.RECEIVED);
        }
    }

}
