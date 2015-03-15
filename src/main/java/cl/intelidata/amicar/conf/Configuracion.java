package cl.intelidata.amicar.conf;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Configuracion {

    private Properties datos;
    private String nameFileConf;
    private static Configuracion conf = null;
    public static Logger logger = LoggerFactory.getLogger(Configuracion.class);

    /**
     * *
     * Para ser utilizado dentro de una app standalone
     *
     * @param nameFileConfiguracion
     * @return
     */
    public static Configuracion getInstance() {
        if (conf == null) {
            try {
                String archConf = "/apps/Amicar/config/cotizanteAmicar.properties";

                if (!System.getProperty("file.separator").equals("/")) {
                    archConf = System.getProperty("disco", "c:") + archConf;
                }

                conf = new Configuracion(archConf);

                logger.info("Leyendo archivo de configuracion: " + archConf);
            }
            catch (IOException e) {
                logger.error(e.getMessage(), e);
                return null;
            }
        }
        return conf;
    }

    private Configuracion(String nameFileConf) throws IOException {
        this.nameFileConf = nameFileConf;
        datos = new Properties();
        datos.load(new FileInputStream(nameFileConf));
    }

    public String getInitParameter(String name) {

        if (!datos.containsKey(name.toLowerCase())) {
            logger.error(String.format("GRAVE Error en configuracion llave %s no definida en archivo %s", name, nameFileConf));
            return null;
        }
        String valor = datos.getProperty(name.toLowerCase());
        logger.debug(String.format("%s=%s", name, valor));
        return valor;
    }

    public void setInitParameter(String key, String value) {
        datos.put(key.toLowerCase(), value);

    }
}
