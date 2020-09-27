package com.example.opengl10_2d_conectandopuntos;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.app.Activity;
public class MainActivity extends Activity {
GLSurfaceView superficie;
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);

requestWindowFeature(Window.FEATURE_NO_TITLE);

getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
WindowManager.LayoutParams.FLAG_FULLSCREEN);

superficie = new Renderiza(this);

setContentView(superficie);
}
}