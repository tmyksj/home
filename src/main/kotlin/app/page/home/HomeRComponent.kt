package app.page.home

import app.component.dom.ArticleList
import app.component.dom.BookList
import app.component.dom.RepositoryList
import app.component.dom.SkillSet
import app.css.Color
import app.css.Layout
import kotlinx.css.*
import kotlinx.html.HTMLTag
import react.RBuilder
import react.RComponent
import react.dom.*
import react.router.dom.Link
import styled.*

class HomeRComponent : RComponent<HomeProps, HomeState>() {

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

        styledSvg {
            css {
                height = 20.vh
                width = 100.pct
            }

            attrs["preserveAspectRatio"] = "none"
            attrs["viewBox"] = "0 0 1 1"

            tag("path") {
                attrs["d"] = "M 0 0 L 1 0 L 1 0.875 L 0.9375 0.875 C 0.625 0.875 0.5 0.5 0 0.75"
                attrs["fill"] = Color.neutralDark
            }
        }

        section {
            styledDiv {
                css {
                    margin(vertical = 0.rem, horizontal = LinearDimension.auto)
                    maxWidth = Layout.extraLarge
                    padding(top = 5.vh, horizontal = 1.rem, bottom = 10.vh)
                }

                styledH1 {
                    css {
                        fontSize = 1.5.rem
                        marginBottom = 0.5.rem
                        marginTop = 1.rem
                    }

                    Link {
                        attrs.to = "/articles"

                        styledSpan {
                            css {
                                color = Color.neutralPrimary
                            }

                            +"Articles"
                        }
                    }
                }

                styledP {
                    css {
                        margin(vertical = 0.5.rem, horizontal = 0.rem)
                    }

                    +"やったこと／試したことをまとめた記事です。"
                }

                ArticleList {
                    attrs.n = 3
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

                    Link {
                        attrs.to = "/repositories"

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

                RepositoryList {
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

                    Link {
                        attrs.to = "/books"

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

                BookList {
                    attrs.n = 3
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

                    Link {
                        attrs.to = "/skills"

                        styledSpan {
                            css {
                                color = Color.neutralLighter
                            }

                            +"Skills"
                        }
                    }
                }

                styledP {
                    css {
                        margin(vertical = 0.5.rem, horizontal = 0.rem)
                    }

                    +"スキルセットです。"
                }

                SkillSet {
                    attrs.darkMode = true
                }
            }
        }
    }

    private fun RBuilder.tag(tagName: String, block: RDOMBuilder<HTMLTag>.() -> Unit) {
        tag(block) {
            HTMLTag(
                tagName = tagName,
                consumer = it,
                initialAttributes = mapOf(),
                namespace = null,
                inlineTag = true,
                emptyTag = false,
            )
        }
    }

}
