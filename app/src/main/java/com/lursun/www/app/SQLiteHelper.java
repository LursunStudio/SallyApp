package com.lursun.www.app;

import android.content.Context;
import  android.database.sqlite.*;
import  android.database.sqlite.SQLiteDatabase.*;
/**
 * Created by lursun on 2017/8/29.
 */

public class SQLiteHelper extends SQLiteOpenHelper{
    // 資料庫名稱
    public static final String DATABASE_NAME = "mydata.db";
    // 資料庫版本，資料結構改變的時候要更改這個數字，通常是加一
    public static final int VERSION = 1;
    // 資料庫物件，固定的欄位變數
    private static SQLiteDatabase database;

    // 建構子，在一般的應用都不需要修改
    public SQLiteHelper(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public static SQLiteDatabase getDatabase(Context context) {
        if (database == null || !database.isOpen()) {
            database = new SQLiteHelper(context, DATABASE_NAME,
                    null, VERSION).getWritableDatabase();
        }

        return database;
    }
    public static void regUser(String name,String account,String passwd){
        String sql="Insert Into Usertable (name,account,passwd) Values ('"+name+"', '"+account+"','"+passwd+"' )";
        database.execSQL(sql);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="Create Table Usertable " +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name Text ,"+
                "account Text ,"+
                "passwd Text ,"+
                "address Text )";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // 刪除原有的表格
        // 待會再回來完成它
        db.execSQL("DROP TABLE IF EXISTS Usertable" );
        // 呼叫onCreate建立新版的表格
        onCreate(db);
    }
}
