package app.page.home

import app.component.dom.bookList
import app.component.dom.repositoryList
import app.support.css.Color
import app.support.css.Layout
import kotlinx.css.*
import react.RBuilder
import react.RComponent
import react.dom.a
import react.dom.li
import react.dom.section
import react.router.dom.routeLink
import styled.*

class Home : RComponent<HomeRProps, HomeRState>() {

    override fun RBuilder.render() {
        styledSection {
            css {
                alignItems = Align.center
                display = Display.flex
                height = 90.vh
                justifyContent = JustifyContent.center
            }

            styledDiv {
                css {
                    alignItems = Align.flexEnd
                    display = Display.flex
                    justifyContent = JustifyContent.center
                }

                styledDiv {
                    css {
                        width = 16.rem
                    }

                    styledH1 {
                        css {
                            fontSize = 1.5.rem
                            marginBottom = 1.rem
                            marginTop = 0.rem
                        }

                        +"tmyksj"
                    }

                    styledUl {
                        css {
                            listStyleType = ListStyleType.none
                            margin(all = 0.rem)
                            padding(all = 0.rem)
                        }

                        li {
                            a {
                                attrs.href = "https://atcoder.jp/users/tmyksj"
                                attrs.rel = "nofollow noopener noreferrer"
                                attrs.target = "_blank"
                                +"atcoder"
                            }
                        }
                        li {
                            a {
                                attrs.href = "https://facebook.com/tmyksj"
                                attrs.rel = "nofollow noopener noreferrer"
                                attrs.target = "_blank"
                                +"facebook"
                            }
                        }
                        li {
                            a {
                                attrs.href = "https://github.com/tmyksj"
                                attrs.rel = "nofollow noopener noreferrer"
                                attrs.target = "_blank"
                                +"github"
                            }
                        }
                        li {
                            a {
                                attrs.href = "https://twitter.com/tmyksj"
                                attrs.rel = "nofollow noopener noreferrer"
                                attrs.target = "_blank"
                                +"twitter"
                            }
                        }
                    }
                }

                styledImg {
                    css {
                        borderColor = Color.neutralTertiaryAlt
                        borderRadius = 50.pct
                        borderStyle = BorderStyle.solid
                        borderWidth = 1.px
                        width = 6.rem
                    }

                    attrs.alt = "identicon"
                    attrs.src = "assets/identicon.png"
                }
            }
        }

        styledSection {
            css {
                backgroundColor = Color.neutralDark
                color = Color.neutralLighter
            }

            styledDiv {
                css {
                    margin(vertical = 0.rem, horizontal = LinearDimension.auto)
                    maxWidth = Layout.extraLarge
                    padding(vertical = 10.vh, horizontal = 1.rem)
                }

                styledH1 {
                    css {
                        fontSize = 1.5.rem
                        marginBottom = 0.5.rem
                        marginTop = 1.rem
                    }

                    routeLink(to = "/repositories") {
                        styledSpan {
                            css {
                                color = Color.neutralLighter
                            }
                            +"Repositories"
                        }
                    }
                }

                styledP {
                    css {
                        margin(vertical = 0.5.rem, horizontal = 0.rem)
                    }

                    +"個人で開発しているソフトウェアのリポジトリです。"
                }

                repositoryList {
                    attrs.n = 3
                }
            }
        }

        section {
            styledDiv {
                css {
                    margin(vertical = 0.rem, horizontal = LinearDimension.auto)
                    maxWidth = Layout.extraLarge
                    padding(vertical = 10.vh, horizontal = 1.rem)
                }

                styledH1 {
                    css {
                        fontSize = 1.5.rem
                        marginBottom = 0.5.rem
                        marginTop = 1.rem
                    }

                    routeLink(to = "/books") {
                        styledSpan {
                            css {
                                color = Color.neutralPrimary
                            }
                            +"Books"
                        }
                    }
                }

                styledP {
                    css {
                        margin(vertical = 0.5.rem, horizontal = 0.rem)
                    }

                    +"これまでに読んだ本のリストです。"
                }

                bookList {
                    attrs.n = 3
                }
            }
        }
    }

}
