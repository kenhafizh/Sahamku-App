package com.kenapps.sahamkuapp

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.kenapps.sahamkuapp.companiesData.Companies


@Dao
interface ItemDao { //dao (data acces object), dao menjelaskan gimana caranya kita mendapatkan sesuatu untuk item ini
    @Insert
    fun insert(item: Item)

    @Update
    fun update(item: Item)

    @Delete
    fun delete(item: Item)

    @Query("SELECT * FROM stock_database")
    fun getAll(): List<Item>

    @Query("SELECT * FROM stock_database WHERE name LIKE :query OR symbol like :query ")
    fun searchCompanies(query: String): List<Item>
}


//val item = Item(name= "Ken", NIM = "19103114")
//dao.insert(item)