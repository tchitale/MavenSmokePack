package APITestingNovBatch.APITestingNovBatch;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class getrequestdelete {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		// TODO Auto-generated method stub
		CloseableHttpClient CloseableHttpClient= HttpClients.createDefault();
		HttpDelete Delete = new HttpDelete("https://reqres.in/api/users/2");
		
		CloseableHttpResponse CloseableHttpResponse= CloseableHttpClient.execute(Delete);
		int StatusCode= CloseableHttpResponse.getStatusLine().getStatusCode();

		System.out.println(StatusCode);
	}

}
