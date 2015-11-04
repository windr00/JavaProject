package com.example.AndroidTest.SQLConnection;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by windr on 15/11/1.
 */
public class SQLConnection {

    public class DBConnection extends SQLiteOpenHelper {
        public DBConnection (Context context) {
            super(context, "InteliData", null, 2);
        }

        @Override
        public void onCreate (SQLiteDatabase db) {
            db.execSQL(MONTHS_AMOUNT_CREATE);
            db.execSQL(MONTH_SPECIFIC_CREATE);

        }

        @Override
        public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }

    public enum TABLE_NAMES {
        months_amount,
        month_specific,
    }

    public enum MONTHS_AMOUNT {
        _id,
        year,
        month,
        datapack_amount,
    }

    public enum MONTH_SPECIFIC {
        _id,
        months_amount__id,
        datapak_name,
        datapak_specified_app,
        datapak_sum,
        datapak_used,
        datapak_start,
        datapak_end,
        datapak_is_daily,
        datapak_is_monthly,
    }

    private static final String MONTHS_AMOUNT_CREATE =
            "CREATE TABLE " + TABLE_NAMES.months_amount.toString() + "(" +
            MONTHS_AMOUNT._id.toString() + " INTEGER PRIMARY KEY AUTOINCREMENT " + "," +
            MONTHS_AMOUNT.year.toString() + " INTEGER NOT NULL " + "," +
            MONTHS_AMOUNT.month.toString() + " INTEGER NOT NULL " + "," +
            MONTHS_AMOUNT.datapack_amount.toString() + " INTEGER NOT NULL " + ")";

    private static final String MONTH_SPECIFIC_CREATE =
            "CREATE TABLE " + TABLE_NAMES.month_specific.toString() + "(" +
            MONTH_SPECIFIC._id.toString() + " INTEGER PRIMARY KEY AUTOINCREMENT " + "," +
            MONTH_SPECIFIC.months_amount__id.toString() + " INTEGER " + "," +
            MONTH_SPECIFIC.datapak_specified_app.toString() + " TEXT NOT NULL DEFAULT ('ALL') " + "," +
            MONTH_SPECIFIC.datapak_name.toString() + " TEXT NOT NULL " + "," +
            MONTH_SPECIFIC.datapak_sum.toString() + " REAL NOT NULL " + "," +
            MONTH_SPECIFIC.datapak_used.toString() + " REAL NOT NULL " + "," +
            MONTH_SPECIFIC.datapak_start.toString() + " TEXT NOT NULL " + "," +
            MONTH_SPECIFIC.datapak_end.toString() + " TEXT NOT NULL " + "," +
            MONTH_SPECIFIC.datapak_is_daily.toString() + " INTEGER NOT NULL " + "," +
            MONTH_SPECIFIC.datapak_is_monthly.toString() + " INTEGER NOT NULL " + ")" ;

    public enum DATAOPERATION {
        UPDATE,
        INSERT,
        DELETE
    }

    private Context context = null;
    private SQLiteDatabase sqLiteDatabase = null;


    public SQLConnection(Context c) {
        context = c;
    }

    public void createDatabaseConnection() throws SQLException {
        DBConnection dbConnection  = new DBConnection(context);
        sqLiteDatabase = dbConnection.getWritableDatabase();
    }

    public List<FolderViewDataBean> getAllFolderViewData () {
        List<FolderViewDataBean> folderViewDataBeanList = new ArrayList<FolderViewDataBean>();
        Cursor cursor = sqLiteDatabase.query(false,TABLE_NAMES.months_amount.toString(),new String[]{"*"},null,null,null,
                null,null,null);
        while (cursor.moveToNext()) {
            FolderViewDataBean tempBean = new FolderViewDataBean();
            tempBean.setId(cursor.getString(cursor.getColumnIndex(MONTHS_AMOUNT._id.toString())));
            tempBean.setDataPakAmount(cursor.getString(cursor.getColumnIndex(MONTHS_AMOUNT.datapack_amount.toString())));
            tempBean.setYear(cursor.getString(cursor.getColumnIndex(MONTHS_AMOUNT.year.toString())));
            tempBean.setMonth(cursor.getString(cursor.getColumnIndex(MONTHS_AMOUNT.month.toString())));
            folderViewDataBeanList.add(tempBean);
        }
        cursor.close();
        return folderViewDataBeanList;
    }

    public List<DataPakBean> getAllDataPaksInOneMonth (Integer Year, Integer Month) {
        List<DataPakBean> dataPakBeanList = new ArrayList<DataPakBean>();
        Cursor cursor = sqLiteDatabase.query(false,
                TABLE_NAMES.months_amount.toString(),
                new String[]{"*"},
                " WHERE " + MONTHS_AMOUNT.year.toString() + "='" + Year + "' AND " + MONTHS_AMOUNT.month.toString() + "='" + Month + "'"
                ,null,null,null,null,null);
        while (cursor.moveToNext()) {
            String tempMonthId = cursor.getString(cursor.getColumnIndex(MONTHS_AMOUNT._id.toString()));
            String monthStr = cursor.getString(cursor.getColumnIndex(MONTHS_AMOUNT.month.toString()));
            String yearStr = cursor.getString(cursor.getColumnIndex(MONTHS_AMOUNT.year.toString()));
            cursor.close();
            cursor = sqLiteDatabase.query(false,TABLE_NAMES.month_specific.toString(), new String[]{"*"},
                    " WHERE " + MONTH_SPECIFIC.months_amount__id.toString() + "='" + tempMonthId + "'",
                    null,null,null,null,null);
            while (cursor.moveToNext()) {
                DataPakBean dataPakBean = new DataPakBean();
                dataPakBean.setId(cursor.getString(cursor.getColumnIndex(MONTH_SPECIFIC._id.toString())));
                dataPakBean.setMonth(monthStr);
                dataPakBean.setYear(yearStr);
                dataPakBean.setDataPakName(cursor.getString(cursor.getColumnIndex(MONTH_SPECIFIC.datapak_name.toString())));
                dataPakBean.setDataPakStart(cursor.getString(cursor.getColumnIndex(MONTH_SPECIFIC.datapak_start.toString())));
                dataPakBean.setDataPakEnd(cursor.getString(cursor.getColumnIndex(MONTH_SPECIFIC.datapak_end.toString())));
                dataPakBean.setDataPakSpecifiedApp(cursor.getString(cursor.getColumnIndex(MONTH_SPECIFIC.datapak_specified_app.toString())));
                dataPakBean.setDataPakSum(cursor.getString(cursor.getColumnIndex(MONTH_SPECIFIC.datapak_sum.toString())));
                dataPakBean.setDataPakUsed(cursor.getString(cursor.getColumnIndex(MONTH_SPECIFIC.datapak_used.toString())));
                dataPakBean.setIsDataPakDaily(cursor.getString(cursor.getColumnIndex(MONTH_SPECIFIC.datapak_is_daily.toString())));
                dataPakBean.setIsDataPakMonthly(cursor.getString(cursor.getColumnIndex(MONTH_SPECIFIC.datapak_is_monthly.toString())));
                dataPakBeanList.add(dataPakBean);
            }
            break;
        }
        cursor.close();
        return dataPakBeanList;
    }


    public void insertNewDataPak(DataPakBean dataPakBean) {
        Cursor cursor = sqLiteDatabase.query(false,TABLE_NAMES.months_amount.toString(),new String[]{"*"}," WHERE ");
    }


}
