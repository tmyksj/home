package app.domain.repository

import app.domain.repository.dto.RepositoryDto
import kotlinx.browser.window
import kotlinx.coroutines.await
import org.w3c.fetch.Response

class RepositoryDomain {

    suspend fun fetchAll(): List<RepositoryDto> {
        val response: Response = window.fetch("assets/repositories.json").await()
        val responseJson: dynamic = response.json().await().asDynamic()
        val repositories: Array<dynamic> = responseJson.repositories as Array<dynamic>

        return repositories.map {
            RepositoryDto(
                description = it.description as String?,
                hrefDeploy = it.hrefDeploy as String?,
                hrefGitHub = it.hrefGitHub as String?,
                imgSrc = it.imgSrc as String?,
                name = it.name as String?,
            )
        }.toList()
    }

}
