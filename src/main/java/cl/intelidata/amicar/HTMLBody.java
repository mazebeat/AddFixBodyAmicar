package cl.intelidata.amicar;

import cl.intelidata.amicar.conf.Configuracion;
import static cl.intelidata.amicar.conf.Configuracion.logger;
import cl.intelidata.amicar.jpa.Clientesdiario;
import cl.intelidata.amicar.util.FileUtils;
import cl.intelidata.amicar.util.Text;
import cl.intelidata.amicar.util.Tools;
import org.jam.superutils.FastFileTextReader;
import org.jdom.Content;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jdom.JDOMException;

public class HTMLBody {

    private String dirIn;
    private String dirOut;
    private String dirJrn;
    private String dirTpl;
    private String docInstanceId;
    private String urlRead;
    private String urlClick;
    private ArrayList<String> listFiles;

    public HTMLBody(String dirIn, String dirOut, String dirJrn, String dirTpl) {
        this.dirIn = dirIn;
        this.dirOut = dirOut;
        this.dirJrn = dirJrn;
        this.dirTpl = dirTpl;
        this.docInstanceId = "";
        this.urlRead = "";
        this.urlClick = "";
        this.listFiles = new ArrayList<String>();
    }

    public String getDirIn() {
        return dirIn;
    }

    public void setDirIn(String dirIn) {
        this.dirIn = dirIn;
    }

    public String getDirOut() {
        return dirOut;
    }

    public void setDirOut(String dirOut) {
        this.dirOut = dirOut;
    }

    public String getDirJrn() {
        return dirJrn;
    }

    public void setDirJrn(String dirJrn) {
        this.dirJrn = dirJrn;
    }

    public String getDirTpl() {
        return dirTpl;
    }

    public void setDirTpl(String dirTpl) {
        this.dirTpl = dirTpl;
    }

    public ArrayList<String> getListFiles() {
        return listFiles;
    }

    public void setListFiles(ArrayList<String> listFiles) {
        this.listFiles = listFiles;
    }

    public void clearListFiles() {
        if (!this.getListFiles().isEmpty()) {
            this.getListFiles().clear();
        }
    }

    public void addListFiles(String value) {
        if (!value.isEmpty()) {
            this.getListFiles().add(value.trim());
        }
    }

    public String getDocInstanceId() {
        return docInstanceId;
    }

    public void setDocInstanceId(String docInstanceId) {
        this.docInstanceId = docInstanceId;
    }

    public String getUrlRead() {
        return urlRead;
    }

    public void setUrlRead(String urlRead) {
        this.urlRead = urlRead;
    }

    public String getUrlClick() {
        return urlClick;
    }

    public void setUrlClick(String urlClick) {
        this.urlClick = urlClick;
    }

    public void process() throws IOException {
        List<String> list = FileUtils.readDirectory(this.getDirIn(), Text.HTML_EXT);

        if (list.size() > 0) {
            this.setListFiles(new ArrayList<String>(list));
            String jrn = this.searchJRN(this.getDirJrn());

            if (jrn != null) {
                String path = this.convertToXML(jrn);
                File exist = new File(path);

                if (exist.exists()) {
                    this.setDirJrn(path);

                    for (String file : this.getListFiles()) {
                        this.formatFile(this.getDirIn().concat(File.separator).concat(file));
                    }
                }
                this.clearListFiles();
                File f = new File(this.getDirJrn());
                f.delete();
            }
        } else {
            System.out.println("NO HAY ARCHIVOS EN EL DIRECTORIO ESPECIFICADO");
        }
    }

