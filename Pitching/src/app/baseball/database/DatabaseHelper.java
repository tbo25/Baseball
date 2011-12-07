package app.baseball.database;

import java.sql.SQLException;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import app.baseball.pitching.Models.SimpleData;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

	private static final String DATABASE_NAME = "test.db";
	private static final int DATABASE_VERSION = 1;
	
	private Dao<SimpleData, Integer> _sdDao = null;
	public Dao<SimpleData, Integer> getSimpleDataDao() throws SQLException {
		if (this._sdDao == null)
			this._sdDao = getDao(SimpleData.class);
		return this._sdDao;
	}
	
	public DatabaseHelper(Context context) {
		super (context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
		try {
			Log.i(DatabaseHelper.class.getName(), "onCreate");
			
			TableUtils.createTable(connectionSource, SimpleData.class);
			
			Dao<SimpleData, Integer> dao = getSimpleDataDao();
			SimpleData sd = new SimpleData("Curtis", "Thibault");
			dao.create(sd);
			
			Log.i(DatabaseHelper.class.getName(), "Created test entry: Curtis Thibault");
			
		} catch (SQLException e) {
			Log.e(DatabaseHelper.class.getName(), "Can't create database", e);
			throw new RuntimeException(e);
		}
	}

	@Override
	public void close() {
		super.close();
		this._sdDao = null;
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
		try {
			Log.i(DatabaseHelper.class.getName(), "onUpgrade");
			TableUtils.dropTable(connectionSource, SimpleData.class, true);
			this.onCreate(db, connectionSource);
		} catch (SQLException e) {
			Log.e(DatabaseHelper.class.getName(), "Can't drop database", e);
			throw new RuntimeException(e);
		}
	}
}
