package edu.upenn.cis350.androidapp;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.upenn.cis350.androidapp.DataInteraction.Data.Chat;
import edu.upenn.cis350.androidapp.DataInteraction.Data.Message;
import edu.upenn.cis350.androidapp.DataInteraction.Management.MessageManagement.ChatJSONWriter;
import edu.upenn.cis350.androidapp.DataInteraction.Processing.MessageProcessing.ChatProcessor;
import edu.upenn.cis350.androidapp.DataInteraction.Processing.MessageProcessing.MessageProcessor;

public class FoundItem2Activity extends AppCompatActivity {

    private String itemCat;
    private String postDate;
    private long posterId;
    private long itemId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_found_item2);
        itemCat = getIntent().getStringExtra("item");
        postDate = getIntent().getStringExtra("postDate");
        posterId = getIntent().getLongExtra("posterId", -1);
        itemId = getIntent().getLongExtra("itemId", -1);
        TextView foundItemCategory = findViewById(R.id.foundItemCategory);
        foundItemCategory.setText(getIntent().getStringExtra("category"));
        TextView foundItemTime = findViewById(R.id.foundItemTime);
        foundItemTime.setText(getIntent().getStringExtra("time"));
        TextView foundItemAround = findViewById(R.id.foundItemAround);
        foundItemAround.setText(getIntent().getStringExtra("location"));
    }

    public void onSendMessage(View view) {
        long userId = MainActivity.userId;
        ChatProcessor cp = ChatProcessor.getInstance();
        long chatId = cp.findNewId();
        MessageProcessor mp = MessageProcessor.getInstance();
        long messageId = mp.findNewId();
        List<Long> messages = new ArrayList<Long>();
        messages.add(messageId);
        Chat chat = new Chat(chatId, userId, posterId, itemCat, messages,
                new Date(), itemId);
        cp.registerChat(chat);
        EditText foundItemText = findViewById(R.id.foundItemText);
        String text = "Hello, I would like to claim the " + itemCat + " that you posted on " + postDate +
                "\n" + ". Here's some verification details that I remember: " + foundItemText.getText().toString();
        Message message = new Message(messageId, userId, posterId, new Date(), text, chatId);
        mp.registerMessage(message);
        Toast.makeText(getApplicationContext(),
                "Successfully messaged user!", Toast.LENGTH_LONG).show();
        finish();
        }

}
