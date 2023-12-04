package com.example.jetpackcomponentcatalog.ui

data class CheckInfo(
    val title: String,
    var selected: Boolean = false,
    var OncheckedChange: (Boolean) -> Unit
)
