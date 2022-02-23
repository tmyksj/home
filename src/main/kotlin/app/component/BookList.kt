package app.component

import app.css.Color
import app.dto.BookDto
import app.js.fluentui.react.DefaultButton
import app.js.fluentui.react.PrimaryButton
import app.service.BookService
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.css.*
import react.FC
import react.dom.div
import react.fc
import react.useEffectOnce
import react.useState
import styled.*

val BookList: FC<BookListProps> = fc { props ->
    var bookDtoList by useState<List<BookDto>>(listOf())

    useEffectOnce {
        MainScope().launch {
            bookDtoList = BookService().fetchAll()
        }
    }

    bookDtoList.take(props.n ?: Int.MAX_VALUE).forEach {
        styledDiv {
            css {
                margin(vertical = 3.rem, horizontal = 0.rem)
            }

            key = it.name

            styledDiv {
                css {
                    marginBottom = 0.5.rem
                }

                styledH2 {
                    css {
                        display = Display.inline
                        fontSize = 1.2.rem
                        margin(all = 0.rem)
                    }

                    +it.name
                }

                styledSpan {
                    css {
                        color = Color.neutralSecondary
                        fontSize = 0.8.rem
                        marginLeft = 1.rem
                    }

                    +"ISBN ${it.isbn}"
                }
            }

            styledDiv {
                css {
                    marginBottom = 0.5.rem
                }

                it.authorList.forEach {
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
                styledDiv {
                    css {
                        display = Display.inlineBlock
                    }

                    DefaultButton {
                        attrs.href = it.hrefNdl
                        attrs.rel = "nofollow noopener noreferrer"
                        attrs.target = "_blank"
                        +"National Diet Library"
                    }
                }

                it.hrefOfficial?.let {
                    styledDiv {
                        css {
                            display = Display.inlineBlock
                            marginLeft = 1.rem
                        }

                        PrimaryButton {
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
