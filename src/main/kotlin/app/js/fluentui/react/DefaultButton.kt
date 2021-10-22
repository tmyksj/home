@file:JsModule("@fluentui/react")
@file:JsNonModule

package app.js.fluentui.react

import react.ComponentClass
import react.Props

external val DefaultButton: ComponentClass<DefaultButtonProps>

external interface DefaultButtonProps : Props {

    var href: String?

    var rel: String?

    var target: String?

}
