package pirateGameRoom;

import org.json.JSONException;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;

public interface IGameRoomProxy {
	
	public Representation get(String status) throws JSONException;
	public Representation post(JsonRepresentation jsonRep) throws JSONException;
	public Representation delete();
	public Representation put(JsonRepresentation jsonRep) throws JSONException;

}
