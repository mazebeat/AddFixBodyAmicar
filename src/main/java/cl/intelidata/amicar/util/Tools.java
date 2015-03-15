package cl.intelidata.amicar.util;

import static cl.intelidata.amicar.conf.Configuracion.logger;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author Maze
 */
public class Tools {

    /**
     *
     */
    public static final Logger LOGGER = Logger.getLogger(Tools.class.getName());

    /**
     *
     * @return
     */
    public static Timestamp nowDate() {
        logger.info("GET DATE");
        Date fecha = new Date();
        Timestamp time = new Timestamp(fecha.getTime());

        return time;
    }

    /**
     *
     * @param urlBase
     * @param params
     * @return
     */
    public static String fullURL(String urlBase, HashMap<String, String> params) {
        logger.info("CREATE URL TO ", urlBase);
        for (Map.Entry<String, String> entry : params.entrySet()) {
            String param = entry.getKey() + "=" + entry.getValue() + "&";
            urlBase = urlBase.concat(param);
        }

        if (urlBase.endsWith("&")) {
            urlBase = urlBase.substring(0, urlBase.length() - 1);
        }

        return urlBase;
    }

    /**
     *
     * @param input
     * @return
     */
    public static String desencryptInput(String input) {
        String decrypted = null;
        try {
            MCrypt mcrypt = new MCrypt();
            decrypted = new String(mcrypt.decrypt(input));
        }
        catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        return decrypted;
    }

    /**
     *
     * @param input
     * @return
     */
    public static String encryptInputs(String input) {
        String encrypted = null;
        try {
            MCrypt mcrypt = new MCrypt();
            encrypted = MCrypt.bytesToHex(mcrypt.encrypt("1"));
        }
        catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        return encrypted;
    }
}
