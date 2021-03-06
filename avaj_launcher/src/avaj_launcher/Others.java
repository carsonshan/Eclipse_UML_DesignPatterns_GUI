package avaj_launcher;

public class Others extends Aircraft implements Flyable {

	private WeatherTower weatherTower;
	private String type;
	
	Others(String type, String name, Coordinates coordinates) {
		super(name, coordinates);
		this.type = type;
	}
	
	@Override
	public void updateConditions() {
		String weather = weatherTower.getWeather(coordinates);
		String log;
		
		coordinates = Tools.changeCoordinates(coordinates, weather, type);
		int height = coordinates.getHeight();
		if (height < 1)
		{
			weatherTower.unregister(this);
			log = type + "#" + name + "(" + Long.toString(id) + "): " + Tools.getLogAircrafts(weather) + '\n' 
					+ type + "#" + name + "(" + Long.toString(id) + ") landing.\n"
					+ "Tower says: " + type + "#" + name + "(" + Long.toString(id) + ") unregistered from weather tower.";
		}
		else
			log = type + "#" + name + "(" + Long.toString(id) + "): " + Tools.getLogAircrafts(weather);
		
		Tools.arrLogs.add(log);
	}

	@Override
	public void registerTower(WeatherTower weatherTower) {
		String logOthers = "Tower says: " + type + "#" + name + "(" + Long.toString(id) + ") registered to weather tower.";
		this.weatherTower = weatherTower;
		this.weatherTower.register(this); //Tower.java
		
		Tools.arrLogs.add(logOthers); //debug > put in file

	}

}
