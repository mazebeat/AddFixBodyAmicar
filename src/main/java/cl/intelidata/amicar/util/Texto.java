package cl.intelidata.amicar.util;

/**
 * @author Maze
 */
public interface Texto {

	/**
	 * HTML VALUES
	 */
	public static final String HTML_EXT        = ".html";
	public static final String HEAD            = "<head";
	public static final String HEAD_FINAL      = "</head>";
	public static final String TITLEHTML       = "<title>";
	public static final String TITLEHTML_FINAL = "</title>";
	public static final String BODY            = "<body";
	public static final String BODY_FINAL      = "</body>";
	public static final String HTML            = "<html>";
	public static final String HTML_FINAL      = "</html>";
	public static final String LINK            = "<a href=";
	public static final String LINK_FINAL      = "title=";

	/**
	 * JRN VALUES
	 */
	public static final String JRN_EXT        = ".jrn";
	public static final String DATETIME       = "<datetime>";
	public static final String DOCUMENT       = "<document";
	public static final String DOCUMENT_FINAL = "</document>";
	public static final String DOCID          = "docInstanceID=";
	public static final String DOCVALUE       = "<DDSDocValue name=";
	public static final String CUSTDATA       = "<CustData>";
	public static final String CUSTDATA_FINAL = "</CustData>";
	public static final String ID             = "<AccNo>";
	public static final String ID_FINAL       = "</AccNo>";

	/**
	 * FIXES
	 */
	public static final String IMAGE          = "<img src=\"";
	public static final String IMAGE_FINAL    = "\">";
	public static final String SERVLET_1      = "title=\"";
	public static final String SERVLET_2      = "\">IMAGEN";
	public static final String F_LINK         = "LINK";
	public static final String F_IMAGE        = "IMAGEN";
	public static final String F_BUTTON_COTIZ = "<a id=\"buttonLink\"";
	public static final String F_BUTTON_DESIN = "<span id=\"buttonDesinscrito\"";

	/**
	 * OTHERS
	 */
	public static final String COMMENT       = "<!--";
	public static final String COMMENT_FINAL = "-->";
	public static final String PREFIX_TPL    = "cliente_";
	public static final String DESINS_KEY    = "removeSends";

	/**
	 * LOG4J
	 */
	public final static String LOG_PROPERTIES_FILE = "resources/log4j.properties";

	/**
	 * MCrypt params Encrypt/Decrypt
	 */
	public static final String KEY = "amicarCotizantes";
	public static final String IV  = "a1m2i3c4a5r6C7o8";

	/**
	 * NEWS FIXES
	 */
	public static final String TITLE           = "[TITLE]";
	public static final String DOCINSTID       = "[DOCID]";
	public static final String BTN_CLICK       = "[BTN_CLICK]";
	public static final String BTN_DESINSCRITO = "[BTN_DESINSCRITO]";
	public static final String BTN_LECTURAS    = "[BTN_LECTURAS]";
}
