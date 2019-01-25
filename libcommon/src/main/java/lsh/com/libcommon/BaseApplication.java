package lsh.com.libcommon;

import android.app.Application;



import timber.log.Timber;

public class BaseApplication extends Application {
    private Application mApplication=null;
    @Override
    public void onCreate() {
        super.onCreate();
        mApplication=this;
        //....原有的Application的处理逻辑
        if (BuildConfig.DEBUG)
            Timber.plant(new Timber.DebugTree());



    }
}
