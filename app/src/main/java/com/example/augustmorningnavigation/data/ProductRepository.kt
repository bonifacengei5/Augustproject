package com.example.augustmorningnavigation.data

import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.augustmorningnavigation.models.Product
import com.example.augustmorningnavigation.navigation.ROUTE_LOGIN
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class ProductRepository(var navController: NavHostController) {
    var authRepository:AuthRepository
    init {
        authRepository = AuthRepository(navController)
        if (!authRepository.isloggedIn()){
            navController.navigate(ROUTE_LOGIN)
        }
    }
    fun saveProduct(productName:String,productQuantity:String,productPrice:String){
        var id = System.currentTimeMillis().toString()
        var productData= Product(productName,productQuantity,productPrice,id)
        var productRef=FirebaseDatabase.getInstance().getReference()
            .child("Products/$id")
        productRef.setValue(productData)

    }
    fun viewProducts(){

    }
}