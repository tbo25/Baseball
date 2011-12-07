package app.baseball.pitching.Models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "SimpleData")
public class SimpleData {

	@DatabaseField(generatedId = true, columnName = "id")
	private int _id;

	@DatabaseField(columnName = "first_name")
	private String _firstName;
	
	@DatabaseField(columnName = "last_name")
	private String _lastName;
	
	public SimpleData() { }
	public SimpleData(String firstName, String lastName) {
		this._firstName = firstName;
		this._lastName = lastName;
	}
	
	@Override
	public String toString() {
		return String.format("[%s] %s, %s", this._id, this._lastName, this._firstName);
	}
}
