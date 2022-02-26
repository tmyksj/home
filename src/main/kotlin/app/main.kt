package app

import app.css.Color
import app.page.*
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.css.*
import kotlinx.css.properties.LineHeight
import kotlinx.css.properties.TextDecoration
import kotlinx.html.dom.append
import kotlinx.html.style
import kotlinx.html.unsafe
import org.w3c.dom.Element
import react.createElement
import react.dom.render
import react.router.Route
import react.router.Routes
import react.router.dom.BrowserRouter

fun main() {
    window.addEventListener("DOMContentLoaded", {
        val head: Element = document.head ?: return@addEventListener
        val root: Element = document.querySelector("#root") ?: return@addEventListener

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

        render(root) {
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
        }
    })
}