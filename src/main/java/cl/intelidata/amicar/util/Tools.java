package cl.intelidata.amicar.util;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import static cl.intelidata.amicar.conf.Configuracion.logger;

/**
 * @author Maze
 */
public class Tools {

    /**
     *
     */
    public static final Logger LOGGER = Logger.getLogger(Tools.class.getName());

    /**
     * @return
     */
    public static Timestamp nowDate() {
        logger.info("GET DATE");
        Date fecha = new Date();
        Timestamp time = new Timestamp(fecha.getTime());

        return time;
    }

    /**
     * @param urlBase
     * @param params
     *
     * @return
     */
    public static String fullURL(String urlBase, HashMap<String, String> params) {
        if (!urlBase.endsWith("?")) {
            urlBase = urlBase.concat("?");
        }

        for (Map.Entry<String, String> entry : params.entrySet()) {
            String param = entry.getKey() + "=" + entry.getValue() + "&";
            urlBase = urlBase.concat(param);
        }

        if (urlBase.endsWith("&")) {
            urlBase = urlBase.substring(0, urlBase.length() - 1);
        }

        return urlBase.replace("&", "&amp;");
    }

    /**
     * @param input
     *
     * @return
     */
    public static String desencryptInput(String input) {
        String decrypted = null;
        try {
            MCrypt mcrypt = new MCrypt();
            decrypted = new String(mcrypt.decrypt(input));
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        return decrypted;
    }

    /**
     * @param input
     *
     * @return
     */
    public static String encryptInputs(String input) {
        String encrypted = null;
        try {
            MCrypt mcrypt = new MCrypt();
            encrypted = MCrypt.bytesToHex(mcrypt.encrypt(input));
        } catch (Exception e) {
            logger.info(e.getMessage(), e);
        }

        return encrypted;
    }
}
