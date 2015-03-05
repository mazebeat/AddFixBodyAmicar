package cl.intelidata.amicar.main;

import cl.intelidata.amicar.beans.HTMLBody;
import cl.intelidata.amicar.beans.MessageUtils;
import cl.intelidata.amicar.beans.Text;

import java.io.IOException;

/**
 * Created by Maze on 26-02-2015.
 */
public class AddFixBody implements Text {

	/**
	 * Main method
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length < 4) {
			MessageUtils.error("CANTIDAD INVALIDA DE ARGUMENTOS - [DIR_ENTRADA] [DIR_SALIDA] [JRN_FILE] [DIR_TEMPLATES]");
			System.exit(1);
		}
		MessageUtils.info("INICIANDO APLICACION");
		MessageUtils.info("ARGUMENTOS UTILIZADOS EN LA CONSULTA");
		for (int i = 0; i < args.length; i++) {
			MessageUtils.debug("ARGUMENTO " + i + ": " + args[i]);
		}
		MessageUtils.info("INICIANDO PROCESO");
		try {
			HTMLBody body = new HTMLBody(args[0], args[1], args[2], args[3]);
			body.process();
			MessageUtils.info("PROCESO FINALIZADO");
			MessageUtils.info("=========================================================================");
		} catch (IOException ex) {
			MessageUtils.error(ex.getMessage());
		}
	}
}
