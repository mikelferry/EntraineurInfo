package com.example.pasquierase;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{

	/*le cycle de vie d'une activité est donné par les étatpes onCreate, onDestroy
	onResume, OnPause... alors la bonne façon est de resortir toutes ces méthodes
	avant de commencer le codage*/
	
	
	//appele lorsque l'activité est créée
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//le code se met ici
		setContentView(R.layout.accueil);
		
		
		Button btnNewPartie, btnAide, btnApropos, btnQuit;
		
		btnNewPartie = (Button)findViewById(R.id.btnNewPartie);
		btnAide = (Button)findViewById(R.id.btnAide);
		btnApropos = (Button)findViewById(R.id.btnApropos);
		btnQuit = (Button)findViewById(R.id.btnQuit);
		
		//on plante les écouteurs
		btnNewPartie.setOnClickListener(this);
		btnAide.setOnClickListener(this);
		btnApropos.setOnClickListener(this);
		btnQuit.setOnClickListener(this);
	}
	
	//lorsque l'activité a termine son cycle de vie
	//on fait les nettoyage et les vidange (de la memoire utilisé)
	@Override
	protected void onDestroy() {
		//le code se met ici avant destroy()
		super.onDestroy();
	}
	
	//lorsque l'activité démarre
	@Override
	protected void onStart() {
		super.onStart();
		//le code se met ici apres start()
	}
	
	//lorsque l'activité passe en arrière Plan
		@Override
		protected void onStop() {
			//le code se met ici avant onStop()
			super.onStop();
		}
		
	//lorsque l'activité revient de la veille
		@Override
		protected void onRestart() {
			super.onRestart();
			//le code se met ici
		}
		
	//lorsque l'activité va en pause
		@Override
		protected void onPause(){
			//le code ici
			super.onPause();
		}
		
	//lorsque l'activité revient de la pause
		@Override
		protected void onResume(){
			super.onResume();
			//le code ici
		}
		
	//sauvegarder les donnée importantes
		@Override
		protected void onSaveInstanceState(Bundle savedInstanceState){
			//le code ici
			super.onSaveInstanceState(savedInstanceState);
		}
		
	//apres onCreate on recharge les données
		@Override
		protected void onRestoreInstanceState(Bundle savedInstanceState){
			super.onRestoreInstanceState(savedInstanceState);
			//le code ici
		}

		//on désigne les actions a accomplir lorsqu'on clic sur un bouton
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			switch(arg0.getId()){
			
				case R.id.btnNewPartie:{
					Toast.makeText(MainActivity.this, "CHOISIR VOTRE CLASS", Toast.LENGTH_LONG).show();
					Intent intent = new Intent(MainActivity.this, ChoixNivActivity.class);
					//intent.putExtra(EXTRA_LOGIN, login.getText().toString());
				    //intent.putExtra(EXTRA_PASSWORD, pass.getText().toString());
					startActivityForResult(intent,0);
				}
				break;
				
				case R.id.btnAide:{
					
				}
				break;
				
				case R.id.btnApropos:{
					
				}
				break;
				
				case R.id.btnQuit:{
					AlertDialog.Builder boite2;
	                boite2 = new AlertDialog.Builder(this);
	                boite2.setTitle("Confirmation de sortie");
	                boite2.setIcon(R.drawable.ic_launcher);
	                    boite2.setMessage("Voulez-Vous Quitter ce Jeu?");
	                boite2.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
	                   
	                    public void onClick(DialogInterface dialog, int which) {
	                    	finish();
	                    }
	                    }
	                );
	            
	             boite2.setNegativeButton("Non", new DialogInterface.OnClickListener() {
	                   
	                    public void onClick(DialogInterface dialog, int which) {
	                    	
	                    }
	                    }
	             );
	             
	             /*boite2.setNeutralButton("Ignorer", new DialogInterface.OnClickListener() {
	                   
	                    public void onClick(DialogInterface dialog, int which) {
	                   
	                    }
	                    }
	            );*/
	                boite2.show();
				}// fin case R.id.btnQuit
                break;
                
			}//fin switch
			
		}
		
		protected void onActivityResult (int requestCode, int resultCode, Intent data) {
		      // on récupère le statut de retour de l'activité 2 c'est à dire l'activité numéro 1000
		      if(requestCode==0){
		    	  if(resultCode==3){
		    		  finish();
		    	  }

		      }
		      super.onActivityResult (requestCode, resultCode, data);
		  }
		
		//permet d'afficher les toast
		public void afficheToast(String text)
		  {
		     Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
		  }
				

}
