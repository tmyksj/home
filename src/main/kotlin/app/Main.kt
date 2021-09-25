package app

import app.css.Color
import app.page.dom.bookList
import app.page.dom.home
import app.page.dom.notFound
import app.page.dom.repositoryList
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.css.*
import kotlinx.css.properties.LineHeight
import kotlinx.css.properties.TextDecoration
import kotlinx.html.dom.append
import kotlinx.html.style
import kotlinx.html.unsafe
import react.dom.render
import react.router.dom.browserRouter
import react.router.dom.route
import react.router.dom.switch

fun main() {
    window.addEventListener("DOMContentLoaded", {
        document.head?.append {
            style {
                unsafe {
                    raw(CSSBuilder().apply {
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
            browserRouter(basename = document.head?.querySelector("base")?.getAttribute("href") ?: "") {
                switch {
                    route(path = arrayOf("/"), exact = true) { home { } }
                    route(path = arrayOf("/books"), exact = true) { bookList { } }
                    route(path = arrayOf("/repositories"), exact = true) { repositoryList { } }
                    route(path = arrayOf("/")) { notFound { } }
                }
            }
        }
    })
}
