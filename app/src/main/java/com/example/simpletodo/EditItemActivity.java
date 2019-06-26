package com.example.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EditItemActivity extends AppCompatActivity {

    EditText etItemText;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        // resolve the text field from the layout
        etItemText = (EditText) findViewById(R.id.etItemText);
        // set the text field's content from the intent
        etItemText.setText(getIntent().getStringExtra(MainActivity.ITEM_TEXT));
        // track the position of the item in the list
        position = getIntent().getIntExtra(MainActivity.ITEM_POSITION, 0);
        // set the title bar to reflect the purpose of the view
        getSupportActionBar().setTitle("Edit Item");
    }

    public void onSaveItem(View v) {
        Intent data = new Intent();
        data.putExtra(MainActivity.ITEM_TEXT, etItemText.getText().toString());
        data.putExtra(MainActivity.ITEM_POSITION, position);
        setResult(RESULT_OK, data);
        finish();
    }
}
