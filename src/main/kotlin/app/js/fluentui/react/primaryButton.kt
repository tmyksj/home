@file:JsModule("@fluentui/react")
@file:JsNonModule

package app.js.fluentui.react

import react.ComponentClass
import react.Props

@JsName("PrimaryButton")
external val primaryButton: ComponentClass<PrimaryButtonProps>

external interface PrimaryButtonProps : Props {

    var href: String?

    var rel: String?

    var target: String?

}
