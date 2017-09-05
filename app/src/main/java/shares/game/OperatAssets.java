package shares.game;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/8/24.
 */

public class OperatAssets extends AppCompatActivity {

    private TextView tv_rechange;
    private TextView tv_withdrawals;
    private TextView tv_searRechange;
    private TextView tv_searWithdrawals;

    private Fragment rech_fragment;
    private Fragment widr_fragment;
    private Fragment searrech_fragment;
    private Fragment searwidr_fragment;

    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.operatassets);
        initView();
        //Toast.makeText(OperatAssets.this,"测试用例!",Toast.LENGTH_LONG).show();
        selectFragment(1);
    }
    private void initView(){
        tv_rechange = (TextView)findViewById(R.id.tab_rechange);
        tv_withdrawals = (TextView)findViewById(R.id.tab_withdrawals);
        tv_searRechange = (TextView)findViewById(R.id.tabsear_rechange);
        tv_searWithdrawals = (TextView)findViewById(R.id.tabsear_withdrawals);

        tv_rechange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectFragment(1);
            }
        });
        tv_withdrawals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectFragment(2);
            }
        });
        tv_searRechange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectFragment(3);
            }
        });
        tv_searWithdrawals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectFragment(4);
            }
        });
    }

    private void selectFragment(int sign){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft= fm.beginTransaction();

        rech_fragment =fm.findFragmentByTag(Rechange.class.getSimpleName());
        widr_fragment = fm.findFragmentByTag(WithDrawals.class.getSimpleName());
        searrech_fragment = fm.findFragmentByTag(SearchRechange.class.getSimpleName());
        searwidr_fragment = fm.findFragmentByTag(SearchWithDrawlas.class.getSimpleName());

        hideFragment();
        switch (sign){
            case 1:
                if(rech_fragment == null){
                    rech_fragment = new Rechange();
                    ft.add(R.id.contain_fragment,rech_fragment,Rechange.class.getSimpleName());
                }
                ft.show(rech_fragment);
                break;
            case 2:
                if(widr_fragment == null){
                    widr_fragment = new WithDrawals();
                    ft.add(R.id.contain_fragment,widr_fragment,WithDrawals.class.getSimpleName());
                }
                ft.show(widr_fragment);
                break;
            case 3:
                if(searrech_fragment == null){
                    searrech_fragment = new SearchRechange();
                    ft.add(R.id.contain_fragment,searrech_fragment,SearchRechange.class.getSimpleName());
                }
                ft.show(searrech_fragment);
                break;
            case 4:
                if(searwidr_fragment == null){
                    searwidr_fragment = new SearchWithDrawlas();
                    ft.add(R.id.contain_fragment,searwidr_fragment,SearchWithDrawlas.class.getSimpleName());
                }
                ft.show(searwidr_fragment);
                break;
            default: break;
        }
        ft.commit();
    }
    private void hideFragment(){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if (rech_fragment != null){
            ft.hide(rech_fragment);
        }
        if(widr_fragment != null){
            ft.hide(widr_fragment);
        }
        if(searrech_fragment != null){
            ft.hide(searrech_fragment);
        }
        if(searwidr_fragment != null){
            ft.hide(searwidr_fragment);
        }
        ft.commit();
    }



}
