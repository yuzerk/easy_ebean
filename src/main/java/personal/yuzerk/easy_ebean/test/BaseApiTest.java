package personal.yuzerk.easy_ebean.test;


import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import personal.yuzerk.easy_ebean.result.Result;
import personal.yuzerk.easy_ebean.test.debug.HttpDebug;
import personal.yuzerk.easy_ebean.util.JSONUtil;

import java.util.Map;

/**
 * @author yuzk
 * @date 2017/11/25
 */
public class BaseApiTest {

    private HttpDebug httpDebug = new HttpDebug();
    private ResponseEntity entity;


    /**
     * getPort() and get getHost can be Override in child class to specify host and port;
     * also you can use host() and port()
     *
     * in child class, example:
     * get("url")
     *     .port(8086)
     *     .host("127.0.0.1")
     *     .send()
     *     .bodyText()
     *
     * or you can not use .port() and .host()  if you override getPort() and getHost()
     *
     * @return port
     */
    protected int getPort() {
        return 8080;
    }

    protected String getHost() {
        return "localhost";
    }

    //==================== http method ===============================
    public BaseApiTest post(String url) {
        httpDebug.setUrl(url).
                setMethod(HttpMethod.POST).
                setPort(getPort()).
                setHost(getHost());
        getTokenFromFile();
        return this;
    }

    public BaseApiTest get(String url) {
        httpDebug.setUrl(url)
                .setMethod(HttpMethod.GET)
                .setPort(getPort())
                .setHost(getHost());
        getTokenFromFile();
        return this;
    }

    public BaseApiTest contentType(MediaType type) {
        httpDebug.setContentType(type);
        return this;
    }

    public BaseApiTest host(String host){
        httpDebug.setHost(host);
        return this;
    }

    public BaseApiTest header(String name, String value) {
        httpDebug.addHeader(name, value);
        return this;
    }

    public BaseApiTest token(String value) {
        httpDebug.addHeader("token", value);
        return this;
    }

    public BaseApiTest port(Integer port) {
        httpDebug.setPort(port);
        return this;
    }

    public BaseApiTest param(String key, Object value) {
        httpDebug.addParam(key,value);
        return this;
    }

    public BaseApiTest postBody(Object object) {
        httpDebug.setEntity(object);
        return this;
    }

    public BaseApiTest send() {
        entity = httpDebug.send(String.class);
        return this;
    }

    public BaseApiTest send(Class clazz) {
        entity = httpDebug.send(clazz);
        return this;
    }

    public void bodyText() {

        Object body = entity.getBody();
        if(httpDebug.getUrl().contains("login")) {
            Result result = JSONUtil.deserialize((String) body, Result.class);
            if(result.getRet()<0) {
                System.out.println(JSONUtil.format((String) body));
                return;
            }
            Map<String, Object> map = (Map<String, Object>)result.getData();
            String token = (String) map.get("token");
            writeToken(token);
        }
        if(body instanceof String) {
            System.out.println(JSONUtil.format((String) body));
            return;
        }
        String jsonString = JSONUtil.serialize(body);
        System.out.println(JSONUtil.format(jsonString));
    }

    public void xmlBodyText() {
//        Object body = entity.getBody();
//        if(body instanceof String) {
//            System.out.println(XmlUtil.format((String) body));
//        }
    }

    private void getTokenFromFile() {
        String token = TokenFile.read();
        if(token != null) {
            token(token);
        }
    }

    private void writeToken(String token) {
        TokenFile.save(token);
    }
}
