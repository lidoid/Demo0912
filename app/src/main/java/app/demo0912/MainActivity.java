package app.demo0912;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("asdfg","asdfg");

        Log.i("asdfg","asdfg");
        Toast.makeText(this, "a", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "a", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "a", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "a", Toast.LENGTH_SHORT).show();
    }
}
