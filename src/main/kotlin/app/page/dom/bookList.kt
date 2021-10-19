package app.page.dom

import app.page.bookList.BookListProps
import app.page.bookList.BookListRComponent
import react.RBuilder
import react.RHandler

fun RBuilder.bookList(handler: RHandler<BookListProps>) {
    child(BookListRComponent::class, handler)
}
