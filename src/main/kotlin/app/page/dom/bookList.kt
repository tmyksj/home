package app.page.dom

import app.page.bookList.BookListRComponent
import app.page.bookList.BookListRProps
import react.RBuilder
import react.RHandler
import react.ReactElement

fun RBuilder.bookList(handler: RHandler<BookListRProps>): ReactElement {
    return child(BookListRComponent::class, handler)
}
