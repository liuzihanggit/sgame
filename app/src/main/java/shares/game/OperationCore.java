package shares.game;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContentResolverCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/8/18.
 */

public class OperationCore extends AppCompatActivity {

    private TextView transaction;
    private TextView extension;
    private TextView rule;
    private TextView mycenter;

    private Fragment tranFragment;
    private Fragment exteFragment;
    private Fragment ruleFragment;
    private Fragment myctFragment;

    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.operation_core);

        initView();
        initListener();
        changeFragment(1); //初始化默认显示第一个fragment
        clearTabState();
        setTransChooseState();
    }

    private void initView(){
        transaction = (TextView)findViewById(R.id.transaction_bar);
        extension = (TextView)findViewById(R.id.extension_bar);
        rule = (TextView)findViewById(R.id.rule_bar);
        mycenter = (TextView)findViewById(R.id.mycenter_bar);
    }

    private void initListener(){
        //单击交易选项
        transaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(1);
                clearTabState();
                setTransChooseState();
            }
        });
        //单击推广选项
        extension.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(2);
                clearTabState();
                setExtensionChooseState();
            }
        });
        //单击规则选项
        rule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(3);
                clearTabState();
                setRuleChooseState();
            }
        });
        //单击我的选项
        mycenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(4);
                clearTabState();
                setMycenterChooseState();
            }
        });
    }

    private void changeFragment(int position){

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        tranFragment = fm.findFragmentByTag(TranFragment.class.getSimpleName());
        exteFragment = fm.findFragmentByTag(ExetFragment.class.getSimpleName());
        ruleFragment = fm.findFragmentByTag(RuleFragment.class.getSimpleName());
        myctFragment = fm.findFragmentByTag(MyctFragment.class.getSimpleName());
        hideAllFragemnt();
        switch (position){
            case 1:
                if(tranFragment == null){
                    tranFragment = new TranFragment();
                    ft.add(R.id.fragment_container,tranFragment,TranFragment.class.getSimpleName());
                }
                ft.show(tranFragment);
                break;
            case 2:
                if(exteFragment == null){
                    exteFragment = new ExetFragment();
                    ft.add(R.id.fragment_container,exteFragment,ExetFragment.class.getSimpleName());
                }
                ft.show(exteFragment);
                break;
            case 3:
                if(ruleFragment == null){
                    ruleFragment = new RuleFragment();
                    ft.add(R.id.fragment_container,ruleFragment,RuleFragment.class.getSimpleName());
                }
                ft.show(ruleFragment);
                break;
            case 4:
                if(myctFragment == null){
                    myctFragment = new MyctFragment();
                    ft.add(R.id.fragment_container,myctFragment,MyctFragment.class.getSimpleName());
                }
                ft.show(myctFragment);
                break;
            default: break;
        }
        ft.commit();
    }
    //隐藏所有的选项
    private void hideAllFragemnt(){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        if(tranFragment != null){
            ft.hide(tranFragment);
        }
        if(exteFragment != null){
            ft.hide(exteFragment);
        }
        if(ruleFragment != null){
            ft.hide(ruleFragment);
        }
        if(myctFragment != null){
            ft.hide(myctFragment);
        }

        ft.commit();
    }
    //清除下部选项栏的状态
    private void clearTabState(){
        //把交易选项变为未被选中的黑色
        Drawable tranDraw = ContextCompat.getDrawable(getApplicationContext(),R.mipmap.home);
        tranDraw.setBounds(0,0,tranDraw.getMinimumWidth(),tranDraw.getMinimumHeight());
        transaction.setCompoundDrawables(null,tranDraw,null,null);
        transaction.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.black));

        Drawable exteDraw = ContextCompat.getDrawable(getApplicationContext(),R.mipmap.exten);
        exteDraw.setBounds(0,0,exteDraw.getMinimumWidth(),exteDraw.getMinimumHeight());
        extension.setCompoundDrawables(null,exteDraw,null,null);
        extension.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.black));

        Drawable ruleDraw = ContextCompat.getDrawable(getApplicationContext(),R.mipmap.rule);
        ruleDraw.setBounds(0,0,ruleDraw.getMinimumWidth(),ruleDraw.getMinimumHeight());
        rule.setCompoundDrawables(null,ruleDraw,null,null);
        rule.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.black));

        Drawable myctDraw = ContextCompat.getDrawable(getApplicationContext(),R.mipmap.me);
        myctDraw.setBounds(0,0,myctDraw.getMinimumWidth(),myctDraw.getMinimumHeight());
        mycenter.setCompoundDrawables(null,myctDraw,null,null);
        mycenter.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.black));


    }
    //设置底部选项栏的选中状态
    private void setTransChooseState(){

        Drawable tranDraw = ContextCompat.getDrawable(getApplicationContext(),R.mipmap.home1);
        tranDraw.setBounds(0,0,tranDraw.getMinimumWidth(),tranDraw.getMinimumHeight());
        transaction.setCompoundDrawables(null,tranDraw,null,null);
        transaction.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.selected));
    }
    private void setExtensionChooseState(){

        Drawable exteDraw = ContextCompat.getDrawable(getApplicationContext(),R.mipmap.exten1);
        exteDraw.setBounds(0,0,exteDraw.getMinimumWidth(),exteDraw.getMinimumHeight());
        extension.setCompoundDrawables(null,exteDraw,null,null);
        extension.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.selected));
    }
    private void setRuleChooseState(){

        Drawable ruleDraw = ContextCompat.getDrawable(getApplicationContext(),R.mipmap.me1);
        ruleDraw.setBounds(0,0,ruleDraw.getMinimumWidth(),ruleDraw.getMinimumHeight());
        rule.setCompoundDrawables(null,ruleDraw,null,null);
        rule.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.selected));
    }
    private void setMycenterChooseState(){

        Drawable myctDraw = ContextCompat.getDrawable(getApplicationContext(),R.mipmap.me1);
        myctDraw.setBounds(0,0,myctDraw.getMinimumWidth(),myctDraw.getMinimumHeight());
        mycenter.setCompoundDrawables(null,myctDraw,null,null);
        mycenter.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.selected));
    }




}
