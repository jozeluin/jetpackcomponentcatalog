package com.example.jetpackcomponentcatalog.model

import androidx.annotation.DrawableRes

data class SuperHero(
    var superheroName: String,
    var realname: String,
    var publisher: String,
    @DrawableRes var photo: Int
) {


}
