package app.axross.ciccc.implicitintentsreceiver;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_uri_message);

        Intent intent = getIntent();
        Uri uri = intent.getData();

        if (uri != null) {
            String urlString = uri.toString();

            textView.setText(urlString);
        }
    }
}

