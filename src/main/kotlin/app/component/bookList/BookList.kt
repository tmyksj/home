package app.component.bookList

import app.component.dom.defaultButton
import app.component.dom.primaryButton
import app.domain.book.BookDomain
import app.domain.book.dto.BookDto
import app.support.css.Color
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.css.*
import react.RBuilder
import react.RComponent
import react.dom.div
import react.setState
import styled.*

class BookList : RComponent<BookListRProps, BookListRState>() {

    override fun BookListRState.init() {
        val coroutineScope: CoroutineScope = MainScope()

        coroutineScope.launch {
            val dtoList: List<BookDto> = BookDomain().fetchAll()
            setState {
                bookDtoList = dtoList
            }
        }
    }

    override fun RBuilder.render() {
        state.bookDtoList?.take(props.n ?: Int.MAX_VALUE)?.forEach {
            styledDiv {
                css {
                    margin(vertical = 3.rem, horizontal = 0.rem)
                }

                it.title?.let {
                    key = it
                }

                styledDiv {
                    css {
                        marginBottom = 0.5.rem
                    }

                    it.title?.let {
                        styledH2 {
                            css {
                                display = Display.inline
                                fontSize = 1.2.rem
                                margin(all = 0.rem)
                            }

                            +it
                        }
                    }

                    it.isbn?.let {
                        styledSpan {
                            css {
                                color = Color.neutralSecondary
                                fontSize = 0.8.rem
                                marginLeft = 1.rem
                            }

                            +"ISBN $it"
                        }
                    }
                }

                styledDiv {
                    css {
                        marginBottom = 0.5.rem
                    }

                    it.authorList?.forEach {
                        styledP {
                            css {
                                color = Color.neutralSecondary
                                fontSize = 0.8.rem
                                margin(all = 0.rem)
                            }

                            +it
                        }
                    }
                }

                div {
                    it.hrefNdl?.let {
                        styledDiv {
                            css {
                                display = Display.inlineBlock
                            }

                            defaultButton {
                                attrs.href = it
                                attrs.rel = "nofollow noopener noreferrer"
                                attrs.target = "_blank"
                                +"National Diet Library"
                            }
                        }
                    }

                    it.hrefOfficial?.let {
                        styledDiv {
                            css {
                                display = Display.inlineBlock
                                marginLeft = 1.rem
                            }

                            primaryButton {
                                attrs.href = it
                                attrs.rel = "nofollow noopener noreferrer"
                                attrs.target = "_blank"
                                +"Official Page"
                            }
                        }
                    }
                }
            }
        }
    }

}
