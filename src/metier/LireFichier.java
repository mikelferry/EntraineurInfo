package metier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LireFichier {
	
	static String strLine = null;
	public static String lireFichier(InputStream ins){
		
		if(ins!=null){
				InputStreamReader isr = new InputStreamReader(ins);
				BufferedReader br = new BufferedReader(isr);
				StringBuilder sb = new StringBuilder();
				String chaine;
				
				try {
					while((chaine = br.readLine())!=null){
						sb.append(chaine);
					} 
					//on ferme le fichier
					ins.close();
					strLine = sb.toString();
					//afficheToast(strLine);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}//fin while
		}//fin IF
		return strLine;
	}
	
}
