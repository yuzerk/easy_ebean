package personal.yuzerk.easy_ebean;



import org.junit.Test;
import org.springframework.http.MediaType;
import personal.yuzerk.easy_ebean.modules.oneToManyTest.entity.Customer;
import personal.yuzerk.easy_ebean.result.MyPagedList;
import personal.yuzerk.easy_ebean.test.BaseApiTest;
import personal.yuzerk.easy_ebean.util.JSONUtil;
import personal.yuzerk.easy_ebean.util.UuidUtil;

/**
 * @author yuzk
 * @date 2017/11/8
 */
public class UserTest extends BaseApiTest {

    @Test
    public void serviceTest() {

        for(int i = 0;i<10;i++) {
            System.out.println(i+"      :        "+ UuidUtil.randomUUID());
        }
    }

    @Test
    public void test() {
        get("user/findlist")
                .send()
                .bodyText();
    }

    @Test
    public void test1() {
        get("cus/insert")
                .param("name","bob")
                .param("sex",1)
                .send()
                .bodyText();

    }

    @Test
    public void test2() {
        post("/cus/page")
                .postBody(new MyPagedList<Customer>()
                        .setSkip(0)
                        .setPageSize(2))
                .send()
                .bodyText();
    }

    @Test
    public void cus_get() {
        get("cus/get")
                .param("name","bob")
                .send()
                .bodyText();
    }

    @Test
    public void testTransaction() {

        get("cus/trans")
                .param("name","bob")
                .send()
                .bodyText();
    }

    @Test
    public void xmlTest() {
        get("/xml/test")
                .contentType(MediaType.APPLICATION_XML)
                .send()
                .xmlBodyText();
    }

    @Test
    public void parseJson(){
        String jsonString = "[{\"name\":\"lucy\",\"password\":\"110\",\"id\":\"1\"},{\"name\":\"nick\",\"password\":\"123\",\"id\":\"2\"},{\"name\":\"marry\",\"password\":\"789\",\"id\":\"3\"}]";
        System.out.println(JSONUtil.format(jsonString));
    }

    @Test
    public void XMLformat() {
//        String a = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><Result><code>1</code><message>this is a XML result test response</message></Result>";
//        System.out.println(XmlUtil.format(a));
    }
}
