package test.kosta.android34camera;

import android.hardware.Camera;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import java.io.IOException;

/**
 * Created by qkboo on 2016-06-10.
 */
public class TestCameraView extends SurfaceView
            implements SurfaceHolder.Callback, Camera.PictureCallback {

    private SurfaceHolder mSurfaceHolder;
    private Camera mCamera;

    public TestCameraView(MainActivity mainActivity) {
        super(mainActivity);

        mSurfaceHolder = getHolder();
        mSurfaceHolder.addCallback(this);
        mSurfaceHolder.setType(
                SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Log.i("testLog","surfaceCreated");
        mCamera = Camera.open();
        try {
            mCamera.setPreviewDisplay(mSurfaceHolder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        mCamera.startPreview();
        Log.i("testLog","surfaceChanged");
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        mCamera.setPreviewCallback(null);
        mCamera.stopPreview();
        mCamera.release();
        mCamera = null;
        Log.i("testLog","surfaceDestroyed");
    }

    @Override
    public void onPictureTaken(byte[] data, Camera camera) {
        Log.i("testLog","onPictureTaken");
    }
}
