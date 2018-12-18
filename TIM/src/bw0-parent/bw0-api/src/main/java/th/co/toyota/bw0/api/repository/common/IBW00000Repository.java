package th.co.toyota.bw0.api.repository.common;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;

public interface IBW00000Repository {
	public HashMap<String,Object> getTableMeataData(String tableName) throws Exception;
	public int getRowPerPage(String screenId);
	public Connection getConnection();
	public Object executeQuery(Connection conn, String sql, int totalSelectCol) throws Exception;
	public int getTotalActiveRecordSize(Connection conn, StringBuilder sql, List<Object> parameter) throws Exception;
	public HashMap<String, String> getUserInfoForTestOnFTH(String ipAddress);
}
