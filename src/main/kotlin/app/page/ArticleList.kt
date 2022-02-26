package app.page

import app.component.ArticleList
import app.component.DefaultHeader
import app.css.Layout
import kotlinx.browser.document
import kotlinx.css.*
import react.FC
import react.fc
import react.useEffectOnce
import styled.css
import styled.styledH1
import styled.styledP
import styled.styledSection

val ArticleList: FC<ArticleListProps> = fc {
    useEffectOnce {
        document.title = "Articles"
    }

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

            +"Articles"
        }

        styledP {
            css {
                margin(vertical = 0.5.rem, horizontal = 0.rem)
            }

            +"やったこと／試したことをまとめた記事です。"
        }

        ArticleList { }
    }
}
