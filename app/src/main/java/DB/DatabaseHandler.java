package DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import DAO.ItemDAO;
import DAO.UsersDAO;
import Model.Users;

/**
 * Created by Brezeler on 06/05/2016.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "database.db";
    private static final int DB_VERSION = 1;

    public DatabaseHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ItemDAO.CREATE_TABLE);
        db.execSQL(UsersDAO.CREATE_TABLE2);
        db.execSQL(UsersDAO.CREATE_TABLE);
     ;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
