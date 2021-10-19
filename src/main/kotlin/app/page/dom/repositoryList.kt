package app.page.dom

import app.page.repositoryList.RepositoryListProps
import app.page.repositoryList.RepositoryListRComponent
import react.RBuilder
import react.RHandler

fun RBuilder.repositoryList(handler: RHandler<RepositoryListProps>) {
    child(RepositoryListRComponent::class, handler)
}
