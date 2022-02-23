package app.component

import kotlinx.css.*
import react.FC
import react.dom.p
import react.fc
import styled.css
import styled.styledDiv

val NotFound: FC<NotFoundProps> = fc {
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
