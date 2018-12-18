package th.co.toyota.bw0.api.constants;

public final class AppConstants {
	
	private AppConstants() {
		throw new IllegalStateException("Application Constants class");
	}
	public static final String PWD_PROTECT_SHEET = "TDEM";

	public static final String DATE_STRING_SCREEN_FORMAT = "dd/MM/yyyy";
	public static final String DATE_TIME_STRING_FILENAME_FORMAT = "yyyyMMddHH24mmss";
//	public static final String DATE_TIME_FORMAT_UPDATEDT_KEY = "yyyyMMddHHmmss";
//	public static final String DATE_TIME_STRING_FILENAME_FORMAT_WITHOUT24 = "yyyyMMddHHmmss";
	public static final String DATE_TIME_STRING_FILENAME_FORMAT_WITHOUT24 = "yyyyMMddHHmmSSS";
	public static final String DATE_STRING_FORMAT_YYMMDD = "yyMMdd";
	public static final String DATE_STRING_FORMAT_YYYYMMDD = "yyyyMMdd";
	public static final String DATE_STRING_FORMAT_YYYYMM = "yyyyMM";
	public static final String DATE_STRING_FORMAT_YYYY = "yyyy";
	public static final String DATE_STRING_FORMAT_YYMM = "yyMM";
	public static final String DATE_STRING_FORMAT_MM = "MM";
	
	public static final String DATE_STRING_MONTH_YEAR_FULLNAME = "MMMM YYYY";
	public static final String DATE_STRING_MONTH_FULLNAME = "MMMM";
	public static final String DATE_STRING_FORMAT_DDMM = "ddMM";
	public static final String DATE_MONTH_YEAR = "MM/yyyy";
	public static final String DATE_SHOW_IN_SCREEN = "MMM-yy";
	public static final String DATE_SHOW_IN_SCREEN_MMM_YYYY = "MMM-yyyy";
	public static final String DATE_TIME_IN_SCREEN = "dd-MMM-yy HH24:mm:ss";
	public static final String DATE_SHOW_IN_REPORT = "dd-MMM-yyyy";
	public static final String DATE_SHOW_IN_DETAIL_REPORT = "dd-MMM-yy";
	public static final String DATE_FORMAT_DDMMMYYYY = "dd MMM yyyy";
	public static final String DATE_TIME_IN_REPORT = "dd MMM yyyy HH:MM";
	public static final String DATE_STRING_FORMAT_FROM_DOT_SYSTEM = "dd MMM yy";
	public static final String DATE_STRING_FORMAT_MMM = "MMM";
	public static final String DATE_STRING_FORMAT_YY = "yy";
	public static final String DATE_STRING_FORMAT_DDMMYY = "ddMMyy";
	public static final String DATE_STRING_FORMAT_DDMMYYYY = "ddMMyyyy";
	public static final String TIME_IN_SCREEN = "HH:mm:ss";
	public static final String TIME_IN_REPORT = "HH:mm:ss";
	public static final String DATE_TIME_IN_SCREEN_NOT_24 = "dd-MMM-yy, HH:mm:ss";
	
	public static final String DATE_ORACLE_FORMAT_DDMMYYYY = "DD/MM/YYYY";
	public static final String DATE_ORACLE_FORMAT_DDMONYYYY = "DD Mon YYYY";
	public static final String DATE_ORACLE_FORMAT_DATETIME_SQL = "yyyy/mm/dd hh24:mi:ss";
	public static final String DATE_ORACLE_FORMAT_DATETIME_JAVA_CONVERT = "yyyy/MM/dd HH:mm:ss";
//	public static final String DATE_ORACLE_FORMAT_UPDATEDT_DATETIME = "YYYYMMDDHH24MISS";
//	public static final String DATE_ORACLE_FORMAT_GETSUDO_MONTH = "Mon-YY";
	
	public static final String BLANK = "";
	public static final String BLANK_SPACE = " ";

    public static final int LEFT_PAD = 0x00;
    public static final int RIGHT_PAD = 0x01;
    
    public static final int SUCCESS = 0;
    public static final int ERROR = 1;
    public static final int WARNING = 2;
    
    public static final String ALIGNMENT_LEFT = "L";
    public static final String ALIGNMENT_RIGHT = "R";
    
	public static final String SEQ_CODE_APP_ID = "APP_ID";
	
	public static final String BATCH_ID = "BST33020";
	
	public static final int MAX_LENGTH_UPLOAD_FILENAME = 255;
	
	public static final String SYS_CD_STAR = "*";	
	public static final String SYS_PERCENT = "%";

	public static final String CHECKBOX_SEPERATER = "|";
	public static final String UNDERSCORE = "_";
	public static final String COLON = ":";
	
	public static final String SORT_METHOD_ASCENDING = "ASC";
	public static final String SORT_METHOD_DESCENDING = "DESC";

	public static final String SYS_CD_TO = "TO";
	public static final String SYS_CD_CC = "CC";
	public static final String SYS_CD_SUBJECT = "SUBJECT";
	public static final String SYS_CD_SENDER = "SENDER";

	public static final String YES_STR = "Y";
	public static final String NO_STR = "N";
	public static final String YES_INFO = "YES";
	public static final String NO_INFO = "NO";
	
	public static final String FILE_FORMAT_EXCEL_XLS = "XLS";
	public static final String FILE_FORMAT_EXCEL_XLSX = "XLSX";
	
    public static final String XLS_REPORT_EXTENTION = ".xls";
    public static final String XLSX_REPORT_EXTENTION = ".xlsx";
    
	public static final String BATCH_CHARACTOR_REPLACE_BLANK = "^##^";
	
	public static final String SYS_CATEGORY_MASTER = "MASTER";
	public static final String SYS_CATEGORY_COMMON = "COMMON";
	
	public static final String SYSTEM_NAME = "SYSTEM";
	
	public static final char ACTIVE = 'Y';
	public static final char INACTIVE = 'N';

	public static final String SYS_CATEGORY_REPORT = "REPORT";
	public static final String SYS_CATEGORY_EMAIL = "EMAIL";
	
	public static final String REPLACE_NEW_FILE_NAME_OF_UPLOAD = "{REPLACE_NEW_FILE_NAME_OF_UPLOAD}";
	
	public static final String ACTION_ADD = "add";
	public static final String ACTION_EDIT = "edit";
	public static final String ACTION_UPLOAD = "upload";
	public static final String ACTION_SEARCH = "search";
	public static final String ACTION_SAVE_ADD = "save_add";
	public static final String ACTION_SAVE_EDIT = "save_edit";
	public static final String ACTION_DELETE = "delete";
	public static final String ACTION_SUBMIT = "submit";
	public static final String ACTION_DOWNLOAD = "download";
	
	public static final String MV_USER_COMPANY = "userCompany";
	public static final String MV_USER = "user";
	public static final String MV_FORM = "form";
	public static final String MV_PAYLOAD = "payload";
	
	public static final String TABLE_TB_M_SYSTEM = "TB_M_SYSTEM";
	
	public static final String SYS_CATEGORY_TIM = "TIM";
}
