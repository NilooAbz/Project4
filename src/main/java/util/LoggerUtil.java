package util;
import org.apache.log4j.Logger;

/**
 * Created by DotinSchool2 on 8/23/2016.
 */


public class LoggerUtil {

    private static Logger logger = Logger.getLogger("MyLogger");

    public static Logger getLogger(){
        return  logger;
    }
}
