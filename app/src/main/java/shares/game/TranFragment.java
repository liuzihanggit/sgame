package shares.game;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2017/8/19.
 */

public class TranFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle bundle){
        View view = inflater.inflate(R.layout.tranfragment,container,false);
        return view;
    }
}
