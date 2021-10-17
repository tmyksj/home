package app.component.dom

import app.component.notFound.NotFoundRComponent
import app.component.notFound.NotFoundRProps
import react.RBuilder
import react.RHandler
import react.ReactElement

fun RBuilder.notFound(handler: RHandler<NotFoundRProps>): ReactElement {
    return child(NotFoundRComponent::class, handler)
}
