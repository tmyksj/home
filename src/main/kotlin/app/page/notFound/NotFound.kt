package app.page.notFound

import kotlinx.css.*
import react.RBuilder
import react.RComponent
import react.dom.p
import styled.css
import styled.styledDiv

class NotFound : RComponent<NotFoundRProps, NotFoundRState>() {

    override fun RBuilder.render() {
        styledDiv {
            css {
                alignItems = Align.center
                display = Display.flex
                justifyContent = JustifyContent.center
                minHeight = 100.vh
            }

            p {
                +"ページが見つかりませんでした。"
            }
        }
    }

}
