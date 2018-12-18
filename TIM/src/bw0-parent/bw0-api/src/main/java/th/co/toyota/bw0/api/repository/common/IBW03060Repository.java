package th.co.toyota.bw0.api.repository.common;

import java.sql.Connection;


public interface IBW03060Repository {

	public String findSystemMasterValue(Connection conn, String category, String subCategory, String code);
	
}
