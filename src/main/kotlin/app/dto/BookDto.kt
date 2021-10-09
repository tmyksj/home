package app.dto

data class BookDto(

    val isbn: String,

    val name: String,

    val authorList: List<String>,

    val hrefNdl: String,

    val hrefOfficial: String?,

    )
