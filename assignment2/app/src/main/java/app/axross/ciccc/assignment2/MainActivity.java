package app.axross.ciccc.assignment2;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    private ImageView poster;
    private TextView summary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        poster = findViewById(R.id.poster);
        summary = findViewById(R.id.summary);

        spinner.setAdapter(ArrayAdapter.createFromResource(this, R.array.movie_names, android.R.layout.simple_spinner_item));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] movieNames = getResources().getStringArray(R.array.movie_names);
                String[] movieSummaries = getResources().getStringArray(R.array.movie_summaries);
                TypedArray imageResourceIds = getResources().obtainTypedArray(R.array.movie_posters);

                poster.setImageResource(imageResourceIds.getResourceId(position, 0));
                summary.setText(movieSummaries[position]);

                Toast.makeText(getApplicationContext(), String.format("Selected: %s", movieNames[position]), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
    }
}
