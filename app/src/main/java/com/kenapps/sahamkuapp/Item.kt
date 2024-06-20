package com.kenapps.sahamkuapp

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "stock_database") //deklarasi nama tabel
data class Item (
    @PrimaryKey(autoGenerate = true) // yaitu agar tidak ada data yang duplikat
    val id: Long= 0,
    val name: String,
    val symbol: String
) : Parcelable
