package app.component.dom

import app.component.repositoryList.RepositoryList
import app.component.repositoryList.RepositoryListRProps
import react.RBuilder
import react.RHandler
import react.ReactElement

fun RBuilder.repositoryList(handler: RHandler<RepositoryListRProps>): ReactElement {
    return child(RepositoryList::class, handler)
}
