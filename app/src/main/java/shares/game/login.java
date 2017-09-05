package shares.game;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {

    private EditText username;
    private EditText userPasswd;
    private Button login;
    private TextView forgetPwd;
    private TextView register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        forgetPwd = (TextView)findViewById(R.id.forgetpwd);
        forgetPwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this,RetrievalPwd.class);
                startActivity(intent);
            }
        });

        register = (TextView)findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this,Register.class);
                startActivity(intent);
            }
        });
        login = (Button)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = (EditText)findViewById(R.id.username);
                userPasswd = (EditText)findViewById(R.id.userpwd);

                if(username.getText().toString().equals("1")
                        && userPasswd.getText().toString().equals("1")){
                    Toast.makeText(login.this,"登陆成功",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(login.this,OperationCore.class);
                    startActivity(intent);
                    finish();

                }else{
                    Toast.makeText(login.this,"用户名或密码错误，请重新登陆!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }


}
