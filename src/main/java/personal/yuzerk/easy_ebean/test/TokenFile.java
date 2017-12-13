package personal.yuzerk.easy_ebean.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author yuzk
 * @date 2017/12/6
 */
public class TokenFile {

    private static Logger logger = LoggerFactory.getLogger(TokenFile.class);

    private static final String directory = "/tmp/token";
    private static final String fileName = "token.txt";

    public static void save(String tokenId) {
        try {
            Files.createDirectories(Paths.get(directory));
            Files.write(Paths.get(directory,fileName), tokenId.getBytes("UTF-8"));
        }catch (Exception e) {
            logger.debug("write token into file error");
        }
    }

    public static String read(){
        try {
            List<String> lines = Files.readAllLines(Paths.get(directory,fileName));
            if(lines == null || lines.isEmpty()) {
                return null;
            }
            return lines.get(0);
        }catch (Exception e){
            logger.debug("read token from file error");
        }
        return null;
    }
}
