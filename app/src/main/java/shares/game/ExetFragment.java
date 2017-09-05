package shares.game;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.xys.libzxing.zxing.encoding.EncodingUtils;

/**
 * Created by Administrator on 2017/8/19.
 */

public class ExetFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle bundle){
        View layout;
        layout = inflater.inflate(R.layout.extefragment,container,false);

        ImageView igv;
        igv = (ImageView)layout.findViewById(R.id.rQcode);
        String input="12345678900";
        //生成二维码
        Bitmap bitmap=EncodingUtils.createQRCode(input,600,600,null);
        igv.setImageBitmap(bitmap);

        return layout;
    }
}
