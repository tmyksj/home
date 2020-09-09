package app.component.repositoryList

import app.domain.repository.dto.RepositoryDto
import react.RState

external interface RepositoryListRState : RState {

    var repositoryDtoList: List<RepositoryDto>?

}
