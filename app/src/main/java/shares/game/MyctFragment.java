package shares.game;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/8/19.
 */

public class MyctFragment extends Fragment {

    private TextView weeklyPay;
    private TextView myorder;
    private TextView myassets;

    private Fragment myorderFragment;
    private Fragment myassetsFragment;
    private Fragment myweeklyFragemnt;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle bundle){
        View layout = inflater.inflate(R.layout.myctfragment,container,false);
        initView(layout);
        weeklyPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyctFragment.this.getActivity(),MyweeklyPay.class);
                startActivity(intent);

                /*
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();

                myweeklyFragemnt = fm.findFragmentByTag(MyweeklyPay.class.getSimpleName());

                if(myweeklyFragemnt == null){
                    myweeklyFragemnt = new Fragment();
                    ft.add(R.id.fragment_container,myweeklyFragemnt);
                }else{
                    ft.show(myweeklyFragemnt);
                }
                ft.commit();
                */
            }
        });

        myorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MyctFragment.this.getActivity(),MyOrder.class);
                startActivity(intent);
            }
        });
        myassets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyctFragment.this.getActivity(),MyAssets.class);
                startActivity(intent);
            }
        });
        return layout;
    }
    //获取页面内部的组件信息
    public void initView(View layout){
        weeklyPay = (TextView)layout.findViewById(R.id.my_weekly_pay);
        myorder = (TextView)layout.findViewById(R.id.my_order);
        myassets = (TextView)layout.findViewById(R.id.my_assets);
    }


}
