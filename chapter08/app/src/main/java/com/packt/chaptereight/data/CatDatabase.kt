package com.packt.chaptereight.data

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [CatEntity::class],
    version = 2,
    autoMigrations = [
        AutoMigration(from = 1, to = 2)
    ]
)
@TypeConverters(PetsTypeConverters::class)
abstract class CatDatabase: RoomDatabase() {
    abstract fun carDao(): CatDao
}