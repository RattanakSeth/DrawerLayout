package kh.edu.rupp.drawerlayout.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import org.w3c.dom.Document;

import kh.edu.rupp.drawerlayout.datamodel.Article;

/**
 * Created by rattanak on 5/2/17.
 */

public class dbManager extends SQLiteOpenHelper {

    private final String DB_NAME = "get_thumbnail";

    public dbManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

//    public DbManager(Context context)
//    {
//        super(context, "get_thumbnail", null, 1);
//    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //we create table, put_ donot overlap keyword
        String tblDpcomentsql = "create table tbl tblDocoment + (_id integer primary key autoincrement, _title text, _thumnail_url text, _size integer)";
        sqLiteDatabase.execSQL(tblDpcomentsql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {


    }
   public boolean inserDocument( Article article)
    {
        ContentValues row = new ContentValues();
        row.put("_title", article.getTitle());
        row.put("_thumbnail_url", article.getThumbnailUrl());
        SQLiteDatabase db = getReadableDatabase();
        long newId = db.insert("tblDoument", null, row);
        return (newId > -1);
    }

    public Article[] getAllArticles()
    {
        SQLiteDatabase db = getReadableDatabase();
        String[] columns = {"_id", "_title", "_thumbnail_url", "size"};
        Cursor cursor = db.query("tblArticle", columns, null, null,null, null,"_id decending");

        while (cursor.moveToNext())
        {
            int id = cursor.getInt(0);//if your constructor is integer
            String title = cursor.getString(1);


        }
        return getAllArticles();
    }
}
