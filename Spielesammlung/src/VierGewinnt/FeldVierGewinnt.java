package VierGewinnt;

public class FeldVierGewinnt extends Main.Spielfeld{
	
	//Konstruktor
	public FeldVierGewinnt() 									{
		super.feld = new int[8][8];
		super.initialisiere();
	}
	
	//Operationen
	public int setzeStein(int wert, int x, int y)				{
		return 0;
	}
	public int setzeStein(int wert, int spalte) 				{
		//Eingabe Pr�fen: Muss zwischen 1 und 8 liegen
		if(spalte < 1 || spalte > 8) 
			return 0;
		
		//Pr�fen, ob die gew�hlte Spalte nicht voll ist
		else if(!pruefeSpalte(spalte - 1)) {
			
			//Wenn noch nicht voll, dann Feld setzen
			setzeFeld(wert, spalte - 1);
			
			//Dann pr�fen, ob das Feld jetzt voll ist
			if(pruefeVoll())
				return 2;	//Wenn voll, dann 2 zur�ck geben
			else 
				return 3;	//Wenn nicht voll, dann 3 zur�ckgeben
		}
		
		//Letzer m�glicher Fall: Spalte ist voll
		else 
			return 1;		//Wenn Spalte voll ist, dann 1 zur�ckgeben
		
	}
	public boolean pruefeVoll() 								{
		for(int x = 0; x < 8; x++) {
			if(!pruefeSpalte(x))
				return false;
		}
		return true;
	}
	
	private void setzeFeld(int wert, int spalte) 				{
		for(int y = 0; y <= 7; y++) {
			if(feld[spalte][y] == 0) {
				feld[spalte][y] = wert;
				break;
			}
		}
	}	
	private boolean pruefeSpalte(int spalte) 					{
		if(feld[spalte][7] != 0)
			return true;
		else 
			return false;
	}
}
