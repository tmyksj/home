@file:JsModule("@fluentui/react")
@file:JsNonModule

package app.js.fluentui.react

import react.FC
import react.Props

external val DefaultButton: FC<DefaultButtonProps>

external interface DefaultButtonProps : Props {

    var href: String?

    var rel: String?

    var target: String?

}
