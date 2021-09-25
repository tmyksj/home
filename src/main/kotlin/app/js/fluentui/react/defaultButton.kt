@file:JsModule("@fluentui/react")
@file:JsNonModule

package app.js.fluentui.react

import react.RClass
import react.RProps

@JsName("DefaultButton")
external val defaultButton: RClass<DefaultButtonRProps>

external interface DefaultButtonRProps : RProps {

    var href: String?

    var rel: String?

    var target: String?

}
