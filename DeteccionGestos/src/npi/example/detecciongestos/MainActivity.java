package npi.example.detecciongestos;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends Activity {

	private static final String DEBUG_TAG = "SalidaEvento";
	
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
		
		switch(accion){
			case(MotionEvent.ACTION_DOWN):
				Log.d(DEBUG_TAG,"La accion fue DOWN");
				return true;
			case (MotionEvent.ACTION_MOVE) :
	            Log.d(DEBUG_TAG,"La accion fue MOVE");
	            return true;
			case(MotionEvent.ACTION_UP):
				Log.d(DEBUG_TAG,"La accion fue UP");
				return true;
		}
		/*if(evento.getAction() == MotionEvent.ACTION_DOWN)
		{
			View capa = findViewById(R.id.fondo);
			capa.setBackgroundResource(getResources().getColor(R.color.encencido));
		}*/
			
		return true;
	}
	
}
