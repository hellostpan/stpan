package com.example.stpan.activity;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.ContactsContract;

/**
 * 功能：
 * 创建时间:2015/8/19 16:27
 * 作者:pst
 * 版权: sowell,onegcloud
 */
public class ContactsPersonActivity extends BackActivity {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.test);
        init();
    }

    private void init() {
        String names[] = {"周杰伦", "谢霆锋", "言承旭", "林俊杰", "潘玮柏", "明道", " 甄子丹", " 周渝民",
                "罗志祥", "五月天", "刘德华", " 麦浚龙", " 成龙", " 苏有朋", " 郭品超", " 阿杜"
                , "郑嘉颖", " 吴尊", " 炎亚纶", " 王绍伟", " 唐禹哲", " 巫迪文", " 汪东城"};
        ContentResolver contentResolver = getContentResolver();
        //query
        String[] columns = new String[]{ContactsContract.CommonDataKinds.Phone.NUMBER,
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone._ID};
        Uri mUri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        Cursor cursor = contentResolver.query(mUri, columns, null, null, null);
        if (cursor.moveToFirst()) {
            String name = null;
            String number = null;
            String id = null;
            do {
                id = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone._ID));
                name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                System.out.println(id + " : " + name + " : " + number);
            } while (cursor.moveToNext());
            if (!cursor.isClosed()) cursor.close();
        }
        //add
        for (String s : names) {
            //首先插入空值，再得到rawContactsId ，用于下面插值
            ContentValues values = new ContentValues();
            Uri rawContentUri = contentResolver.insert(ContactsContract.RawContacts.CONTENT_URI, values);
            long rawContentId = ContentUris.parseId(rawContentUri);

            //往刚才的空记录中插入姓名
            values.clear();
            values.put(ContactsContract.CommonDataKinds.StructuredName.RAW_CONTACT_ID, rawContentId);//vnd.android.cursor.item/name
            values.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE);
            values.put(ContactsContract.CommonDataKinds.StructuredName.DISPLAY_NAME, s);
            contentResolver.insert(ContactsContract.Data.CONTENT_URI, values);

            //插入电话
            values.clear();
            values.put(ContactsContract.CommonDataKinds.Phone.RAW_CONTACT_ID, rawContentId);
            values.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE);
            values.put(ContactsContract.CommonDataKinds.Phone.NUMBER, "13587349559");
            contentResolver.insert(ContactsContract.Data.CONTENT_URI, values);

        }
        //delete
        for (String s : names) {
            Cursor cursor1 = contentResolver.query(ContactsContract.RawContacts.CONTENT_URI,
                    new String[]{ContactsContract.RawContacts._ID, ContactsContract.RawContacts.DISPLAY_NAME_PRIMARY},
                    "display_name=?", new String[]{s.trim()}, null);
            System.out.println(cursor1.getCount() + " : " + cursor1.getColumnCount());
            while (cursor1.moveToNext()) {
                String id = cursor1.getString(0);
                String name = cursor1.getString(1);
                System.out.println(id + " : " + name);
                contentResolver.delete(ContactsContract.RawContacts.CONTENT_URI, "_id =?", new String[]{id + ""});
                contentResolver.delete(ContactsContract.Data.CONTENT_URI, "raw_contact_id=? and data1=?", new String[]{id, "13587349559"});
            }
            if (!cursor1.isClosed()) cursor1.close();
        }
        //update
        ContentValues values = new ContentValues();
        for (String s : names) {
            Cursor cursor1 = contentResolver.query(ContactsContract.RawContacts.CONTENT_URI,
                    new String[]{ContactsContract.RawContacts._ID, ContactsContract.RawContacts.DISPLAY_NAME_PRIMARY},
                    "display_name=?", new String[]{s.trim()}, null);
            System.out.println(cursor1.getCount() + " : " + cursor1.getColumnCount());
            while (cursor1.moveToNext()) {
                values.clear();
                values.put(ContactsContract.CommonDataKinds.Phone.NUMBER, "12345678912");
                values.put(ContactsContract.CommonDataKinds.Phone.TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE);
                String id = cursor1.getString(0);
                String name = cursor1.getString(1);
                System.out.println(id + " : " + name);
                contentResolver.update(ContactsContract.Data.CONTENT_URI, values,
                        ContactsContract.Contacts.Data.RAW_CONTACT_ID + " =? and " + ContactsContract.Contacts.Data.MIMETYPE + " =?", new String[]{id, ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE});
            }
            if (!cursor1.isClosed()) cursor1.close();
        }
    }
}
