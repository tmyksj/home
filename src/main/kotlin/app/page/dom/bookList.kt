package app.page.dom

import app.page.bookList.BookList
import app.page.bookList.BookListRProps
import react.RBuilder
import react.RHandler
import react.ReactElement

fun RBuilder.bookList(handler: RHandler<BookListRProps>): ReactElement {
    return child(BookList::class, handler)
}
