package kh.edu.rupp.drawerlayout.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import org.w3c.dom.Document;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        Log.d("me", "DB is created");

        //Insert data to DB by Manual
        Article a1 = new Article("OOAD lesson",6, "");
        inserDocument(a1, sqLiteDatabase);
        Article a2 = new Article("ch. Introduction",1,"");
        inserDocument(a2, sqLiteDatabase);
        Article a3 = new Article("song",4,"");
        inserDocument(a2, sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {


    }
   public boolean inserDocument( Article article, SQLiteDatabase db)
    {
        ContentValues row = new ContentValues();
        row.put("_title", article.getTitle());
        row.put("_thumbnail_url", article.getThumbnailUrl());
        long newId = db.insert("tblDoument", null, row);
        return (newId > -1);
    }
    //just write function to get date
    private String getDate()
    {
        long time = System.currentTimeMillis();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date(time);
        return dateFormat.format(date);
    }
    public Article[] getAllArticles()
    {
        SQLiteDatabase db = getReadableDatabase();
        String[] columns = {"_id", "_title", "_thumbnail_url", "size"};
        Cursor cursor = db.query("tblArticle", columns, null, null,null, null,"_id decending");
        Article[] articles = new Article[cursor.getCount()];
        int i = 0;
        while (cursor.moveToNext())
        {
            //int id = cursor.getInt(0);//if your constructor is integer
            String title = cursor.getString(0);
            int size = cursor.getInt(1);
            String imagethumnail = cursor.getString(2);
            Article article = new Article(title,size,imagethumnail);
            articles[i] = article;
            i++;
        }
        return getAllArticles();
    }
}
