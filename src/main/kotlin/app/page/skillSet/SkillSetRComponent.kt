package app.page.skillSet

import app.component.dom.DefaultHeader
import app.component.dom.SkillSet
import app.css.Layout
import kotlinx.css.*
import react.RBuilder
import react.RComponent
import styled.css
import styled.styledH1
import styled.styledP
import styled.styledSection

class SkillSetRComponent : RComponent<SkillSetProps, SkillSetState>() {

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

}