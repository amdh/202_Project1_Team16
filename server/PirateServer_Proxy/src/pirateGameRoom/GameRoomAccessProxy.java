package pirateGameRoom;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

public class GameRoomAccessProxy extends ServerResource implements IGameRoomProxy{

	private PirateGameRoomResource pirateResource = new PirateGameRoomResource();

	private static int playercnt = 0;

	private static boolean isWinner = false;

	private static final String winner = "WINNER";

	@Get
	public Representation get(String status) throws JSONException {

		return pirateResource.get(status);
	}

	@Post
	public Representation post(JsonRepresentation jsonRep) throws JSONException {

		playercnt++;
		if (playercnt <= 5)
			return pirateResource.post(jsonRep);

		else {
			JSONObject response = new JSONObject();
			response.put("Error", "Maximum number of players already allocated");
			return new JsonRepresentation(response);
		}

	}

	@Put
	public Representation put(JsonRepresentation jsonRep) throws JSONException{

		
		JSONObject json = jsonRep.getJsonObject();
		String stage = json.getString("stage");

		if (stage.equalsIgnoreCase(winner)) {

			isWinner = true;
		}
		return  pirateResource.put(json);

	}

	@Delete
	public Representation delete() {

		playercnt = 0;
		return pirateResource.delete();
		/*
		if (isWinner) {
			playercnt = 0;
			return pirateResource.delete();
		}else{
			JSONObject response = new JSONObject();
			response.put("Error", "GameRoom is running with 5 active players.");
			return new JsonRepresentation(response);
			
		}*/
	}

	public static int getPlayerCount() {
		return playercnt;

	}

}
