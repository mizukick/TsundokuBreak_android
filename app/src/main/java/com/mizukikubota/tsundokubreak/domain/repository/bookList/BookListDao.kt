package com.mizukikubota.tsundokubreak.domain.repository.bookList

import androidx.room.*
import com.mizukikubota.tsundokubreak.domain.entity.bookInfo.TsundokuBook
import kotlinx.coroutines.flow.Flow

@Dao
interface BookListDao {

    // SQLite have no boolean data type
    // Room maps boolean data to an INTEGER column
    // Room mapping true to 1 and false to 0
    @Query("select * from tsundokuBook where dokuryo = 0 ")
    fun getTsundokuBookList(): Flow<List<TsundokuBook>>

    @Query("select * from tsundokuBook where dokuryo = 1 ")
    fun getDokuryoBookList(): Flow<List<TsundokuBook>>

    @Insert
    suspend fun addTsundokuBook(tsundokuBook: TsundokuBook)

    @Update
    suspend fun updateTsundokuBook(tsundokuBook: TsundokuBook)

    @Delete
    suspend fun deleteDokuryoBook(tsundokuBook: TsundokuBook)
}
