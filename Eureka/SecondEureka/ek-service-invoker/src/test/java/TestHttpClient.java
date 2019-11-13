import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
//测试1000次
public class TestHttpClient {

	public static void main(String[] args) throws Exception {
		// 创建默认的HttpClient
		CloseableHttpClient httpclient = HttpClients.createDefault();
		// 调用1000次服务并输出结果
		for(int i = 0; i < 1000; i++) {
			// 调用 GET 方法请求服务
			HttpGet httpget = new HttpGet("http://localhost:9000/router");
			// 获取响应
			HttpResponse response = httpclient.execute(httpget);
			// 根据 响应解析出字符串
			System.out.println(EntityUtils.toString(response.getEntity()));
			Thread.sleep(10);
		}
	}
}
