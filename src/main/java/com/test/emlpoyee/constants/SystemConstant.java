package com.test.emlpoyee.constants;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class SystemConstant {

	public static class ErrorCode {

		private ErrorCode() {
		}

		public static final String GENERAL_ERROR = "99";
		public static final String INTERNAL_SERVER_ERROR = "500";

		}
	public static final String APPLICATION_EXCEPTION_DEFAULT = " undefined ApplicationException thrown";
	public static final Locale DEFAULT_LOCALE = Locale.US;
	public static enum ProjectParam {
		referenceNo, source, username, requestId, device, uuid
	}
	
	public static class ResponseCode {

		private ResponseCode() {
		}

		public static final String SUCCESS = "00";
		public static final String NOT_SUCCESS = "01";
		public static final String ERROR = "10";
		public static final String DATA_NOT_FOUND = "04";

		
		public static final String COM01 = "COM01";
		public static final String COM01_01 = "COM01_01";

		public static final String COM02 = "COM02";
		public static final String COM02_01 = "COM02_01";
		public static final String COM02_02 = "COM02_02";

		public static final String COM03 = "COM03";
		public static final String COM04 = "COM04";
		public static final String COM05 = "COM05";
		
		public static final String COM06 = "COM06";
		public static final String SUCCESS_DESCR = "success";
		public static final String NOT_SUCCESS_DESCR = "not success";
		public static final String ERROR_DESCR = "error";
		public static final String DATA_NOT_FOUND_DESCR = "Data Not Found";
		public static final String PLEASE_TRY_AGAIN = "Please Try Again";

		
		public static final Map<String, String> errorMessages = new HashMap<>();
		public static final String COM60 = "COM60";

		static {
			errorMessages.put(COM01, "Field {0} is mandatory");
			errorMessages.put(COM02, "Field {0} is not number");
			errorMessages.put(COM03, "Field {0} not valid date");
			errorMessages.put(COM04, "Field {0} not valid e-mail");
			errorMessages.put(COM05, "System error occurred");
		}

	}

}
