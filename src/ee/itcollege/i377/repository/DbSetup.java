package ee.itcollege.i377.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class DbSetup {
	
	private static Logger log = Logger.getLogger(DbSetup.class);
	
	@PostConstruct
	public void createTables() throws ClassNotFoundException, SQLException {
		log.debug("Creating tables");
		Connection conn = null;
		try {
		    conn = createConnection();
		    if(isDatabaseEmpty(conn)) {
		    	createGuardTable(conn);
		    }
		}
		catch(Exception e) {
			log.error("Error creating database",e);
		}
		finally {
			if(conn != null) {
				conn.close();
			}
		}
		
	}

	private Connection createConnection() throws ClassNotFoundException, SQLException {
		Class.forName("org.hsqldb.jdbcDriver");
		return DriverManager.getConnection("jdbc:hsqldb:i377stack");
	}

	private void createGuardTable(Connection conn) throws SQLException {
		log.debug("Creating guard table");
		Statement s = conn.createStatement();
		s.execute("CREATE TABLE GUARD (id IDENTITY, name VARCHAR(50), age INT)");
	}
	
	private boolean isDatabaseEmpty(Connection conn) throws SQLException {
		log.debug("Checking if Database has Guard table");
		Statement s = conn.createStatement();
		ResultSet result = s.executeQuery("SELECT count(*) FROM information_schema.system_tables WHERE table_name = 'GUARD';");
		result.next();
		int tableCount = result.getInt(1);
		log.debug("Guard table count: "+tableCount);
		return tableCount == 0;
	}

}
