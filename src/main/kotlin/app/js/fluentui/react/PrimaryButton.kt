@file:JsModule("@fluentui/react")
@file:JsNonModule

package app.js.fluentui.react

import org.w3c.dom.Element
import react.ComponentClass
import react.Props
import react.dom.events.MouseEventHandler

external val PrimaryButton: ComponentClass<PrimaryButtonProps>

external interface PrimaryButtonProps : Props {

    var href: String?

    var onClick: MouseEventHandler<Element>

    var rel: String?

    var target: String?

}
