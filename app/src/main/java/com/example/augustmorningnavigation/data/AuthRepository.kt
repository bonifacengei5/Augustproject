package com.example.augustmorningnavigation.data

import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.augustmorningnavigation.models.User
import com.example.augustmorningnavigation.navigation.ROUTE_HOME
import com.example.augustmorningnavigation.navigation.ROUTE_LOGIN
import com.example.augustmorningnavigation.navigation.ROUTE_SIGNUP
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class AuthRepository(var navController: NavHostController) {
    var mAuth :FirebaseAuth
    init {
        mAuth = FirebaseAuth.getInstance()

    }
    fun signup(name:String,Email:String,password:String){
        mAuth.createUserWithEmailAndPassword(Email,password).addOnCompleteListener {
            if (it.isSuccessful) {
                var userData = User(name, Email, password, mAuth.currentUser!!.uid)
                var regRef = FirebaseDatabase.getInstance().getReference()
                    .child("Users/" + mAuth.currentUser!!.uid)
                regRef.setValue(userData).addOnCompleteListener {
                    if (it.isSuccessful){
                        navController.navigate(ROUTE_HOME)
                    }else{
                        navController.navigate(ROUTE_LOGIN)
                    }

                }

                navController.navigate(ROUTE_HOME)
            }else{
                navController.navigate(ROUTE_SIGNUP)
            }
        }


    }
    fun login(Email:String, password: String){
        mAuth.signInWithEmailAndPassword(Email,password).addOnCompleteListener {
            if (it.isSuccessful){
                navController.navigate(ROUTE_HOME)
            }else{
                navController.navigate(ROUTE_LOGIN)
            }
        }

    }
    fun logout(){
        mAuth.signOut()
        navController.navigate(ROUTE_LOGIN)

    }
    fun isloggedIn():Boolean= mAuth.currentUser !=null



}