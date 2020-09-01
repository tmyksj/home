package app.component.repository

import app.component.dom.defaultButton
import app.component.dom.primaryButton
import kotlinx.css.*
import react.RBuilder
import react.RComponent
import react.dom.div
import styled.*

class Repository : RComponent<RepositoryRProps, RepositoryRState>() {

    override fun RBuilder.render() {
        styledDiv {
            css {
                display = Display.flex

                media("(max-width: 40rem)") {
                    flexDirection = FlexDirection.column
                }
            }

            styledDiv {
                css {
                    marginRight = 2.rem
                    minWidth = 20.rem
                    width = 20.rem

                    media("(max-width: 40rem)") {
                        marginRight = 0.rem
                        minWidth = LinearDimension.auto
                        width = 100.pct
                    }
                }

                styledImg {
                    css {
                        width = 100.pct
                    }

                    attrs.alt = "social preview"
                    attrs.src = props.srcImg
                }
            }

            styledDiv {
                css {
                    flexGrow = 1.0

                    media("(max-width: 40rem)") {
                        marginBottom = 2.rem
                        marginTop = 1.rem
                    }
                }

                styledH2 {
                    css {
                        fontSize = 1.2.rem
                        marginBottom = 1.rem
                        marginTop = 0.rem
                    }

                    +props.repositoryName
                }

                styledP {
                    css {
                        margin(vertical = 1.rem, horizontal = 0.rem)
                    }

                    +props.description
                }

                div {
                    styledDiv {
                        css {
                            display = Display.inlineBlock
                        }

                        defaultButton {
                            attrs.href = props.hrefGitHub
                            attrs.rel = "noreferrer noopener"
                            attrs.target = "_blank"
                            +"GitHub"
                        }
                    }

                    props.hrefDeploy?.let {
                        styledDiv {
                            css {
                                display = Display.inlineBlock
                                marginLeft = 1.rem
                            }

                            primaryButton {
                                attrs.href = it
                                attrs.rel = "noreferrer noopener"
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
