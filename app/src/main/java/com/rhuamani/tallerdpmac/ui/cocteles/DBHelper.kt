package com.rhuamani.tallerdpmac.ui.cocteles

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.rhuamani.tallerdpmac.ui.utils.Constantes


class DBHelper private constructor(context: Context): SQLiteOpenHelper(context, Constantes.DB_NAME, null, Constantes.DB_VERSION) {

    companion object{
        private var instance: DBHelper? = null

        fun getInstance(ctx: Context): DBHelper {
            if (instance == null)
                instance = DBHelper(ctx)
            return instance!!
        }
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val query = "CREATE TABLE " + Constantes.TB_COCTELES +
                " (id TEXT PRIMARY KEY," +
                "  nombre TEXT NOT NULL," +
                "  url TEXT NOT NULL)"

        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}