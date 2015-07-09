package com.example.pasquierase;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ResultatActivity extends Activity{
	TextView texteVousAvezEu, textePoints;
	Button btnNewPartie, btnQuitter;
	
	
	//appele lorsque l'activit� est cr��e
			@Override
			protected void onCreate(Bundle savedInstanceState) {
				super.onCreate(savedInstanceState);
				//le code se met ici
				setContentView(R.layout.resultat);
				
				int points = 0;
				points = getIntent().getIntExtra("POINTS", points);
				texteVousAvezEu = (TextView)findViewById(R.id.texteVousAvezEu);
				textePoints = (TextView)findViewById(R.id.textePoints);
				btnNewPartie = (Button)findViewById(R.id.btnNewPartie);
				btnQuitter = (Button)findViewById(R.id.btnQuitter);
				
				textePoints.setText(""+points+"/20");
				textePoints.setTextColor(Color.RED);
				
				//on clique sur le bouton Nouvelle Partie
				btnNewPartie.setOnClickListener( new OnClickListener() {
		             public void onClick( View view ) { 
		            	 setResult(4);
		            	 finish();
		            }
		        });
				
				btnQuitter.setOnClickListener( new OnClickListener() {
		             public void onClick( View view ) { 
		            	 //Intent i=new Intent(ResultatActivity.this, MainActivity.class);
		            	 //startActivity(i);
		            	 setResult(3);
		            	 finish();
		            }
		        });
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
