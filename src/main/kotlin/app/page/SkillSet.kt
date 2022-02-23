package app.page

import app.component.DefaultHeader
import app.component.SkillSet
import app.css.Layout
import kotlinx.css.*
import react.FC
import react.fc
import styled.css
import styled.styledH1
import styled.styledP
import styled.styledSection

val SkillSet: FC<SkillSetProps> = fc {
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

            +"Skills"
        }

        styledP {
            css {
                margin(vertical = 0.5.rem, horizontal = 0.rem)
            }

            +"スキルセットです。"
        }

        SkillSet { }
    }
}
