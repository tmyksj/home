package app.page.dom

import app.page.repositoryList.RepositoryList
import app.page.repositoryList.RepositoryListRProps
import react.RBuilder
import react.RHandler
import react.ReactElement

fun RBuilder.repositoryList(handler: RHandler<RepositoryListRProps>): ReactElement {
    return child(RepositoryList::class, handler)
}
