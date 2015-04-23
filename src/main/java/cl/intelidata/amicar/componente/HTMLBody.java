package cl.intelidata.amicar.componente;

import static cl.intelidata.amicar.conf.Configuracion.logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jam.superutils.FastFileTextReader;
import org.jdom.Content;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import cl.intelidata.amicar.conf.Configuracion;
import cl.intelidata.amicar.db.Clientesdiario;
import cl.intelidata.amicar.util.FileUtils;
import cl.intelidata.amicar.util.Texto;
import cl.intelidata.amicar.util.Tools;

/**
 * @author Maze
 */
public class HTMLBody {

	private final Data   data;
	private       String dirIn;
	private       String dirOut;
	private       String dirJrn;
	private       String dirTpl;

	/**
	 * @param dirIn
	 * @param dirOut
	 * @param dirJrn
	 * @param dirTpl
	 */
	public HTMLBody(String dirIn, String dirOut, String dirJrn, String dirTpl) {
		this.dirIn = dirIn;
		this.dirOut = dirOut;
		this.dirJrn = dirJrn;
		this.dirTpl = dirTpl;
		this.data = new Data();
	}


	/**
	 * @return
	 */
	public String getDirIn() {
		return dirIn;
	}

	/**
	 * @param dirIn
	 */
	public void setDirIn(String dirIn) {
		this.dirIn = dirIn;
	}

	/**
	 * @return
	 */
	public String getDirJrn() {
		return dirJrn;
	}

	/**
	 * @param dirJrn
	 */
	public void setDirJrn(String dirJrn) {
		this.dirJrn = dirJrn;
	}
        
        /**
	 * @return
	 */
	public String getDirTpl() {
		return dirTpl;
	}

	/**
	 * @param dirTpl
	 */
	public void setDirTpl(String dirTpl) {
		this.dirTpl = dirTpl;
	}
        

	/**
	 * @return
	 */
	public String getDirOut() {
		return dirOut;
	}

	/**
	 * @param dirOut
	 */
	public void setDirOut(String dirOut) {
		this.dirOut = dirOut;
	}
        
        
	/**
	 * @throws IOException
	 */
	public void process() throws IOException {
		List<String> list = FileUtils.readDirectory(this.getDirIn(), Texto.HTML_EXT);

		if (list.size() <= 0) {
			System.out.println("NO HAY ARCHIVOS EN EL DIRECTORIO ESPECIFICADO");
			System.exit(2);
		}

		this.data.setListFiles(new ArrayList<String>(list));
		String jrn = this.searchJRN(this.getDirJrn());

		if (jrn != null) {
			String path = this.convertToXML(jrn);
			File exist = new File(path);

			if (exist.exists()) {
				this.setDirJrn(path);

				for (String file : this.data.getListFiles()) {
					this.formatFile(this.getDirIn().concat(File.separator).concat(file));
				}
			}
			this.data.clearListFiles();
			File f = new File(this.getDirJrn());
			f.delete();
		}
	}

        /**
	 * @param path
	 *
	 * @return
	 */
	public String searchJRN(String path) {
		List<String> list = FileUtils.readDirectory(path, Texto.JRN_EXT);
		String namefile = null;

		if (list.size() > 1) {
			logger.warn("SE HA ENCONTRADO MAS DE UN ARCHIVO JRN EN EL DIRECTORIO ESPEFICICADO {}", path);
		} else {
			for (String f : list) {
				namefile = path.concat(File.separator).concat(f);
				logger.info("ARCHIVO JRN ENCONTRADO {}", namefile);
			}
		}

		return namefile;
	}
        
