package app.component.dom

import app.component.defaultHeader.DefaultHeader
import app.component.defaultHeader.DefaultHeaderRProps
import react.RBuilder
import react.RHandler
import react.ReactElement

fun RBuilder.defaultHeader(handler: RHandler<DefaultHeaderRProps>): ReactElement {
    return child(DefaultHeader::class, handler)
}
