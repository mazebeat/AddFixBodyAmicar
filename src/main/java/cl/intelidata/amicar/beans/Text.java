package cl.intelidata.amicar.beans;

/**
 * @author Maze
 */
public interface Text {

	// HTML VALUES
	public static final String HTML_EXT   = ".html";
	public static final String HEAD       = "<head";
	public static final String HEAD_FINAL = "</head>";
	public static final String BODY       = "<body";
	public static final String BODY_FINAL = "</body>";
	public static final String HTML       = "<html>";
	public static final String HTML_FINAL = "</html>";
	public static final String LINK       = "<a href=";
	public static final String LINK_FINAL = "title=";

	// JRN VALUES
	public static final String JRN_EXT        = ".jrn";
	public static final String DATETIME       = "<datetime>";
	public static final String DOCUMENT       = "<document";
	public static final String DOCUMENT_FINAL = "</document>";
	public static final String DOCID          = "docInstanceID=";
	public static final String DOCVALUE       = "<DDSDocValue name=";
	public static final String CUSTDATA       = "<CustData>";
	public static final String CUSTDATA_FINAL = "</CustData>";
	public static final String ID             = "<AccNo>";
	public static final String ID_FINAL       = "<AccNo>";

	// FIXES
	public static final String IMAGE       = "<img src=\"";
	public static final String IMAGE_FINAL = "\">";
	public static final String SERVLET_1   = "title=\"";
	public static final String SERVLET_2   = "\">IMAGEN";
	public static final String F_LINK      = "LINK";
	public static final String F_IMAGE     = "IMAGEN";
	public static final String F_BUTTON    = "<a id=\"buttonLink\"";

	// OTHERS
	public static final String COMMENT       = "<!--";
	public static final String COMMENT_FINAL = "-->";
	public static final String PREFIX_TPL    = "cliente_";

	//	LOG4J
	public final static String LOG_PROPERTIES_FILE = "resources/log4j.properties";
}
