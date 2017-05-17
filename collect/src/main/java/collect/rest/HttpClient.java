package collect.rest;
import okhttp3.*;

import java.io.IOException;
import java.util.Map;

public class HttpClient {
  private OkHttpClient client;
  private static HttpClient httpClient;

  private static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=utf-8");//mdiatype 这个需要和服务端保持一致
  public static final MediaType FORM_CONTENT_TYPE
      = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
  /**
   * 单例获取 OKhttpManager实例
   */
  private static HttpClient getInstance() {
    if (httpClient == null) {
      httpClient = new HttpClient();
    }
    return httpClient;
  }

  private HttpClient() {
    client = new OkHttpClient();
  }

  public void getUrl(String url) throws IOException {
    Request request = new Request.Builder().url(url).build();
    //创建请求
    Call call = client.newCall(request);
    //异步执行
    call.enqueue(new Callback() {
      public void onFailure(Call call, IOException e) {
        e.printStackTrace();
      }

      public void onResponse(Call call, Response response) throws IOException {
        System.out.println(response.body().string());
      }
    });
  }

  public void postJson(String url, Map<String, String> paramsMap) {
    //处理参数
    StringBuilder tempParams = new StringBuilder();
    for (String key : paramsMap.keySet()) {
      tempParams.append(paramsMap.get(key));
    }
    //生成参数
    String params = tempParams.toString();
    //创建一个请求实体对象 RequestBody
    RequestBody body = RequestBody.create(MEDIA_TYPE_JSON, params);
    Request request = new Request.Builder().url(url).post(body).build();
    //创建请求
    Call call = client.newCall(request);
    //异步执行请求
    call.enqueue(new Callback() {
      public void onFailure(Call call, IOException e) {
        e.printStackTrace();
      }

      public void onResponse(Call call, Response response) throws IOException {
        System.out.println(response.body().string());
      }
    });
  }

 public void postForm(String url, Map<String, String> paramsMap) {
    //创建一个FormBody.Builder
    FormBody.Builder builder = new FormBody.Builder();
    if(paramsMap !=null){
      for (Map.Entry<String,String> entry :paramsMap.entrySet() ){
        builder.add(entry.getKey(),entry.getValue());
      }
    }
    RequestBody body = builder.build();
    Request request = new Request.Builder().url(url).post(body).build();
    //执行请求
    Call call = client.newCall(request);

    call.enqueue(new Callback() {
      public void onFailure(Call call, IOException e) {
        e.printStackTrace();
      }

      public void onResponse(Call call, Response response) throws IOException {
        System.out.println(response.body().string());
      }
    });
  }

  public static void main(String[] args) throws IOException {
    String url1="http://localhost:8080/api/v1/testrest/postchinese";
    String url2="http://localhost:8080/api/v1/testrest/postchinesetest";
    String url3="http://quotes.money.163.com/service/chddata.html?code=0601857&start=20071105&end=20150618&fields=TCLOSE;HIGH;LOW;TOPEN;LCLOSE;CHG;PCHG;TURNOVER;VOTURNOVER;VATURNOVER;TCAP;MCAP";
    String url4="http://www.baidu.com";

    HttpClient client = HttpClient.getInstance();
    client.getUrl(url4);

//
//    Map<String,String > params = new HashMap<String, String>();
//    params.put("name"," aaa   ");
//    params.put("address","   bbb    ");
//    HttpClient.getInstance().postForm(url1,params);

//    Map<String,String > params = new HashMap<String, String>();
//    Gson gson = new Gson();
//    String json = gson.toJson(postUser);
//    params.put("postUser",json);
//    HttpClient.getInstance().postJson(url,params);
  }
}
