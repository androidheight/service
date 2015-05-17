package program.androidheight.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

/**
 * Created by PRABHU on 17-05-2015.
 */
public class MyBoundedService extends Service {
    MediaPlayer player;
    public MyBoundedService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        player=MediaPlayer.create(MyBoundedService.this, R.raw.song);
        Toast.makeText(MyBoundedService.this, "Service Created!", Toast.LENGTH_LONG).show();
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(MyBoundedService.this, "Service Started!", Toast.LENGTH_LONG).show();
        player.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        player.release();
        Toast.makeText(MyBoundedService.this, "Service Destroyed!", Toast.LENGTH_LONG).show();
    }
}