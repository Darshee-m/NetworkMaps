package com.example.networkmaps;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by User on 2/28/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

	private static final String TAG = "DatabaseHelper";

	private static final String TABLE_NAME = "data_table";
	private static final String COLUMN_ID = "ID";
	private static final String Lat = "lat";
	private static final String Signal ="signal";
	private static final String Lon="lon";

	public DatabaseHelper(Context context) {
		super(context, TABLE_NAME, null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String create_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + COLUMN_ID +
				"INTEGER PRIMARY KEY AUTOINCREMENT, " + Signal + "TEXT,"+Lat+"TEXT,"+Lon+"TEXT)";
		db.execSQL(create_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int i, int i1) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
		onCreate(db);
	}

	public boolean addData(String lat,String lon,String signal) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put(Lat, lat);
		contentValues.put(Lon, lon);
		contentValues.put(Signal, signal);
		Log.d(TAG, "addData: Adding to " + TABLE_NAME);

		long result = db.insert(TABLE_NAME, null, contentValues);

		//if date as inserted incorrectly it will return -1
		if (result == -1) {
			return false;
		} else {
			return true;
		}
	}




}
























