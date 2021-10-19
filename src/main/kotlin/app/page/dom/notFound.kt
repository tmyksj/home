package app.page.dom

import app.page.notFound.NotFoundProps
import app.page.notFound.NotFoundRComponent
import react.RBuilder
import react.RHandler

fun RBuilder.notFound(handler: RHandler<NotFoundProps>) {
    child(NotFoundRComponent::class, handler)
}
