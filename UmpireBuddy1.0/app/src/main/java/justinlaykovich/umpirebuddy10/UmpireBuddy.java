package justinlaykovich.umpirebuddy10;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UmpireBuddy extends AppCompatActivity {
    AlertDialog.Builder alert_dialog;
    Button strike_button;
    Button ball_button;
    TextView strike_count;
    TextView ball_count;
    int strike;
    int ball;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_umpire_buddy);

        strike_button = (Button)findViewById(R.id.strike_button);
        ball_button = (Button)findViewById(R.id.ball_button);
        strike_count = (TextView)findViewById(R.id.strike_count);
        ball_count = (TextView)findViewById(R.id.ball_count);

        strike = 0;
        ball = 0;

        alert_dialog = new AlertDialog.Builder(UmpireBuddy.this).setPositiveButton("OK", new AlertDialog.OnClickListener(){
            public void onClick(DialogInterface D, int I) {
                strike = 0;
                ball = 0;
                ball_count.setText(String.format("%d",ball));
                strike_count.setText(String.format("%d",strike));
            }
        });

        strike_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                strike += 1;
                if(strike == 3) {
                    alert_dialog.setMessage("OUT!");
                    alert_dialog.show();
                }
                else
                    strike_count.setText(String.format("%d",strike));
            }
        });

        ball_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ball += 1;
                if(ball == 4) {
                    alert_dialog.setMessage("WALK!");
                    alert_dialog.show();
                }
                else
                    ball_count.setText(String.format("%d",ball));
            }
        });
    }
}
