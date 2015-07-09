package com.example.pasquierase;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AproposActivity extends Activity{
	
	//appele lorsque l'activit� est cr��e
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			//le code se met ici
			setContentView(R.layout.apropos);
		}
			
		//lorsque l'activit� a termine son cycle de vie
		//on fait les nettoyage et les vidange (de la memoire utilis�)
		@Override
		protected void onDestroy() {
			//le code se met ici avant destroy()
			super.onDestroy();
		}
		
		//lorsque l'activit� d�marre
		@Override
		protected void onStart() {
			super.onStart();
			//le code se met ici apres start()
		}
		
		//lorsque l'activit� passe en arri�re Plan
			@Override
			protected void onStop() {
				//le code se met ici avant onStop()
				super.onStop();
			}
			
		//lorsque l'activit� revient de la veille
			@Override
			protected void onRestart() {
				super.onRestart();
				//le code se met ici
			}
			
		//lorsque l'activit� va en pause
			@Override
			protected void onPause(){
				//le code ici
				super.onPause();
			}
			
		//lorsque l'activit� revient de la pause
			@Override
			protected void onResume(){
				super.onResume();
				//le code ici
			}
			
		//sauvegarder les donn�e importantes
			@Override
			protected void onSaveInstanceState(Bundle savedInstanceState){
				//le code ici
				super.onSaveInstanceState(savedInstanceState);
			}
			
		//apres onCreate on recharge les donn�es
			@Override
			protected void onRestoreInstanceState(Bundle savedInstanceState){
				super.onRestoreInstanceState(savedInstanceState);
				//le code ici
			}
	
}
