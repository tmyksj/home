@file:JsModule("@fluentui/react")
@file:JsNonModule

package app.js.fluentui.react

import react.FC
import react.Props
import react.dom.events.MouseEventHandler
import web.dom.Element

external val PrimaryButton: FC<PrimaryButtonProps>

external interface PrimaryButtonProps : Props {

    var href: String?

    var onClick: MouseEventHandler<Element>

    var rel: String?

    var target: String?

}
