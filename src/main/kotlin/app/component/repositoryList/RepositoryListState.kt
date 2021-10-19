package app.component.repositoryList

import app.dto.RepositoryDto
import react.State

external interface RepositoryListState : State {

    var repositoryDtoList: List<RepositoryDto>?

}
