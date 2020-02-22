package APITestingNovBatch.APITestingNovBatch;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class getPutrequest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		CloseableHttpClient CloseableHttpClient= HttpClients.createDefault();
		HttpGet get = new HttpGet("https://reqres.in/api/users/2");
		CloseableHttpResponse CloseableHttpResponse= CloseableHttpClient.execute(get);
		int StatusCode= CloseableHttpResponse.getStatusLine().getStatusCode();

		//int daten= CloseableHttpResponse.getHeaders();
		Header[] Headers= CloseableHttpResponse.getAllHeaders();
		System.out.println(StatusCode);

String str=null;
		String reponse=EntityUtils.toString(CloseableHttpResponse.getEntity(),"UTF-8");
		System.out.println("---------------------------");	
		System.out.println(reponse);

		JSONObject jSONObject = new JSONObject(reponse);
		JSONObject jSONData=(JSONObject) jSONObject.get("data");
		System.out.println(jSONData.get("first_name"));
		jSONData.put("first_name", "Tushar");
		System.out.println(jSONData.get("first_name"));
		
		String strRequestPayload = FileUtils.readFileToString(new File ("C:\\Users\\tushar.chitale\\Desktop\\screenshot\\payloadnew.txt"));
		//System.out.println(strRequestPayload);
         if ((strRequestPayload.contains("morpheus")) == true)
         {
        	 str=strRequestPayload.replace("leader", "HELLO");
         }
         System.out.println(str);
		//strRequestPayload.replace(oldChar, newChar)
         
	}

}
