import static io.restassured.RestAssured.given;
import org.testng.Assert;
import components.ClassBody;
import components.RawToJson;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Basic {

	public static void main(String[] args) {

		//addAddress test script
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String getAddDtls=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json").
		body(ClassBody.addAddressBody()).when().post("maps/api/place/add/json").
		then().log().all().assertThat().statusCode(200).extract().response().asString();
		JsonPath js=RawToJson.getjson(getAddDtls);
		String placeID=js.getString("place_id");
		System.out.println("Place ID as response :: "+placeID);
		
		//updateAddress test script
		String newAdd="New Address, New Country";
		String updateAddDtls=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json").
		body(ClassBody.updateAddBody(newAdd,placeID)).when().put("maps/api/place/update/json").
		then().assertThat().log().all().statusCode(200).extract().response().asString();
		String msg=RawToJson.getjson(updateAddDtls).getString("msg");
		System.out.println("response from update Address API :: "+msg);
		
		//getAddress test script
		String getAddRes=given().log().all().queryParam("key", "qaclick123").queryParam("place_id",placeID).
				when().get("maps/api/place/get/json").then().assertThat().log().all().extract().response().toString();
		String res=RawToJson.getjson(getAddRes).getString("address");
		System.out.println("Address as response :: "+res);
		
		Assert.assertEquals(res,newAdd);
	}

}
