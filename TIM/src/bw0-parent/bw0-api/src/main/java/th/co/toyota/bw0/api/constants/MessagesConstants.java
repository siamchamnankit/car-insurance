/******************************************************
 * Program History
 * 
 * Project Name	            :  TIM : 
 * Client Name				:  TDEM
 * Package Name             :  th.co.toyota.bw0.batch.constants
 * Program ID 	            :  MessagesConstants.java
 * Program Description	    :  Messages Constants
 * Environment	 	        ;  Java 7
 * Author					:  Thanapon T.
 * Version					:  1.0
 * Creation Date            :  August 9, 2017
 *
 * Modification History	    :
 * Version	   Date		   Person Name		Chng Req No		Remarks
 *
 * Copyright(C) 2015-TOYOTA Motor Asia Pacific. All Rights Reserved.             
 ********************************************************/
package th.co.toyota.bw0.api.constants;

public final class MessagesConstants {
	
	private MessagesConstants() {
		throw new IllegalStateException("Message Constants class");
	}
	
	 //Information of Web Application
	  
	 //Error of Web Application
	public static final String A_ERROR_TEMPLATE_DOES_NOT_EXIST = "MSTD0001AERR";
	public static final String A_ERROR_NOT_REGISTER = "MBW00015AERR";
	public static final String A_ERROR_MUST_LESSTHAN_OR_EQUAL = "MSTD0025AERR";
	
	 //Information of Web Application
	 
	 //Warning of  Web Application
	 
	 //Error of Batch
	public static final String B_ERROR_FILE_NOT_EXISTS ="MBW00014BERR";
	public static final String B_ERROR_UNDEFINED_ERROR = "MBW00029BERR";
	public static final String B_ERROR_ON_WRITING_DATA_INTO_FILE = "MBW00031BERR";
	public static final String B_ERROR_DATA_NOT_FOUND_FROM = "MBW00030BERR";
	 
	 //Warning of Batch

		 
}
