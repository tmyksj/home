package app.component

import app.css.Color
import app.dto.SkillDto
import app.js.d3.hierarchy.hierarchy
import app.js.d3.hierarchy.pack
import app.service.SkillService
import kotlinx.browser.window
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.css.FontWeight
import kotlinx.html.HTMLTag
import kotlinx.js.jso
import org.w3c.dom.DOMRect
import org.w3c.dom.HTMLElement
import org.w3c.dom.events.Event
import react.*
import react.dom.RDOMBuilder
import react.dom.div
import react.dom.svg
import react.dom.tag

val SkillSet: FC<SkillSetProps> = fc { props ->
    var skillDtoList by useState<List<SkillDto>>(listOf())
    var height by useState(0.0)
    var width by useState(0.0)

    val refObject: RefObject<HTMLElement> = useRef()

    fun color(knowledge: Int): kotlinx.css.Color {
        return if (props.darkMode == true) {
            listOf(
                Color.themeDarker,
                Color.themeDarkAlt,
                Color.themeSecondary,
                Color.themeLight,
                Color.themeLighterAlt,
            )[knowledge]
        } else {
            listOf(
                Color.themeLight,
                Color.themeTertiary,
                Color.themeSecondary,
                Color.themeDarkAlt,
                Color.themeDarker,
            )[knowledge]
        }
    }

    fun fontSize(): Int {
        return 14
    }

    fun updateSize() {
        val htmlElement: HTMLElement = refObject.current ?: return
        val domRect: DOMRect = htmlElement.getBoundingClientRect()

        height = minOf(domRect.right - domRect.left, 384.0)
        width = domRect.right - domRect.left
    }

    fun RBuilder.tag(tagName: String, block: RDOMBuilder<HTMLTag>.() -> Unit) {
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

    useEffectOnce {
        MainScope().launch {
            skillDtoList = SkillService().fetchAll()
        }

        val onResize: (Event) -> Unit = { updateSize() }

        window.addEventListener("resize", onResize)
        cleanup { window.removeEventListener("resize", onResize) }

        updateSize()
    }

    div {
        ref = refObject

        if (skillDtoList.isEmpty()) {
            return@div
        }

        val data: dynamic = pack().size(arrayOf(height, height))(
            hierarchy(
                jso {
                    children = skillDtoList.map {
                        jso<dynamic> {
                            name = it.name
                            knowledge = it.knowledge
                        }
                    }.toTypedArray()
                }
            ).sum { it ->
                val name: String = it.name as? String ?: return@sum 0
                val max: Int = name.split(" ").maxOfOrNull(String::length) ?: return@sum 0
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
