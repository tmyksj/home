package app.service

import app.dto.BookDto
import kotlinx.browser.window
import kotlinx.coroutines.await
import org.w3c.fetch.Response

class BookService {

    suspend fun fetchAll(): List<BookDto> {
        val response: Response = window.fetch("assets/books.json").await()
        val responseJson: dynamic = response.json().await().asDynamic()
        val books: Array<dynamic> = responseJson.books as Array<dynamic>

        return books.map { book ->
            val authors: Array<dynamic>? = book.authors as Array<dynamic>?

            BookDto(
                authorList = authors?.map { it as String },
                hrefNdl = book.hrefNdl as String?,
                hrefOfficial = book.hrefOfficial as String?,
                isbn = book.isbn as String?,
                title = book.title as String?,
            )
        }.toList()
    }

}
