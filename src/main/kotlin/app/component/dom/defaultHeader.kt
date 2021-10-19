package app.component.dom

import app.component.defaultHeader.DefaultHeaderProps
import app.component.defaultHeader.DefaultHeaderRComponent
import react.RBuilder
import react.RHandler

fun RBuilder.defaultHeader(handler: RHandler<DefaultHeaderProps>) {
    child(DefaultHeaderRComponent::class, handler)
}
