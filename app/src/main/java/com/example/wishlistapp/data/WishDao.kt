package com.example.wishlistapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
abstract class WishDao {
    @Query("SELECT * FROM `wish-table`")
    abstract fun getWishes() : Flow<List<Wish>>

    @Query("SELECT * FROM `wish-table` WHERE id=:id")
    abstract fun getWishById(id : Long) : Flow<List<Wish>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun addWish(wishEntity : Wish)

    @Delete
    abstract suspend fun deleteWish(wishEntity : Wish)

    @Update
    abstract suspend fun updateWish(wishEntity : Wish)
}