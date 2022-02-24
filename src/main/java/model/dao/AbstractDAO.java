package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public abstract class AbstractDAO {
	protected Connect1 connectDB;
	protected Statement state;
	protected PreparedStatement pstate;
	protected Connection conn;
	protected ResultSet result;

}
