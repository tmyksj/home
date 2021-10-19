package app.component.dom

import app.component.notFound.NotFoundProps
import app.component.notFound.NotFoundRComponent
import react.RBuilder
import react.RHandler

fun RBuilder.notFound(handler: RHandler<NotFoundProps>) {
    child(NotFoundRComponent::class, handler)
}
