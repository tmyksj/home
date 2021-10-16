package app.page.dom

import app.page.notFound.NotFoundRComponent
import app.page.notFound.NotFoundRProps
import react.RBuilder
import react.RHandler
import react.ReactElement

fun RBuilder.notFound(handler: RHandler<NotFoundRProps>): ReactElement {
    return child(NotFoundRComponent::class, handler)
}
