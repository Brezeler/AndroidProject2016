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

/**
 * Created by Brezeler on 19/07/2016.
 */
public class FavoriDAO extends AbstractDAO <Favori> {

    private static final String TABLE_NAME = "favori";
    private static final String KEY_ID_ITEM = "id_item";
    private static final String KEY_ID_USER2 = "id_user";
    public static final String CREATE_TABLE2 = "CREATE TABLE "
            + TABLE_NAME + " ("
            + KEY_ID_USER2 + " TEXT, "
            + KEY_ID_ITEM + " TEXT);, ";
    public static final String DROP_TABLE = "DROP TABLE IF EXISTS "
            + TABLE_NAME +";";

    public FavoriDAO(Context context) {
        super(context);
    }

    public long addFavori(String idItem, String idUser){

        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_ID_ITEM, idItem);
        contentValues.put(KEY_ID_USER2, idUser);
        long i = this.getSqliteDb().insert(TABLE_NAME, null, contentValues);
        return i;

    }

    public ArrayList<Item> getFavori(String idUser){

        String[] tab = {idUser};
        ArrayList<Item> itemTab = new ArrayList<>();
        String query = " SELECT * FROM "+ TABLE_NAME + "," + "item"  + " WHERE " + TABLE_NAME + ".id_item=item.id_item AND id_user=?";
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
