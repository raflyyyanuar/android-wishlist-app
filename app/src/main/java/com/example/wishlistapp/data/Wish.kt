package com.example.wishlistapp.data

data class Wish(
    val id: Long = 0L,
    val title: String = "",
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