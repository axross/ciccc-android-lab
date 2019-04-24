package app.axross.ciccc.lab1_renamed;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int count = 0;

    private TextView countTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countTextView = findViewById(R.id.show_count);
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT);

        toast.show();
    }

    public void countUp(View view) {
        count += 1;

        countTextView.setText(Integer.toString(count));
    }

    public void setZero(View view) {
        count = 0;

        countTextView.setText(Integer.toString(count));
    }
}
