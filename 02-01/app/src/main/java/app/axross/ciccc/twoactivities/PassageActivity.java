package app.axross.ciccc.twoactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PassageActivity extends AppCompatActivity {
    private TextView passageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passage);

        passageTextView = findViewById(R.id.passage);

        Intent intent = getIntent();
        int passageIndex = intent.getIntExtra(MainActivity.EXTRA_PASSAGE, 0);

        switch (passageIndex) {
            case 0:
                passageTextView.setText(R.string.passage_one);
                break;
            case 1:
                passageTextView.setText(R.string.passage_two);
                break;
            case 2:
                passageTextView.setText(R.string.passage_three);
                break;
        }
    }
}