        /**
	 * @param in
	 *
	 * @return
	 *
	 * @throws IOException
	 */
	public String convertToXML(String in) throws IOException {
		BufferedWriter out = null;
		String path = "";
		try {
			FastFileTextReader ffr = new FastFileTextReader(in, FastFileTextReader.UTF_8, 1024 * 40);
			path = this.getDirOut().concat(File.separator).concat("Amicar.xml");
			out = new BufferedWriter(new FileWriter(path));

			String line;
			while ((line = ffr.readLine()) != null) {
				if (!line.contains("<!DOCTYPE")) {
					out.write(line.concat("\r\n"));
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage() + " {}", e);
		} finally {
			out.close();
		}

		return path;
	}

        /**
	 * @param in
	 *
	 * @throws IOException
	 */
	public void formatFile(String in) throws IOException {
		FastFileTextReader ffr = new FastFileTextReader(in, FastFileTextReader.ISO_8859_1, 1024 * 40);
		String line;

		while ((line = ffr.readLine()) != null) {
			this.isTitle(line);
			this.isDocId(line);
			this.isUrlClick(line);
			this.isUrlRead(line);
		}

		int template = this.getTemplate();
		if (template != 0) {
			if (!this.generateBody(in, template)) {
				logger.error("NO SE LOGRÓ GENERAR EL ARCHIVO: {}", in);
			}
		}

		ffr.close();

	}


	private Boolean isTitle(String line) {
		String l = line.trim();
		if (l.startsWith(Texto.TITLEHTML) && l.endsWith(Texto.TITLEHTML_FINAL)) {
			String a = l.replace(Texto.TITLEHTML, "").replace(Texto.TITLEHTML_FINAL, "").trim();
			this.data.setTitle(a);
			return true;
		}
		return false;
	}

	/**
	 * @param line
	 *
	 * @return
	 */
	public Boolean isDocId(String line) {
		String l = line.trim();
		if (l.startsWith(Texto.COMMENT) && l.endsWith(Texto.COMMENT_FINAL)) {
			String a = l.replace(Texto.COMMENT, "").replace(Texto.COMMENT_FINAL, "").trim();
			if (a.length() == 32) {
				this.data.setDocInstanceId(a);
				return true;
			}
		}
		return false;
	}

	/**
	 * @param line
	 *
	 * @return
	 */
	public Boolean isUrlClick(String line) {
		if (line.trim().toLowerCase().contains(Texto.LINK) && line.trim().contains(Texto.F_LINK)) {
			this.data.setUrlClick(this.getUrlButtonClick(line));
			return true;
		}

		return false;
	}

	/**
	 * @param line
	 *
	 * @return
	 */
	public Boolean isUrlRead(String line) {
		if (line.trim().toLowerCase().contains(Texto.LINK) && line.trim().contains(Texto.F_IMAGE)) {
			this.data.setUrlRead(this.getUrlReadServlet(line));
			return true;
		}
		return false;
	}

	/**
	 * @return
	 */
	public int getTemplate() {
		int template = 0;
		DB d = new DB();
		try {
			List<String> data = this.getJrnData();
			String rut = data.get(1);
			String email = data.get(2);
			System.out.println(rut + " - " + email);
			Clientesdiario result = d.buscarCliente(rut, email);

			if (result != null) {
				template = result.getIdBody();
			}
		} catch (Exception e) {
			logger.error(e.getMessage() + " {}", e);
		}

		return template;
	}

	/**
	 * @param in
	 * @param template
	 *
	 * @return
	 *
	 * @throws IOException
	 */
	public Boolean generateBody(String in, int template) throws IOException {
		String fileName = this.getDirTpl().concat(File.separator).concat(Texto.PREFIX_TPL).concat(String.valueOf(template)).concat(Texto.HTML_EXT);
		List<String> tpl = new ArrayList<String>();
		try {
			FastFileTextReader ffr = new FastFileTextReader(fileName, FastFileTextReader.ISO_8859_1, 1024 * 40);
			String line;

			while ((line = ffr.readLine()) != null) {
				if (line.trim().contains(Texto.DOCINSTID)) {
					String l = this.addDodId(line.trim());
					tpl.add(l);
				} else if (line.trim().contains(Texto.TITLE)) {
					String l = this.addTitle(line.trim());
					tpl.add(l);
				} else if (line.trim().contains(Texto.BTN_CLICK)) {
					String l = this.addBtnClick(line.trim(), template);
					tpl.add(l);
				} else if (line.trim().contains(Texto.BTN_DESINSCRITO)) {
					String l = this.addBtnDesinscrito(line.trim());
					tpl.add(l);
				} else if (line.trim().contains(Texto.BTN_LECTURAS)) {
					String l = this.addBtnLecturas(line.trim());
					tpl.add(l);
				} else {
					tpl.add(line.trim());
				}
			}

			logger.info("PROCESANDO PLANTILLA PARA ARCHIVO: {}", fileName);

			ffr.close();
		} catch (IOException e) {
			logger.warn("NO SE ENCUENTRA ARCHIVO: {}", fileName);
			logger.error(e.getMessage() + " {}", e);
		}

		return FileUtils.writeFile(in, this.getDirOut(), tpl);
	}

        /**
         * 
         * @param line
         * @return 
         */
	private String getUrlButtonClick(String line) {
		String[] array = line.split(Texto.F_LINK);
		String[] array2 = array[0].split("title=\"");

		return array2[1].split("\">")[0];
	}

	/**
	 * @param line
	 *
	 * @return
	 */
	private String getUrlReadServlet(String line) {
		String[] array = line.split(Texto.SERVLET_1);
		String[] array2 = null;
		for (int i = 0; i < array.length; i++) {
			if (array[i].contains(Texto.F_IMAGE)) {
				array2 = array[i].split(Texto.SERVLET_2);
			}
		}
		return array2[0];
	}

	/**
	 * @return
	 */
	public List<String> getJrnData() {
		List<String> data = new ArrayList<String>();
		Content content;

		SAXBuilder builder = new SAXBuilder();
		File xmlFile = new File(this.getDirJrn());
		
		try {
			Document document = (Document)builder.build(xmlFile);
			Element rootNode = document.getRootElement();
			List properties = rootNode.getChildren("jobdata");
			Element node1 = (Element)properties.get(0);
			for (int i = 0; i < node1.getContent().size(); i++) {
				content = node1.getContent(i);
				if (content.toString().contains("<datetime") || content.toString().contains("<54")) {
					data.add(content.getValue());
					break;
				}
			}
			List list = rootNode.getChildren("document");
			for (int i = 0; i < list.size(); i++) {
				Element node = (Element)list.get(i);
				String doc = node.getAttribute("docInstanceID").getValue();
				if (doc.equalsIgnoreCase(this.data.getDocInstanceId())) {
					for (int j = 0; j < node.getContent().size(); j++) {
 						content = node.getContent(j);
   						if (content.toString().contains("DDSDocValue") || content.toString().contains("AccNo")) {
							data.add(content.getValue());
						}
					}
					break;
				}
			}
		} catch (JDOMException e) {
			logger.error(e.getMessage() + " {}", e);
		} catch (IOException e) {
			logger.error(e.getMessage() + " {}", e);
		}

		return data;
	}

        /**
         * 
         * @param line
         * @return 
         */
	private String addDodId(String line) {
		String btn = line.replace(Texto.DOCINSTID, this.data.getDocInstanceId());
		return btn;
	}
        
        /**
         * 
         * @param line
         * @return 
         */
	private String addTitle(String line) {
		String btn = line.replace(Texto.TITLE, this.data.getTitle());
		return btn;
	}

	/**
	 * @param line
	 * @param tpl
	 *
	 * @return
	 */
	public String addBtnClick(String line, int tpl) {
		String url = this.data.getUrlClick();

		if (!this.data.getUrlClick().contains("campana")) {
			String id = Tools.encryptInputs(String.valueOf(tpl));
			url = url.concat("&amp;campana=").concat(id);
			this.data.setUrlClick(url);
		}

		String btn = line.replace(Texto.BTN_CLICK, url);
		return btn;
	}

	/**
	 * @param line
	 *
	 * @return
	 */
	public String addBtnDesinscrito(String line) {
		String site = Configuracion.getInstance().getInitParameter("dominiodesinscrito");
		String[] url = this.data.getUrlClick().trim().split("\\?");
		String params = url[1];

		if (!site.trim().endsWith("?")) {
			site = site.trim().concat("?");
		}

		if (!params.contains("action")) {
			String msg = Tools.encryptInputs(Texto.DESINS_KEY);
			params = params.concat("&amp;action=").concat(msg);
		}

		site = site.concat(params);

		String btn = line.replace(Texto.BTN_DESINSCRITO, site);
                
		return btn;
	}

        /**
         * 
         * @param line
         * @return 
         */
	private String addBtnLecturas(String line) {
		String btn = line.replace(Texto.BTN_LECTURAS, this.data.getUrlRead());
		return btn;
	}

}
