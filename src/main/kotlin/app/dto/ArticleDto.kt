package app.dto

import kotlin.js.Date

data class ArticleDto(

    val uuid: String,

    val name: String,

    val body: String,

    val createdDate: Date,

    val lastModifiedDate: Date,

    )
