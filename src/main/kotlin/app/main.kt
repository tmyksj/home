package app

import app.css.Color
import app.page.*
import kotlinx.browser.window
import kotlinx.css.*
import kotlinx.css.properties.LineHeight
import kotlinx.css.properties.TextDecoration
import kotlinx.html.dom.append
import kotlinx.html.style
import kotlinx.html.unsafe
import react.Props
import react.createElement
import react.dom.client.createRoot
import react.router.Route
import react.router.Routes
import react.router.dom.BrowserRouter

fun main() {
    window.addEventListener("DOMContentLoaded", {
        val head: org.w3c.dom.Element = kotlinx.browser.document.head ?: return@addEventListener
        val root: web.dom.Element = web.dom.document.querySelector("#root") ?: return@addEventListener

        head.append {
            style {
                unsafe {
                    raw(CssBuilder().apply {
                        rule("a") {
                            color = Color.themeDarkAlt
                            textDecoration = TextDecoration.none
                        }

                        rule("a:hover") {
                            color = Color.themeDarker
                        }

                        rule("body") {
                            backgroundColor = Color.neutralLighter
                            color = Color.neutralPrimary
                            fontFamily = listOf(
                                "Segoe UI",
                                "SegoeUI",
                                "Yu Gothic UI",
                                "Meiryo UI",
                                "Helvetica Neue",
                                "Helvetica",
                                "Arial",
                                "sans-serif",
                            ).joinToString()
                            lineHeight = LineHeight("1.4")
                            margin(all = 0.rem)
                        }
                    }.toString())
                }
            }
        }

        createRoot(root).render(createElement<Props> {
            BrowserRouter {
                attrs.basename = head.querySelector("base")?.getAttribute("href") ?: ""

                Routes {
                    Route {
                        attrs.element = createElement(Home)
                        attrs.path = "/"
                    }

                    Route {
                        attrs.element = createElement(ArticleList)
                        attrs.path = "/articles"
                    }

                    Route {
                        attrs.element = createElement(Article)
                        attrs.path = "/articles/:uuid"
                    }

                    Route {
                        attrs.element = createElement(BookList)
                        attrs.path = "/books"
                    }

                    Route {
                        attrs.element = createElement(RepositoryList)
                        attrs.path = "/repositories"
                    }

                    Route {
                        attrs.element = createElement(SkillSet)
                        attrs.path = "/skills"
                    }

                    Route {
                        attrs.element = createElement(NotFound)
                        attrs.path = "/*"
                    }
                }
            }
        })
    })
}
