package pirateGameRoom;

import java.util.concurrent.ConcurrentHashMap;

import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;

public class PirateGameRoomResource {

	
	private static ConcurrentHashMap<Integer, String> player = new ConcurrentHashMap<Integer, String>();
	private static final String winner = "WINNER";
	// playercnt, stagecnt

	public Representation get(String status) throws JSONException {

		boolean isWinner = false;
		JSONObject response = new JSONObject();
		for (int name : player.keySet()) {

			int key = name;
			String stage = player.get(name).toString();
			if (stage.equalsIgnoreCase(winner)) {
				isWinner = true;
				response.put("player", key);
				response.put("winner", isWinner);

				break;

			}
			System.out.println(key + " " + stage);

			response.put("winner", isWinner);
			response.put("playerCount", player.size());
		}

		return new JsonRepresentation(response);
	}

	public Representation post(JsonRepresentation jsonRep) {

		JSONObject json = jsonRep.getJsonObject();
		String stage = json.getString("stage");
		System.out.println("satge: " + stage);

		player.put(GameRoomAccessProxy.getPlayerCount(), stage);
		
		JSONObject response = new JSONObject();
		response.put("player", GameRoomAccessProxy.getPlayerCount());
		response.put("stage", stage);

					System.out.println("---List of Player-----");
					for (int name : player.keySet()) {
			
						int key = name;
						String value = player.get(name).toString();
						System.out.println(key + " " + value);
			
					}
		return new JsonRepresentation(response);

	}

	public Representation put(JSONObject json) {

		//JSONObject json = jsonRep.getJsonObject();
		String stage = json.getString("stage");
		int playernumber = json.getInt("player");
		System.out.println("stage: " + stage);

		// update hashmap
		// update player with winner when he grabs the treasure
		player.put(playernumber, stage);

		JSONObject response = new JSONObject();
		response.put("player", playernumber);
		response.put("stage", stage);

		return new JsonRepresentation(response);

	}
	
	public Representation delete() {

		player.clear();
		
		JSONObject response = new JSONObject();
		response.put("player", GameRoomAccessProxy.getPlayerCount());
		

		return new JsonRepresentation(response);

	}

	public static ConcurrentHashMap<Integer, String> getPlayerMap() {
		return player;

	}

}
