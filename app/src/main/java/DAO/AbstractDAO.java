package DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import DB.DatabaseHandler;

/**
 * Created by Brezeler on 06/05/2016.
 */
public class AbstractDAO<T> {

    private DatabaseHandler dbHandler;
    private SQLiteDatabase sqliteDb;


    public AbstractDAO(Context context){
        this.dbHandler = new DatabaseHandler(context);
    }

    public SQLiteDatabase getSqliteDb() {
        return sqliteDb;
    }


    public SQLiteDatabase open(){
        sqliteDb = this.dbHandler.getWritableDatabase();
        return sqliteDb;
    }

    public void close(){
        sqliteDb.close();
    }


}
