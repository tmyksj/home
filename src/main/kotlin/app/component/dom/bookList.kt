package app.component.dom

import app.component.bookList.BookList
import app.component.bookList.BookListRProps
import react.RBuilder
import react.RHandler
import react.ReactElement

fun RBuilder.bookList(handler: RHandler<BookListRProps>): ReactElement {
    return child(BookList::class, handler)
}
