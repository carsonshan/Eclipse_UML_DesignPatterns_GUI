package avaj_launcher;

public class WeatherProvider {

	private static WeatherProvider weatherProvider;
	private static String[] weather;
	
	//Singleton > private constructor
	private WeatherProvider() {}
	
	//static == global
	public static WeatherProvider getProvider() {
		if (weatherProvider == null) {
			weatherProvider = new WeatherProvider();
			weather = Tools.arrWeathers;
		}
		return weatherProvider;
	}
	
	public String getCurrentWeather(Coordinates coordinates) {
		int longitude = coordinates.getLongitude();
		int latitude = coordinates.getLatitude();
		int height = coordinates.getHeight();
		
		return (weather[Tools.whatWeather(height, longitude, latitude)]);
	}
}
