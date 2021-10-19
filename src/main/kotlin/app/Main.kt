package app

import app.css.Color
import app.page.dom.*
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.css.*
import kotlinx.css.properties.LineHeight
import kotlinx.css.properties.TextDecoration
import kotlinx.html.dom.append
import kotlinx.html.style
import kotlinx.html.unsafe
import react.dom.render
import react.router.dom.BrowserRouter
import react.router.dom.Route
import react.router.dom.Switch

fun main() {
    window.addEventListener("DOMContentLoaded", {
        document.head?.append {
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

        render(document.querySelector("#root")) {
            BrowserRouter {
                attrs.basename = document.head?.querySelector("base")?.getAttribute("href") ?: ""

                Switch {
                    Route {
                        attrs.path = arrayOf("/")
                        attrs.exact = true
                        home { }
                    }

                    Route {
                        attrs.path = arrayOf("/books")
                        attrs.exact = true
                        bookList { }
                    }

                    Route {
                        attrs.path = arrayOf("/repositories")
                        attrs.exact = true
                        repositoryList { }
                    }

                    Route {
                        attrs.path = arrayOf("/skills")
                        attrs.exact = true
                        skillSet { }
                    }

                    Route {
                        attrs.path = arrayOf("/")
                        notFound { }
                    }
                }
            }
        }
    })
}
