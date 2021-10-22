package app.page.bookList

import app.component.dom.BookList
import app.component.dom.DefaultHeader
import app.css.Layout
import kotlinx.css.*
import react.RBuilder
import react.RComponent
import styled.css
import styled.styledH1
import styled.styledP
import styled.styledSection

class BookListRComponent : RComponent<BookListProps, BookListState>() {

    override fun RBuilder.render() {
        DefaultHeader { }

        styledSection {
            css {
                margin(vertical = 4.rem, horizontal = LinearDimension.auto)
                maxWidth = Layout.extraLarge
                padding(vertical = 0.rem, horizontal = 1.rem)
            }

            styledH1 {
                css {
                    fontSize = 1.5.rem
                    marginBottom = 0.5.rem
                    marginTop = 1.rem
                }

                +"Books"
            }

            styledP {
                css {
                    margin(vertical = 0.5.rem, horizontal = 0.rem)
                }

                +"これまでに読んだ本のリストです。"
            }

            BookList { }
        }
    }

}
