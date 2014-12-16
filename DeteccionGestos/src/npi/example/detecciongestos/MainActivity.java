package npi.example.detecciongestos;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;



public class MainActivity extends Activity {

	//Etiquetas para la salida de datos.
	private static final String DEBUG_TAG = "SalidaEvento";
	private static final String COORD_TAG = "Coordenadas";
	
	//Variables necesarias para comprobar gestos.
	float x_inicial, y_inicial, x_actual, y_final;
	boolean correcto = true;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//ImageView apagado = (ImageView) findViewById(R.id.off);
		//ImageView encendido = (ImageView) findViewById(R.id.on);

	}
	
	
	/*
	 * Función que captura los eventos táctiles de la pantalla.
	 * @see android.app.Activity#onTouchEvent(android.view.MotionEvent)
	 */
	@Override
	public boolean onTouchEvent(MotionEvent evento)
	{
		// Obtengo la acción que se ha detectado en la pantalla.
		int accion = MotionEventCompat.getActionMasked(evento);
		
		// Referencio el fondo de la aplicación en un objeto tipo View.
		View vista_actual = findViewById(R.id.fondo);

		// Según la acción que se ha detectado en la pantalla...
		switch(accion){
			// Si se acaba de pulsar la pantalla...
			case(MotionEvent.ACTION_DOWN):
				// Obtengo las coordenadas X,Y donde se produjo la pulsación.
				x_inicial = evento.getX(evento.getPointerId(0));
				y_inicial = evento.getY(evento.getPointerId(0));
				// Suponemos que el movimiento es correcto.
				correcto = true;
				
				// Salidas por pantalla.
				Log.d(DEBUG_TAG,"Se ha pulsado la pantalla");
				Log.d(COORD_TAG, Float.toString(x_inicial));
				Log.d(COORD_TAG, Float.toString(y_inicial));
				
			// Si el dedo se está moviendo por la pantalla...
			case (MotionEvent.ACTION_MOVE) :
				// Obtengo la X actual del dedo.
				x_actual = evento.getX(evento.getPointerId(0));
				// Me aseguro de que se hace una linea recta con el dedo dentro
				// de un margen de error. En caso de que sobrepase el margen
				// el gesto se marcará como inválido hasta que se vuelva a pulsar
				// la pantalla para iniciar un nuevo gesto.
				if(x_actual>=x_inicial+50 || x_actual <= x_inicial-50)
					correcto = false;
				
				// Salidas por pantalla.
				if(correcto)
					Log.d(DEBUG_TAG,"Correcto.");
				else
					Log.d(DEBUG_TAG,"No-Correcto.");
				
			// Si la acción detectada es que se ha dejado de tocar la pantalla...
			case(MotionEvent.ACTION_UP):
				// Salida por pantalla
				Log.d(DEBUG_TAG,"Se ha dejado de pulsar la pantalla");

				// Si el movimiento ha sido correcto...
				if(correcto){
					// Obtengo la coordenada Y final del gesto.
					y_final = evento.getY(evento.getPointerId(0));
					
					// Me aseguro de que la linea recta ha sido lo suficientemente larga.
					// Dependiendo de la dirección, se visualizará la acción de encender
					// o apagar la luz.
					if(y_final >= y_inicial+200){
						vista_actual.setBackgroundColor(getResources().getColor(R.color.encendido));
						ImageView interruptor = (ImageView) findViewById(R.id.interruptor);
						interruptor.setImageResource(R.drawable.on);
					}
				
					if(y_final <= y_inicial-200){
						vista_actual.setBackgroundColor(getResources().getColor(R.color.apagado));
						ImageView interruptor = (ImageView) findViewById(R.id.interruptor);
						interruptor.setImageResource(R.drawable.off);
					}
				}
		}

		return true;
	}
	
}
