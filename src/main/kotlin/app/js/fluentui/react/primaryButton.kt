@file:JsModule("@fluentui/react")
@file:JsNonModule

package app.js.fluentui.react

import react.RClass
import react.RProps

@JsName("PrimaryButton")
external val primaryButton: RClass<PrimaryButtonRProps>

external interface PrimaryButtonRProps : RProps {

    var href: String?

    var rel: String?

    var target: String?

}
