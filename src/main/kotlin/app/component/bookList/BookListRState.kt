package app.component.bookList

import app.domain.book.dto.BookDto
import react.RState

external interface BookListRState : RState {

    var bookDtoList: List<BookDto>?

}
