package com.example.stpan.activity;

import android.view.MenuItem;
import com.example.stpan.activity.R;
/**
 * Created by Administrator on 2015/4/13.
 */
public class BackActivity extends BaseActivity {

    @Override
    protected void initToolbar() {
        super.initToolbar();
        if (toolbar!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setNavigationIcon(R.mipmap.ic_arrow_back_black_18dp);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home){
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
