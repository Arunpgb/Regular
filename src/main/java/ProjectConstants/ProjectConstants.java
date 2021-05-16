package ProjectConstants;

public final class ProjectConstants {

	private ProjectConstants() {
	}

	private static final String RESOURCESPATH = System.getProperty("user.dir") + "/src/test/resources";
	private final static String EXCELPATH = RESOURCESPATH + "/excel/TestManageFile.xlsx";
	private static final String LOG4JCONFIGFILEPATH = RESOURCESPATH + "/Config/log4j.properties";
	private static final String BROWSERCONFIG = RESOURCESPATH + "/Config/BaseUtility.properties";
	private static final String RUNMANGERSHEET = "RUNMANAGER";
	private static final String DATASHEET = "DATA";

	public static String getExcelpath() {
		return EXCELPATH;
	}

	public static String getLog4jconfigfilepath() {
		return LOG4JCONFIGFILEPATH;
	}

	public static String getBrowserconfig() {
		return BROWSERCONFIG;
	}

	public static String getRunmangersheet() {
		return RUNMANGERSHEET;
	}

	public static String getDatasheet() {
		return DATASHEET;
	}

}
