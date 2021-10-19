package app.component.bookList

import app.dto.BookDto
import react.State

external interface BookListState : State {

    var bookDtoList: List<BookDto>?

}
