package app.component.dom

import app.component.bookList.BookListProps
import app.component.bookList.BookListRComponent
import react.RBuilder
import react.RHandler

fun RBuilder.bookList(handler: RHandler<BookListProps>) {
    child(BookListRComponent::class, handler)
}
