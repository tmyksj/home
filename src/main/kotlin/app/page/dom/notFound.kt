package app.page.dom

import app.page.notFound.NotFound
import app.page.notFound.NotFoundRProps
import react.RBuilder
import react.RHandler
import react.ReactElement

fun RBuilder.notFound(handler: RHandler<NotFoundRProps>): ReactElement {
    return child(NotFound::class, handler)
}
