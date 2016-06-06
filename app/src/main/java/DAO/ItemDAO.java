package DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;

import Model.Item;

/**
 * Created by Brezeler on 06/05/2016.
 */
public class ItemDAO extends AbstractDAO <Item> {

    private static final String TABLE_NAME = "item";
    private static final String KEY_ID_ITEM = "id_item";
    private static final String KEY_TITLE = "title";
    private static final String KEY_PUBDATE = "pubdate";
    private static final String KEY_SOURCE = "source";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_LINK = "link";
    public static final String CREATE_TABLE = "CREATE TABLE "
            + TABLE_NAME + " ("
            + KEY_ID_ITEM + " TEXT, "
            + KEY_LINK + " TEXT, "
            + KEY_TITLE + " TEXT, "
            + KEY_SOURCE + " TEXT, "
            + KEY_DESCRIPTION + " TEXT, "
            + KEY_PUBDATE + " DATE);";
    public static final String DROP_TABLE = "DROP TABLE IF EXISTS "
            + TABLE_NAME +";";
    public ItemDAO(Context context) {
        super(context);
    }

    public long add(Item item){
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_ID_ITEM, item.getId());
        contentValues.put(KEY_TITLE, item.getTitle());
        contentValues.put(KEY_LINK, item.getLink());
        contentValues.put(KEY_DESCRIPTION, item.getDescription());
        contentValues.put(KEY_SOURCE, item.getSource());
        //date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        contentValues.put(KEY_PUBDATE,dateFormat.format(item.getPubDate()));

        long i = this.getSqliteDb().insert(TABLE_NAME, null, contentValues);
        return i;
    }
    public Item get(String id){
        Cursor cursor = this.getSqliteDb().query(TABLE_NAME,
                new String[]{KEY_ID_ITEM, KEY_TITLE,KEY_LINK, KEY_PUBDATE, KEY_SOURCE, KEY_DESCRIPTION},
                KEY_ID_ITEM + "=?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null
        );
        Item item = null;
        if (cursor!=null){
            cursor.moveToFirst();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date dueDate = null;
            try {
                dueDate = dateFormat.parse(cursor.getString(3));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            item = new Item(cursor.getString(2),
                    cursor.getString(1),
                    dueDate,
                    cursor.getString(0),
                    cursor.getString(4),
                    cursor.getString(5)
            );
        }
        return item;
    }

    public ArrayList<Item> itemList(){

        ArrayList <Item> list = new ArrayList<>();

        Cursor cursor = this.getSqliteDb().query(TABLE_NAME,
                new String[]{KEY_ID_ITEM, KEY_TITLE,KEY_LINK, KEY_PUBDATE, KEY_SOURCE, KEY_DESCRIPTION},
                null,
                null,
                null,
                null,
                null,
                null
        );
        Item item = null;
        if (cursor!=null){
            while(cursor.moveToNext()){

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date dueDate = null;
                try {
                    dueDate = dateFormat.parse(cursor.getString(3));
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                item = new Item(cursor.getString(2),
                        cursor.getString(1),
                        dueDate,
                        cursor.getString(0),
                        cursor.getString(4),
                        cursor.getString(5)
                );
                list.add(item);
            }

        }

        return list;
    }



    public void delete(Item item){

        delete(item.getId());
    }

    public void delete(String id){

        this.getSqliteDb().delete(TABLE_NAME,KEY_ID_ITEM+"=?",new String[]{String.valueOf(id)});
    }


}