    public void formatFile(String in) throws IOException {
        FastFileTextReader ffr = new FastFileTextReader(in, FastFileTextReader.UTF_8, 1024 * 40);
        String line;

        while ((line = ffr.readLine()) != null) {
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

    public Boolean isDocId(String line) {
        String l = line.trim();
        if (l.startsWith(Text.COMMENT) && l.endsWith(Text.COMMENT_FINAL)) {
            String a = l.replace(Text.COMMENT, "").replace(Text.COMMENT_FINAL, "").trim();
            int c = a.length();
            if (c == 32) {
                this.setDocInstanceId(a);
                return true;
            }
        }
        return false;
    }

    public Boolean isUrlClick(String line) {
        if (line.trim().toLowerCase().contains(Text.LINK) && line.trim().contains(Text.F_LINK)) {
            this.setUrlClick(this.getUrlButtonClick(line));
            return true;
        }

        return false;
    }

    public Boolean isUrlRead(String line) {
        if (line.trim().toLowerCase().contains(Text.LINK) && line.trim().contains(Text.F_IMAGE)) {
            this.setUrlRead(this.getUrlReadServlet(line));
            return true;
        }
        return false;
    }

    private String getUrlReadServlet(String line) {
        String[] array = line.split(Text.SERVLET_1);
        String[] array2 = null;
        for (int i = 0; i < array.length; i++) {
            if (array[i].contains(Text.F_IMAGE)) {
                array2 = array[i].split(Text.SERVLET_2);
            }
        }
        return array2[0];
    }

    private String getUrlButtonClick(String line) {
        String[] array = line.split(Text.F_LINK);
        String[] array2 = array[0].split("title=\"");

        return array2[1].split("\">")[0];
    }

    public int getTemplate() {
        int template = 0;
        DB d = new DB();
        try {
            List<String> data = this.getJrnData();

            Clientesdiario result = d.buscarCliente(data.get(1), data.get(2));

            if (result != null) {
                template = result.getIdBody();
            }
        } catch (Exception e) {
            logger.error(e.getMessage() + " {}", e);
        }

        return template;
    }

    public List<String> getJrnData() {
        List<String> data = new ArrayList<String>();
        Content content;

        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File(this.getDirJrn());
        try {
            Document document = (Document) builder.build(xmlFile);
            Element rootNode = document.getRootElement();
            List properties = rootNode.getChildren("jobdata");
            Element node1 = (Element) properties.get(0);
            for (int i = 0; i < node1.getContent().size(); i++) {
                content = node1.getContent(i);
                if (content.toString().contains("<datetime") || content.toString().contains("<54")) {
                    data.add(content.getValue());
                    break;
                }
            }
            List list = rootNode.getChildren("document");
            for (int i = 0; i < list.size(); i++) {
                Element node = (Element) list.get(i);
                String doc = node.getAttribute("docInstanceID").getValue();
                if (doc.equalsIgnoreCase(this.getDocInstanceId())) {
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

    public Boolean generateBody(String in, int template) throws IOException {
        FastFileTextReader ffr = new FastFileTextReader(in, FastFileTextReader.UTF_8, 1024 * 40);
        List<String> tpl = new ArrayList<String>();
        String line;
        while ((line = ffr.readLine()) != null) {
            if (line.trim().toLowerCase().contains(Text.LINK) && line.trim().contains(Text.F_LINK)) {
                //				tpl.add("");
            } else if (line.trim().toLowerCase().contains(Text.LINK) && line.trim().contains(Text.F_IMAGE)) {
                tpl.add(this.addReadServlet());
            } else if (line.startsWith(Text.BODY)) {
                List<String> list = this.getBodyContent(template);
                if (list.size() > 0) {
                    tpl.addAll(list);
                } else {
                    logger.warn("NO SE GENERO BODY PARA EL ARCHIVO: {}", in);
                }
            } else {
                tpl.add(line);
            }
        }

        ffr.close();

        return FileUtils.writeFile(in, this.getDirOut(), tpl);
    }

    public String addButton(String line, int tpl) {
        String[] btn = line.split("#");

        if (!this.getUrlClick().contains("campana")) {
            String id = Tools.encryptInputs(String.valueOf(tpl));
            this.setUrlClick(this.getUrlClick().concat("&campana=").concat(id));
        }

        String b = btn[0].concat(this.getUrlClick()).concat(btn[1]);

        return b;
    }

    public String addButtonDesin(String line) {
        String site = Configuracion.getInstance().getInitParameter("dominioDesinscrito");
        String[] url = this.getUrlClick().trim().split("\\?");
        String params = url[1];
        String[] btn = line.split("#");

        if (!site.trim().endsWith("?")) {
            site = site.trim().concat("?");
        }

        if (!params.contains("action")) {
            String msg = Tools.encryptInputs("removeSends");
            params = params.concat("&action=").concat(msg);
        }

        site = site.concat(params);

        String b = btn[0].concat(site).concat(btn[1]);

        return b;
    }

    public String addReadServlet() {
        return Text.IMAGE + this.getUrlRead() + Text.IMAGE_FINAL;
    }

    public List<String> getBodyContent(int template) throws IOException {
        String fileName = this.getDirTpl().concat(File.separator).concat(Text.PREFIX_TPL).concat(String.valueOf(template)).concat(Text.HTML_EXT);
        List<String> tpl = new ArrayList<String>();
        try {
            FastFileTextReader ffr = new FastFileTextReader(fileName, FastFileTextReader.UTF_8, 1024 * 40);
            String line;

            while ((line = ffr.readLine()) != null) {
                if (line.trim().startsWith(Text.F_BUTTON_COTIZ)) {
                    String l = this.addButton(line.trim(), template);
                    tpl.add(l);
                } else if (line.trim().startsWith(Text.F_BUTTON_DESIN)) {
                    String l = this.addButtonDesin(line.trim());
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

        return tpl;
    }

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

    public String searchJRN(String path) {
        List<String> list = FileUtils.readDirectory(path, Text.JRN_EXT);
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

}
