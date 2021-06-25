package components;

import io.restassured.path.json.JsonPath;

public class RawToJson {

	public static JsonPath getjson(String data) {
		JsonPath js=new JsonPath(data);
		return js;
	}
}
