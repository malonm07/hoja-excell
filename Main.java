import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc=new Scanner (System.in); //creo el metdo scanner
		
		int Nhojas = sc.nextInt();          //numero de hojas
		ArrayList<String[][]> miM = new ArrayList<String[][]>();    //creo un array de cadena para la matriz
		

		for (int i=0; i<Nhojas; i++)    //hago la matriz para que se me ejecute en todo el numero de hojas
		{
			
			int columnas = sc.nextInt();    //leo columnas
			int filas = sc.nextInt();       //leo filas
			miM.add(new String[filas][columnas]) ;  //asigno a mi matriz las filas y columnas
			
			

			for (int f = 0; f<filas;f++)    //Recorro todas las filas
			{	
				for (int c =0; c<columnas;c++)  //recorro todas las columnas
				{
					String viene = sc.next(); //meto lo que viene en cada sitio de la matriz como una cadena
					miM.get(i)[f][c] = viene;   //repito lo que tiene que venir en la matriz tantas filas y columnas haya
					

				}
					//
			}
			

			for (int f = 0; f<miM.get(i).length; f++)   //recorro filas
			{
				for ( int c=0; c<miM.get(i)[0].length;c++)  //recorro columnas
				{

						if (miM.get(i)[f][c].startsWith("="))   //celda que empiece por =
						{
							miM.get(i)[f][c]=miM.get(i)[f][c].replace("=", ""); //sustituyo el igual por nada
							
							String[] sumatorio = miM.get(i)[f][c].split("\\+"); //me separa la celda por el mas en 
							int ayuda = 0;      //un array de enteros llamado sumatorio
	
							for (int i1=0; i1<sumatorio.length;i1++)    //recorro todos los sumatorios (CELDAS) (B1 A2)
							{
								
								ArrayList<Character> numeroC = new ArrayList<Character>(); //creo un array de tipo character llamado numeroC
								int numLetra = 0;			//creo una variable numLetra que empiece por 0
								for (int ch = 0; ch<sumatorio[i1].length();ch++)//recorro la longitud de cualquier sumatorio
								{
									
									
									if (!(Character.isDigit(sumatorio[i1].charAt(ch)))) //si cualquier celda(sumatorio) no es un digito
									{
										numLetra++;//MIENTRAS QUE SEA UN CARCATEr el numero de la letra aumenta
										numeroC.add(sumatorio[i1].charAt(ch));  //voy guardando el CARACTER en el array numeroC
									}
								}
								
								int filaColumna = 0;
								for (int h=0;h<numeroC.size();h++)//recorro los caracteres de numeroC
								{
									
									int valorL1 = SwitchLetra(numeroC.get(h));  //Susttituyo el valor de laletra en el switch
									
									filaColumna += (valorL1)*  ((int) Math.pow(26, numeroC.size()-1-h));
									
								}
								
								int filaCelda = Integer.parseInt(sumatorio[i1].substring(numLetra));

								ayuda += Integer.parseInt(miM.get(i)[filaCelda-1][filaColumna-1]);//hallo la posicion de lamatriz y a llamo ayuda
							}
							miM.get(i)[f][c] = Integer.toString(ayuda); //convierto la cadena ayuda en una casilla de la matriz
						}
					
				}
				
			}
			
		
		}
		
		for (int i=0; i<Nhojas; i++)
		{
			for (int f = 0; f<miM.get(i).length; f++)//recorro filas
			{
				for ( int c=0; c<miM.get(i)[0].length;c++)
				{
					System.out.print(miM.get(i)[f][c]);
					if (c<miM.get(i)[0].length-1) 
					{
						
						System.out.print(" ");
					}
				}
				System.out.println();
			}
		}
		
		
	}
	
	private static int SwitchLetra(char letra) {	// Hago el switch de las letras y devuelve el valor numerico al
		int valor = 0;								// que corresponde la letra que le pasamos al metodo
													
		switch (letra) {
		case 'A':{	
			valor=1; 
			break;}
		case 'B':{
			valor=2;
			break;}
		case 'C':{
			valor=3; 
			break;}
		case 'D':{
			valor=4; 
			break;}
		case 'E':{
			valor=5; 
			break;}
		case 'F':{
			valor=6; 
			break;}
		case 'G':{
			valor=7; 
			break;}
		case 'H':{
			valor=8; 
			break;}
		case 'I':{
			valor=9; 
			break;}
		case 'J':{
			valor=10; 
			break;}
		case 'K':{
			valor=11; 
			break;}
		case 'L':{
			valor=12; 
			break;}
		case 'M':{
			valor=13; 
			break;}
		case 'N':{
			valor=14; 
			break;}
		case 'O':{
			valor=15; 
			break;}
		case 'P':{
			valor=16; 
			break;}
		case 'Q':{
			valor=17; 
			break;}
		case 'R':{
			valor=18; 
			break;}
		case 'S':{
			valor=19; 
			break;}
		case 'T':{
			valor=20; 
			break;}
		case 'U':{
			valor=21; 
			break;}
		case 'V':{
			valor=22; 
			break;}
		case 'W':{
			valor=23; 
			break;}
		case 'X':{
			valor=24; 
			break;}
		case 'Y':{
			valor=25; 
			break;}
		case 'Z':{
			valor=26; 
		break;}
		}
		
		return valor;
	}

}
