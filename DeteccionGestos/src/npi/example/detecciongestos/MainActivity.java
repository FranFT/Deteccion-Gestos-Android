package npi.example.detecciongestos;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.graphics.Color;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	
	/*
	 * Función que captura los eventos táctiles de la pantalla.
	 * @see android.app.Activity#onTouchEvent(android.view.MotionEvent)
	 */
	@Override
	public boolean onTouchEvent(MotionEvent evento)
	{
		int accion = MotionEventCompat.getActionMasked(evento);
		
		
		return true;
	}
	
}
