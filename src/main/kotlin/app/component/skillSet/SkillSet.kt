package app.component.skillSet

import app.css.Color
import app.dto.SkillDto
import app.js.d3.hierarchy.hierarchy
import app.js.d3.hierarchy.pack
import app.service.SkillService
import kotlinext.js.jsObject
import kotlinx.browser.window
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.css.FontWeight
import kotlinx.html.HTMLTag
import org.w3c.dom.DOMRect
import org.w3c.dom.HTMLElement
import org.w3c.dom.events.Event
import react.*
import react.dom.RDOMBuilder
import react.dom.div
import react.dom.svg
import react.dom.tag

class SkillSet : RComponent<SkillSetRProps, SkillSetRState>() {

    private val rReadableRef: RReadableRef<HTMLElement> = createRef()

    override fun SkillSetRState.init() {
        val coroutineScope: CoroutineScope = MainScope()

        coroutineScope.launch {
            val dtoList: List<SkillDto> = SkillService().fetchAll()
            setState {
                skillDtoList = dtoList
            }
        }
    }

    override fun componentDidMount() {
        window.addEventListener("resize", this::onResize)
        updateSize()
    }

    override fun componentWillUnmount() {
        window.removeEventListener("resize", this::onResize)
    }

    override fun RBuilder.render() {
        div {
            ref = rReadableRef

            val skillDtoList: List<SkillDto> = state.skillDtoList ?: return@div
            val height: Double = state.height ?: return@div
            val width: Double = state.width ?: return@div

            val data: dynamic = pack().size(arrayOf(height, height))(
                hierarchy(jsObject {
                    children = skillDtoList.toTypedArray()
                }).sum { it ->
                    val name: String = it.name as? String ?: return@sum 0
                    val max: Int = name.split(" ").map(String::length).maxOrNull() ?: return@sum 0
                    (max + 2) * (max + 2)
                }
            ).leaves()

            svg {
                attrs["height"] = height
                attrs["viewBox"] = "0 0 $width $height"
                attrs["width"] = width

                data.forEach { it ->
                    val name: String = it.data.name as String
                    val knowledge: Int = it.data.knowledge as Int

                    val x: Double = it.x as Double
                    val y: Double = it.y as Double

                    val textList: List<String> = name.split(" ")

                    tag("g") {
                        key = name

                        textList.forEachIndexed { index, s ->
                            tag("text") {
                                attrs["dominantBaseline"] = "middle"
                                attrs["fill"] = color(knowledge)
                                attrs["fontSize"] = fontSize()
                                attrs["fontWeight"] = FontWeight.w600
                                attrs["textAnchor"] = "middle"
                                attrs["x"] = x / height * width
                                attrs["y"] = y + fontSize() * index - fontSize() * textList.size / 2

                                key = s

                                +s
                            }
                        }
                    }
                }

                Unit
            }
        }
    }

    private fun color(knowledge: Int): kotlinx.css.Color {
        return listOf(
            Color.themeDarker,
            Color.themeDarkAlt,
            Color.themeSecondary,
            Color.themeLight,
            Color.themeLighterAlt,
        )[knowledge]
    }

    private fun fontSize(): Int {
        return 14
    }

    @Suppress("UNUSED_PARAMETER")
    private fun onResize(event: Event) {
        updateSize()
    }

    private fun updateSize() {
        val htmlElement: HTMLElement = rReadableRef.current ?: return
        val domRect: DOMRect = htmlElement.getBoundingClientRect()

        setState {
            height = minOf(domRect.right - domRect.left, 384.0)
            width = domRect.right - domRect.left
        }
    }

    private fun RBuilder.tag(tagName: String, block: RDOMBuilder<HTMLTag>.() -> Unit): ReactElement {
        return tag(block) {
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
