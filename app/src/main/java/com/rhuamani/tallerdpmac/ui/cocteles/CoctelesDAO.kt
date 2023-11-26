package com.rhuamani.tallerdpmac.ui.cocteles

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.rhuamani.tallerdpmac.ui.utils.Constantes

class CoctelesDAO (context: Context) {

    private var dbHelper : DBHelper? = null
    private var db: SQLiteDatabase? = null

    init {
        dbHelper = DBHelper.getInstance(context)
        db = dbHelper?.writableDatabase

    }

    fun listarCocteles(): ArrayList<CoctelModel>{
        val lista: ArrayList<CoctelModel> = ArrayList()
        var c: Cursor ? = null
        try {
            c = db!!.rawQuery("SELECT * FROM "+ Constantes.TB_COCTELES, null)
            var coctel:CoctelModel?
            while (c.moveToNext()){
                coctel = CoctelModel(c.getString(0), c.getString(1), c.getString(2))
                lista.add(coctel)
            }
        }
        catch (e:Exception){
            e.printStackTrace()
        }
        c?.close()
        return lista
    }

    fun registrarCoctel(coctel: CoctelModel): Long{
        try {
            val values = ContentValues()
            values.put("id", coctel.id)
            values.put("nombre", coctel.nombre)
            values.put("url", coctel.url)

            return db!!.insert(Constantes.TB_COCTELES, null, values)
        }
        catch (e: Exception){
            e.printStackTrace()
            return -1
        }
    }

    fun editarCoctel(coctel: CoctelModel): Int {
        try {
            val values = ContentValues()
            values.put("id", coctel.id)
            values.put("nombre", coctel.nombre)
            values.put("url", coctel.url)
            val args = arrayOf(coctel.id)
            return db!!.update(Constantes.TB_COCTELES, values,"id=?", args)
        }
        catch (e: Exception){
            e.printStackTrace()
            return -1
        }
    }

    fun obtenerCoctel(id: Int): CoctelModel? {
        var coctel: CoctelModel? = null
        var c: Cursor? = null
        val args = arrayOf(id.toString())
        try {
            c = db!!.rawQuery("SELECT * FROM " + Constantes.TB_COCTELES + " WHERE id=?", args)
            while (c.moveToNext()){
                coctel = CoctelModel(c.getString(0), c.getString(1), c.getString(2))
            }
        }
        catch (e: Exception){
            e.printStackTrace()
        }
        c?.close()
        return coctel
    }

    fun eliminar(id: Int): Int{
        try {
            val args = arrayOf(id.toString())
            return db!!.delete(Constantes.TB_COCTELES, "id=?", args)
        }
        catch (e: Exception){
            e.printStackTrace()
            return -1
        }
    }
}