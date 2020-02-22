package APITestingNovBatch.APITestingNovBatch;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class getRequestPost {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		// TODO Auto-generated method stub
		CloseableHttpClient CloseableHttpClient= HttpClients.createDefault();
		HttpPost post = new HttpPost("https://reqres.in/api/users?page=2");


		post.addHeader("Content-Type","application/json");
		//For bearer Token
		//String sToken ="oasdfoasdfa";
		//post.addHeader("Authorization","Bearer"   +sToken);
		//post.addHeader("Authorization","Basic Auth "   +sToken "Username":"Password"");

		String strRequestPayload = FileUtils.readFileToString(new File ("C:\\Users\\tushar.chitale\\Desktop\\screenshot\\payload.txt"));//query
		//@suppresswarning("deprication")
		post.setEntity(new StringEntity(strRequestPayload)); // query



		CloseableHttpResponse CloseableHttpResponse= CloseableHttpClient.execute(post);
		int StatusCode= CloseableHttpResponse.getStatusLine().getStatusCode();

		System.out.println(StatusCode);

	}

}
