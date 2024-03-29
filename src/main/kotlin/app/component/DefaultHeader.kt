package app.component

import app.css.Color
import kotlinx.css.*
import react.FC
import react.fc
import react.router.dom.Link
import styled.*

val DefaultHeader: FC<DefaultHeaderProps> = fc {
    styledHeader {
        css {
            backgroundColor = Color.white
            height = 3.rem
            padding(vertical = 0.rem, horizontal = 1.rem)
        }

        styledH1 {
            css {
                alignItems = Align.center
                display = Display.flex
                height = 100.pct
                margin(all = 0.rem)
            }

            Link {
                attrs.to = "/"

                styledSpan {
                    css {
                        alignItems = Align.flexEnd
                        display = Display.flex
                    }

                    styledImg {
                        css {
                            borderRadius = 50.pct
                            height = 2.rem
                        }

                        attrs.alt = "identicon"
                        attrs.src = "assets/identicon.png"
                    }

                    styledSpan {
                        css {
                            color = Color.neutralPrimary
                            fontSize = 1.rem
                            marginLeft = 1.rem
                        }

                        +"tmyksj"
                    }
                }
            }
        }
    }
}
