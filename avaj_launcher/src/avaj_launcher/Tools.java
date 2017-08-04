package avaj_launcher;

import java.util.ArrayList;

/*	static == global
* 	final == const
*/

public class Tools {
	
	public static boolean verbose = true;
	
	public static ArrayList<String> arrID = new ArrayList<String>();
	
	public static ArrayList<String> arrLogs = new ArrayList<String>(); // > simulation.txt
		
    public static final String[] arrWeathers = {"SUN", "RAIN", "FOG", "SNOW", "WIND"}; //bonus Wind
    
    public static final String[] arrAircrafts = {"JetPlane", "Helicopter", "Baloon", "Drone"}; //bonus Drone
	
    private static int[][][] arrAircraftMove = 	{ 	/*		SUN				RAIN				FOG				SNOW				WIND 		*/
				/* JetPlane */						{	{0, 10, 2},		{0, 5, 0},		{0, 1, 0},		{0, 0, -7},		{0, 3, -2}		},
				/* Helicopter */						{	{10, 0, 2},		{5, 0, 0},		{1, 0, 0},		{0, 0, -12},		{0, 5, -4}		},
				/* Baloon */							{	{2, 0, 4},		{0, 0, -5},		{0, 0, -3},		{0, 0, -15},		{0, 10, -8}		},
				/* Drone */			 				{	{4, 0, 2},		{6, 0, -2},		{1, 0, 0},		{0, 0, -12},		{0, 2, -5}		}			
													/* {Longitude, Latitude, Height} */  														 
									  			};
    
    private static int[][] arrWeatherMap = 	{	/*	SUN				RAIN				FOG				SNOW				 WIND			*/
    												{0,300,500,999}, {201,999,0,250}, {0,200,0,250}, {301,999,500,999}, {0,999,251,499}
    												/* {long min, long max, lat min, lat max} */
    											};
    
    
    									/* 	   (longitude)	999	_____________________________ 999
    									 * 						|		|		|			|
    									 *						|		|		|			|
    									 *						|		|		|	SNOW		|
    									 *						|  RAIN	|		|			|					height >= 800  // always SUN
    									 *						|		|  WIND	|			|
    									 *						|		|		|___________	| 300
    									 *					200	|_______	|		|			|
    									 *						|  FOG	|		|	 SUN		|
    									 * 			  		  	|_______	|_______	|___________	| 
    									 * 			   		   0			250		500		   999    (latitude)
    									 */
    
    
    public static int whatWeather(int height, int longitude, int latitude) {
    		if (height >= 800)
    			return 0;
    		int i = 0;
    		int j = 0;
    		while (i < arrWeatherMap.length)
    		{
    			if (longitude >= arrWeatherMap[i][j] && longitude <= arrWeatherMap[i][j+1] 
    					&& latitude >= arrWeatherMap[i][j+2] && latitude <= arrWeatherMap[i][j+3])
    				return i;
    			i++;
    		}
    		return 0;
    }
    
	public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30;1m";
    public static final String RED = "\u001B[31;1m";
    public static final String GREEN = "\u001B[32;1m";
    public static final String YELLOW = "\u001B[33;1m"; 		//for MyExceptions
    public static final String BLUE = "\u001B[34;1m";
    public static final String PURPLE = "\u001B[35;1m";
    public static final String CYAN = "\u001B[36;1m";
    public static final String WHITE = "\u001B[37;40;1m";

}
