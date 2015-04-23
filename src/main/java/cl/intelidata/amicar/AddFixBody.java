package cl.intelidata.amicar;

import cl.intelidata.amicar.componente.HTMLBody;
import cl.intelidata.amicar.conf.Configuracion;
import cl.intelidata.amicar.util.Text;

import java.io.IOException;

import static cl.intelidata.amicar.conf.Configuracion.logger;

/**
 * @author Maze
 */
public class AddFixBody implements Text {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Configuracion.configLog4();

		if (args.length < 4) {
			logger.error("CANTIDAD INVALIDA DE ARGUMENTOS - [DIR_ENTRADA] [DIR_SALIDA] [JRN_FILE] [DIR_TEMPLATES]");
			System.exit(1);
		}
		
		logger.info("INICIANDO APLICACION");
		logger.info("ARGUMENTOS UTILIZADOS EN LA CONSULTA");
		
		for (int i = 0; i < args.length; i++) {
			logger.debug("ARGUMENTO {}: {} ", i, args[i]);
		}
		
		logger.info("INICIANDO PROCESO");
		
		try {
			HTMLBody body = new HTMLBody(args[0], args[1], args[2], args[3]);
			body.process();
			logger.info("PROCESO FINALIZADO");
		} catch (IOException ex) {
			logger.error(ex.getMessage());
		}
	}
}
