package app.component.repositoryList

import app.css.Color
import app.css.Layout
import app.dto.RepositoryDto
import app.js.fluentui.react.DefaultButton
import app.js.fluentui.react.PrimaryButton
import app.service.RepositoryService
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.css.*
import react.RBuilder
import react.RComponent
import react.dom.div
import react.setState
import styled.*

class RepositoryListRComponent : RComponent<RepositoryListProps, RepositoryListState>() {

    override fun RepositoryListState.init() {
        MainScope().launch {
            val repositoryDtoList: List<RepositoryDto> = RepositoryService().fetchAll()

            setState {
                this.repositoryDtoList = repositoryDtoList
            }
        }
    }

    override fun RBuilder.render() {
        state.repositoryDtoList?.take(props.n ?: Int.MAX_VALUE)?.forEach {
            styledDiv {
                css {
                    margin(vertical = 3.rem, horizontal = 0.rem)
                }

                key = it.name

                styledDiv {
                    css {
                        display = Display.flex

                        Layout.mediaMedium(this) {
                            flexDirection = FlexDirection.column
                        }
                    }

                    styledDiv {
                        css {
                            marginRight = 2.rem
                            minWidth = 20.rem
                            width = 20.rem

                            Layout.mediaMedium(this) {
                                marginRight = 0.rem
                                minWidth = LinearDimension.auto
                                width = 100.pct
                            }
                        }

                        styledImg {
                            css {
                                borderColor = Color.neutralTertiaryAlt
                                borderStyle = BorderStyle.solid
                                borderWidth = 1.px
                                display = Display.block
                                width = 100.pct
                            }

                            attrs.alt = "social preview"
                            attrs.src = it.imgSrc
                        }
                    }

                    styledDiv {
                        css {
                            flexGrow = 1.0

                            Layout.mediaMedium(this) {
                                marginBottom = 2.rem
                                marginTop = 1.rem
                            }
                        }

                        styledH2 {
                            css {
                                fontSize = 1.2.rem
                                marginBottom = 0.5.rem
                                marginTop = 0.rem
                            }

                            +it.name
                        }

                        styledP {
                            css {
                                margin(vertical = 0.5.rem, horizontal = 0.rem)
                            }

                            +it.description
                        }

                        div {
                            styledDiv {
                                css {
                                    display = Display.inlineBlock
                                }

                                DefaultButton {
                                    attrs.href = it.hrefGitHub
                                    attrs.rel = "nofollow noopener noreferrer"
                                    attrs.target = "_blank"
                                    +"GitHub"
                                }
                            }

                            it.hrefDeploy?.let {
                                styledDiv {
                                    css {
                                        display = Display.inlineBlock
                                        marginLeft = 1.rem
                                    }

                                    PrimaryButton {
                                        attrs.href = it
                                        attrs.rel = "nofollow noopener noreferrer"
                                        attrs.target = "_blank"
                                        +"Open"
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}