package app.component.dom

import app.component.repository.Repository
import app.component.repository.RepositoryRProps
import react.RBuilder
import react.RHandler
import react.ReactElement

fun RBuilder.repository(handler: RHandler<RepositoryRProps>): ReactElement {
    return child(Repository::class, handler)
}
