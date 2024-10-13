package com.example.wishlistapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wish-table")
data class Wish(
    @PrimaryKey(true)
    val id: Long = 0L,

    @ColumnInfo(name="wish-title")
    val title: String = "",

    @ColumnInfo(name="wish-desc")
    val description: String = "",
)

object DummyWish {
    val wishes = listOf(
        Wish(
            title = "PlayStation 5",
            description = "A true next generation PlayStation console.",
        ),
        Wish(
            title = "Nintendo Switch",
            description = "An exciting console from the creator of Super Mario.",
        ),
        Wish(
            title = "Galaxy Watch 6",
            description = "Because you can't have too many watches.",
        ),
        Wish(
            title = "GeForce RTX 4090",
            description = "The ultimate graphics card for gaming.",
        ),
    )
}