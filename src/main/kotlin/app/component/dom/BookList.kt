package app.component.dom

import app.component.bookList.BookListProps
import app.component.bookList.BookListRComponent
import react.ComponentClass
import react.react

val BookList: ComponentClass<BookListProps> = BookListRComponent::class.react
