package app.service

import app.dto.RepositoryDto
import kotlinx.browser.window
import kotlinx.coroutines.await
import org.w3c.fetch.Response

class RepositoryService {

    suspend fun fetchAll(): List<RepositoryDto> {
        val response: Response = window.fetch("assets/repositories.json").await()
        val responseJson: dynamic = response.json().await().asDynamic()
        val repositories: Array<dynamic> = responseJson.repositories as Array<dynamic>

        return repositories.map {
            RepositoryDto(
                name = it.name as String,
                description = it.description as String,
                imgSrc = it.imgSrc as String,
                hrefGitHub = it.hrefGitHub as String,
                hrefDeploy = it.hrefDeploy as String?,
            )
        }.toList()
    }

}
