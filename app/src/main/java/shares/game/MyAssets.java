package shares.game;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/8/20.
 */

public class MyAssets extends AppCompatActivity {

    TextView rechange;
    TextView withdrawals;
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.myassets);

        rechange = (TextView)findViewById(R.id.my_recharge);
        withdrawals = (TextView)findViewById(R.id.my_withdrawals);

        rechange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent recIntent = new Intent(MyAssets.this,OperatAssets.class);
                startActivity(recIntent);
            }
        });

        withdrawals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent witIntent = new Intent(MyAssets.this,OperatAssets.class);
                startActivity(witIntent);
            }
        });
    }
}
