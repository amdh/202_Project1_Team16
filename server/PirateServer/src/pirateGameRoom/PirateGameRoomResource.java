package pirateGameRoom;

import java.util.concurrent.ConcurrentHashMap;

import org.json.*;
import org.restlet.representation.*;
import org.restlet.ext.json.*;
import org.restlet.resource.*;

public class PirateGameRoomResource extends ServerResource {

	private static int playercnt = 0;
	private static ConcurrentHashMap<Integer, String> player = new ConcurrentHashMap();
	private static final String winner = "WINNER";
	// playercnt, stagecnt

	

	@Get("status")
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
		}

		return new JsonRepresentation(response);
	}

	@Post
	public Representation post(JsonRepresentation jsonRep) {

		JSONObject json = jsonRep.getJsonObject();
		String stage = json.getString("stage");
		System.out.println("satge: " + stage);

		playercnt++;
		player.put(playercnt, stage);

		JSONObject response = new JSONObject();
		response.put("player", playercnt);
		response.put("stage", stage);

		System.out.println("---List of Player-----");
		for (int name : player.keySet()) {

			int key = name;
			String value = player.get(name).toString();
			System.out.println(key + " " + value);

		}
		return new JsonRepresentation(response);

	}

	@Put
	public Representation put(JsonRepresentation jsonRep) {

		JSONObject json = jsonRep.getJsonObject();
		String stage = json.getString("stage");
		int playernumber = json.getInt("player");
		System.out.println("stage: " + stage);

		// update hashmap
		// update player with winner when he grabs the treasure
		player.put(playernumber, stage);

		JSONObject response = new JSONObject();
		response.put("player", playercnt);
		response.put("stage", stage);

		return new JsonRepresentation(response);

	}
	
	public static ConcurrentHashMap<Integer, String> getPlayerMap(){
			return player;
		
	}

}
