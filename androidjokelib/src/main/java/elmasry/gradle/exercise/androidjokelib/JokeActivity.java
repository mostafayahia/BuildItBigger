package elmasry.gradle.exercise.androidjokelib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class JokeActivity extends AppCompatActivity {

    public static final String EXTRA_JOKE = "elmasry.gradle.exercise.androidjokelib.extras.JOKE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        Bundle extras = getIntent().getExtras();

        if (extras != null && extras.getString(EXTRA_JOKE) != null) {
            // retrieving the joke from the intent extra then display it
            TextView jokeTv = findViewById(R.id.joke_text_view);
            jokeTv.setText(extras.getString(EXTRA_JOKE));
        } else {
            Toast.makeText(this, R.string.error_in_getting_data, Toast.LENGTH_LONG).show();
        }
    }
}
