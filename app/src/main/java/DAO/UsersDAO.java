package DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Model.Favori;
import Model.Item;
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

    private static final String TABLE_NAME2 = "favori";
    private static final String KEY_ID_ITEM = "id_item";
    private static final String KEY_ID_USER2 = "id_user";
    public static final String CREATE_TABLE2 = "CREATE TABLE "
            + TABLE_NAME2 + " ("
            + KEY_ID_USER2 + " TEXT, "
            + KEY_ID_ITEM + " TEXT);, ";
    public static final String DROP_TABLE2 = "DROP TABLE IF EXISTS "
            + TABLE_NAME2 +";";

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

    public long addFavori(String idItem, String idUser){


        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_ID_ITEM, idItem);
        contentValues.put(KEY_ID_USER2, idUser);
        long i = this.getSqliteDb().insert(TABLE_NAME2, null, contentValues);
        return i;

    }

    public ArrayList<Item> getFavori(String idUser){

        String[] tab = {idUser};
        ArrayList<Item> itemTab = new ArrayList<>();
        String query = " SELECT * FROM "+ TABLE_NAME2 + "," + "item"  + " WHERE " + TABLE_NAME2 + ".id_item=item.id_item AND id_user=?";
        Cursor cursor = this.getSqliteDb().rawQuery(query,tab);
       if (cursor != null){
            while (cursor.moveToNext()){
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date dueDate = null;
                try {
                    dueDate = dateFormat.parse(cursor.getString(3));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Item item = new Item(cursor.getString(2),
                        cursor.getString(1),
                        dueDate,
                        cursor.getString(0),
                        cursor.getString(4),
                        cursor.getString(5)
                );
                itemTab.add(item);
            }
        }
        return itemTab;

    }





}
