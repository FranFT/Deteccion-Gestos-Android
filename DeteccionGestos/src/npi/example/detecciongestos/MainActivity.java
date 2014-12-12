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
	float x_inicial, y_inicial, x_actual, y_final;
	boolean correcto = true;

	
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
				x_inicial = evento.getX(evento.getPointerId(0));
				y_inicial = evento.getY(evento.getPointerId(0));
				correcto = true;
				//vista_actual.setBackgroundColor(getResources().getColor(R.color.encendido));
				//Log.d(DEBUG_TAG,"La accion fue DOWN");
				//Log.d(COORD_TAG, Float.toString(ejex));
			case (MotionEvent.ACTION_MOVE) :
				x_actual = evento.getX(evento.getPointerId(0));
				if(x_actual>=x_inicial+50 || x_actual <= x_inicial-50)
					correcto = false;
				
				if(correcto)
					Log.d(DEBUG_TAG,"Correcto.");
				else
					Log.d(DEBUG_TAG,"No-Correcto.");
				//vista_actual.setBackgroundColor(getResources().getColor(R.color.encendido));
	            //Log.d(DEBUG_TAG,"La accion fue MOVE");
			case(MotionEvent.ACTION_UP):
				
				if(correcto){
					
					y_final = evento.getY(evento.getPointerId(0));

					if(y_final >= y_inicial+200)
						vista_actual.setBackgroundColor(getResources().getColor(R.color.encendido));
				
					if(y_final <= y_inicial-200)
						vista_actual.setBackgroundColor(getResources().getColor(R.color.apagado));
				}
				
				//Log.d(DEBUG_TAG,"La accion fue UP");
				//Log.d(COORD_TAG, Float.toString(ejex));
		}

		return true;
	}
	
}
