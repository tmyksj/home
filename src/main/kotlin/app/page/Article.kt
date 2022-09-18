package app.page

import app.component.DateString
import app.component.DefaultHeader
import app.component.NotFound
import app.css.Color
import app.css.Layout
import app.dto.ArticleDto
import app.service.ArticleService
import kotlinx.browser.document
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.css.*
import kotlinx.html.unsafe
import kotlinx.js.get
import org.intellij.markdown.ast.ASTNode
import org.intellij.markdown.flavours.MarkdownFlavourDescriptor
import org.intellij.markdown.flavours.commonmark.CommonMarkFlavourDescriptor
import org.intellij.markdown.html.HtmlGenerator
import org.intellij.markdown.parser.MarkdownParser
import react.FC
import react.fc
import react.router.Params
import react.router.useParams
import react.useEffectOnce
import react.useState
import styled.*

val Article: FC<ArticleProps> = fc {
    val params: Params = useParams()

    var articleDto by useState<ArticleDto?>(null)
    var exists by useState<Boolean?>(null)

    fun markdownToHtml(markdown: String): String {
        val tagRenderer: HtmlGenerator.TagRenderer = object : HtmlGenerator.DefaultTagRenderer(
            customizer = { _, tagName, attributes ->
                when (tagName) {
                    "a" -> attributes + listOf("rel=\"nofollow noopener noreferrer\"", "target=\"_blank\"")
                    else -> attributes
                }
            },
            includeSrcPositions = false,
        ) {

            override fun openTag(
                node: ASTNode,
                tagName: CharSequence,
                vararg attributes: CharSequence?,
                autoClose: Boolean,
            ): CharSequence {
                return when (tagName) {
                    "body" -> ""
                    else -> super.openTag(node, tagName, *attributes, autoClose = autoClose)
                }
            }

            override fun closeTag(tagName: CharSequence): CharSequence {
                return when (tagName) {
                    "body" -> ""
                    else -> super.closeTag(tagName)
                }
            }

        }

        val markdownFlavourDescriptor: MarkdownFlavourDescriptor = CommonMarkFlavourDescriptor()
        val astNode: ASTNode = MarkdownParser(markdownFlavourDescriptor).buildMarkdownTreeFromString(markdown)

        return HtmlGenerator(markdown, astNode, markdownFlavourDescriptor).generateHtml(tagRenderer)
    }

    useEffectOnce {
        MainScope().launch {
            val uuid: String = params["uuid"] ?: return@launch

            val dto: ArticleDto? = ArticleService().fetchByUuid(uuid)
            articleDto = dto
            exists = dto != null

            document.title = dto?.name ?: "Not Found"
        }
    }

    if (exists == null || exists == true) {
        DefaultHeader { }

        articleDto?.let {
            styledSection {
                css {
                    margin(vertical = 4.rem, horizontal = LinearDimension.auto)
                    maxWidth = Layout.extraLarge
                    padding(vertical = 0.rem, horizontal = 1.rem)
                }

                styledH1 {
                    css {
                        fontSize = 1.5.rem
                        marginBottom = 0.5.rem
                        marginTop = 1.rem
                    }

                    +it.name
                }

                styledSpan {
                    css {
                        color = Color.neutralSecondary
                        display = Display.block
                        fontSize = 0.8.rem
                    }

                    DateString {
                        attrs.date = it.lastModifiedDate
                        attrs.suffix = "更新"
                    }
                }

                styledDiv {
                    css {
                        margin(vertical = 3.rem, horizontal = 0.rem)

                        code {
                            backgroundColor = Color.neutralLight
                            borderRadius = 0.125.rem
                            fontSize = 0.8.rem
                            padding(vertical = 0.rem, horizontal = 0.5.rem)
                        }

                        h2 {
                            fontSize = 1.2.rem
                            margin(top = 3.rem, horizontal = 0.rem, bottom = 0.rem)
                        }

                        h3 {
                            fontSize = 1.1.rem
                            margin(top = 3.rem, horizontal = 0.rem, bottom = 0.rem)
                        }

                        p {
                            margin(vertical = 0.8.rem, horizontal = 0.rem)
                        }

                        pre {
                            backgroundColor = Color.neutralLight
                            borderRadius = 0.125.rem
                            margin(vertical = 0.8.rem, horizontal = 0.rem)
                            overflowX = Overflow.auto
                            padding(all = 0.8.rem)

                            code {
                                padding(all = 0.rem)
                            }
                        }

                        ul {
                            margin(vertical = 0.8.rem, horizontal = 0.rem)
                        }
                    }

                    attrs.unsafe {
                        +markdownToHtml(it.body)
                    }
                }
            }
        }
    } else {
        NotFound { }
    }
}
