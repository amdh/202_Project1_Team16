package pirateGameRoom;

import java.util.concurrent.ConcurrentHashMap;

import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class PiratePlayers extends ServerResource{

		
	@Get
	public Representation get() throws JSONException {
		
		ConcurrentHashMap<Integer, String> player = PirateGameRoomResource.getPlayerMap();
		JSONObject response = new JSONObject(player);
		

		return new JsonRepresentation(response);
	}
}
