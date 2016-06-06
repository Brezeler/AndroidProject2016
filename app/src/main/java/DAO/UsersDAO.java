package DAO;

import android.content.ContentValues;
import android.content.Context;

import Model.Users;

/**
 * Created by Brezeler on 06/06/2016.
 */
public class UsersDAO extends AbstractDAO <Users> {

    private static final String TABLE_NAME = "item";
    private static final String KEY_ID_USER = "id_user";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_NAME = "name";
    private static final String KEY_FIRSTNAME = "firstname";
    public static final String CREATE_TABLE = "CREATE TABLE "
            + TABLE_NAME + " ("
            + KEY_ID_USER + " TEXT, "
            + KEY_PASSWORD + " TEXT, "
            + KEY_NAME + " TEXT, "
            + KEY_FIRSTNAME + " TEXT); ";
    public static final String DROP_TABLE = "DROP TABLE IF EXISTS "
            + TABLE_NAME +";";

    public UsersDAO(Context context) {
        super(context);
    }

    public long add(Users item){
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_ID_USER, item.getEmail());
        contentValues.put(KEY_PASSWORD, item.getPassword());
        contentValues.put(KEY_NAME, item.getName());
        contentValues.put(KEY_FIRSTNAME, item.getFirstname());

        long i = this.getSqliteDb().insert(TABLE_NAME, null, contentValues);
        return i;
    }



}
