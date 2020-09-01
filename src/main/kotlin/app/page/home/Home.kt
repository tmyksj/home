package app.page.home

import app.component.dom.repository
import kotlinx.css.*
import react.RBuilder
import react.RComponent
import react.dom.a
import react.dom.li
import styled.*

class Home : RComponent<HomeRProps, HomeRState>() {

    override fun RBuilder.render() {
        styledSection {
            css {
                alignItems = Align.center
                display = Display.flex
                height = 80.vh
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
                                attrs.rel = "nofollow noreferrer noopener"
                                attrs.target = "_blank"
                                +"atcoder"
                            }
                        }
                        li {
                            a {
                                attrs.href = "https://facebook.com/tmyksj"
                                attrs.rel = "nofollow noreferrer noopener"
                                attrs.target = "_blank"
                                +"facebook"
                            }
                        }
                        li {
                            a {
                                attrs.href = "https://github.com/tmyksj"
                                attrs.rel = "nofollow noreferrer noopener"
                                attrs.target = "_blank"
                                +"github"
                            }
                        }
                        li {
                            a {
                                attrs.href = "https://twitter.com/tmyksj"
                                attrs.rel = "nofollow noreferrer noopener"
                                attrs.target = "_blank"
                                +"twitter"
                            }
                        }
                    }
                }

                styledImg {
                    css {
                        borderColor = Color("#d2d0ce")
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
                backgroundColor = Color("#201f1e")
                color = Color("#faf9f8")
                margin(vertical = 10.vh, horizontal = 0.rem)
            }

            styledDiv {
                css {
                    margin(vertical = 0.rem, horizontal = LinearDimension.auto)
                    maxWidth = 80.rem
                    padding(vertical = 10.vh, horizontal = 1.rem)
                }

                styledH1 {
                    css {
                        fontSize = 1.5.rem
                        margin(vertical = 1.rem, horizontal = 0.rem)
                    }

                    +"Repositories"
                }

                styledDiv {
                    css {
                        margin(vertical = 3.rem, horizontal = 0.rem)
                    }

                    repository {
                        attrs.description = "競技プログラミングの参考情報"
                        attrs.hrefDeploy = "https://tmyksj.github.io/refkyopro"
                        attrs.hrefGitHub = "https://github.com/tmyksj/refkyopro"
                        attrs.repositoryName = "refkyopro"
                        attrs.srcImg = "assets/refkyopro.png"
                    }
                }

                styledDiv {
                    css {
                        margin(vertical = 3.rem, horizontal = 0.rem)
                    }

                    repository {
                        attrs.description = "やってみたいことを可視化して、何をするかを決めやすく、何をしたか把握しやすく"
                        attrs.hrefDeploy = "https://tmyksj.github.io/try-vis"
                        attrs.hrefGitHub = "https://github.com/tmyksj/try-vis"
                        attrs.repositoryName = "try-vis"
                        attrs.srcImg = "assets/try-vis.png"
                    }
                }

                styledDiv {
                    css {
                        margin(vertical = 3.rem, horizontal = 0.rem)
                    }

                    repository {
                        attrs.description = "ywt を書く日記"
                        attrs.hrefGitHub = "https://github.com/tmyksj/ywtdiary"
                        attrs.repositoryName = "ywtdiary"
                        attrs.srcImg = "assets/ywtdiary.png"
                    }
                }
            }
        }
    }

}
