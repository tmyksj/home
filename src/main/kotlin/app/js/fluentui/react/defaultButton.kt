@file:JsModule("@fluentui/react")
@file:JsNonModule

package app.js.fluentui.react

import react.ComponentClass
import react.Props

@JsName("DefaultButton")
external val defaultButton: ComponentClass<DefaultButtonProps>

external interface DefaultButtonProps : Props {

    var href: String?

    var rel: String?

    var target: String?

}
