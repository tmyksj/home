package app.component.dom

import app.component.repositoryList.RepositoryListProps
import app.component.repositoryList.RepositoryListRComponent
import react.RBuilder
import react.RHandler

fun RBuilder.repositoryList(handler: RHandler<RepositoryListProps>) {
    child(RepositoryListRComponent::class, handler)
}
