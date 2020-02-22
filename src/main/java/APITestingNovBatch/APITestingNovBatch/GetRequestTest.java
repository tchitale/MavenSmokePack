package APITestingNovBatch.APITestingNovBatch;
import org.apache.http.Header;
import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class GetRequestTest {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		// TODO Auto-generated method stub
		CloseableHttpClient CloseableHttpClient= HttpClients.createDefault();
		HttpGet get = new HttpGet("https://reqres.in/api/users?page=2");
		CloseableHttpResponse CloseableHttpResponse= CloseableHttpClient.execute(get);
		int StatusCode= CloseableHttpResponse.getStatusLine().getStatusCode();
		
		//int daten= CloseableHttpResponse.getHeaders();
		Header[] Headers= CloseableHttpResponse.getAllHeaders();
		System.out.println(StatusCode);
		
		
		for (int i=0;i<Headers.length;i++)
		{
			String sHeaderKey=Headers[i].getName();
			String sHeadervalue=Headers[i].getValue();
			System.out.println(sHeaderKey + "-->" + sHeadervalue );
		}
	   // To read Body
		
		String reponse=EntityUtils.toString(CloseableHttpResponse.getEntity(),"UTF-8");
		System.out.println("---------------------------");	
        System.out.println(reponse);
        
        JSONObject jSONObject = new JSONObject(reponse);
        Integer sTotal = (Integer)jSONObject.get("total");
        Integer sPage = (Integer)jSONObject.get("page");
        
        System.out.println("Total ---> " +sTotal+ "and page --> " +sPage);
        
       JSONArray JSON_array = jSONObject.getJSONArray("data");
        for (int i=0;i<JSON_array.length();i++)
        {
        JSONObject jSONObj_dataArray = JSON_array.getJSONObject(i);
        String strEmailid = (String) jSONObj_dataArray.get("email");
        System.out.println(strEmailid);
        }
        
        
	}

}
