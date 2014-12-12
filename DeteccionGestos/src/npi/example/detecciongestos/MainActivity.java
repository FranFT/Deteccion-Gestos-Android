package npi.example.detecciongestos;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;



public class MainActivity extends Activity {

	private static final String DEBUG_TAG = "SalidaEvento";
	private static final String COORD_TAG = "Coordenadas";

	
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
		//float ejex = evento.getX(evento.getPointerId(0));
		View vista_actual = findViewById(R.id.fondo);

		switch(accion){
			case(MotionEvent.ACTION_DOWN):
				vista_actual.setBackgroundColor(getResources().getColor(R.color.encendido));
				//Log.d(DEBUG_TAG,"La accion fue DOWN");
				//Log.d(COORD_TAG, Float.toString(ejex));
				return true;
			case (MotionEvent.ACTION_MOVE) :
				vista_actual.setBackgroundColor(getResources().getColor(R.color.encendido));
	            //Log.d(DEBUG_TAG,"La accion fue MOVE");
	            return true;
			case(MotionEvent.ACTION_UP):
				vista_actual.setBackgroundColor(getResources().getColor(R.color.apagado));
				//Log.d(DEBUG_TAG,"La accion fue UP");
				//Log.d(COORD_TAG, Float.toString(ejex));
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
