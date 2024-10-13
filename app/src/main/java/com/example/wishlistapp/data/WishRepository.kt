package com.example.wishlistapp.data

class WishRepository(
    private val wishDao : WishDao
) {

    suspend fun addWish(wishEntity : Wish) = wishDao.addWish(wishEntity)

    fun getWishes() = wishDao.getWishes()

    fun getWishById(id: Long) = wishDao.getWishById(id)

    suspend fun updateWish(wishEntity : Wish) = wishDao.updateWish(wishEntity)

    suspend fun deleteWish(wishEntity : Wish) = wishDao.deleteWish(wishEntity)

}