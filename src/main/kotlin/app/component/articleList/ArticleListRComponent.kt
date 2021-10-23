package app.component.articleList

import app.component.dom.DateString
import app.css.Color
import app.dto.ArticleDto
import app.js.fluentui.react.PrimaryButton
import app.service.ArticleService
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.css.*
import react.RBuilder
import react.RComponent
import react.dom.div
import react.setState
import styled.css
import styled.styledDiv
import styled.styledH2
import styled.styledSpan

class ArticleListRComponent : RComponent<ArticleListProps, ArticleListState>() {

    override fun ArticleListState.init() {
        MainScope().launch {
            val articleDtoList: List<ArticleDto> = ArticleService().fetchAll()

            setState {
                this.articleDtoList = articleDtoList
            }
        }
    }

    override fun RBuilder.render() {
        state.articleDtoList?.take(props.n ?: Int.MAX_VALUE)?.forEach { articleDto ->
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
                                props.history.push("/articles/${articleDto.uuid}")
                            }

                            +"Open"
                        }
                    }
                }
            }
        }
    }

}
