package app.component

import app.css.Color
import app.dto.ArticleDto
import app.js.fluentui.react.PrimaryButton
import app.service.ArticleService
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.css.*
import react.FC
import react.dom.div
import react.fc
import react.router.NavigateFunction
import react.router.useNavigate
import react.useEffectOnce
import react.useState
import styled.css
import styled.styledDiv
import styled.styledH2
import styled.styledSpan

val ArticleList: FC<ArticleListProps> = fc { props ->
    val navigate: NavigateFunction = useNavigate()

    var articleDtoList by useState<List<ArticleDto>>(listOf())

    useEffectOnce {
        MainScope().launch {
            articleDtoList = ArticleService().fetchAll()
        }
    }

    articleDtoList.take(props.n ?: Int.MAX_VALUE).forEach { articleDto ->
        styledDiv {
            css {
                margin(vertical = 3.rem, horizontal = 0.rem)
            }

            key = articleDto.name

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

                    +articleDto.name
                }

                styledSpan {
                    css {
                        color = Color.neutralSecondary
                        fontSize = 0.8.rem
                        marginLeft = 1.rem
                    }

                    DateString {
                        attrs.date = articleDto.lastModifiedDate
                        attrs.suffix = "更新"
                    }
                }
            }

            div {
                styledDiv {
                    css {
                        display = Display.inlineBlock
                    }

                    PrimaryButton {
                        attrs.onClick = {
                            navigate("/articles/${articleDto.uuid}")
                        }

                        +"Open"
                    }
                }
            }
        }
    }
}
