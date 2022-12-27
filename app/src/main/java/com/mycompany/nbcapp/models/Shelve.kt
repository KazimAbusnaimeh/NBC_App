package com.mycompany.nbcapp.models

data class Shelve(
    val items: List<Item>,
    val title: String,
    val type: String
)