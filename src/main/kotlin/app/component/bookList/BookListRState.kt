package app.component.bookList

import app.dto.BookDto
import react.RState

external interface BookListRState : RState {

    var bookDtoList: List<BookDto>?

}
