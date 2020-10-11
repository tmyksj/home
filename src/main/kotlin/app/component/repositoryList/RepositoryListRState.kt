package app.component.repositoryList

import app.dto.RepositoryDto
import react.RState

external interface RepositoryListRState : RState {

    var repositoryDtoList: List<RepositoryDto>?

}
