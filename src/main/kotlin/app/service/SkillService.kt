package app.service

import app.dto.SkillDto
import kotlinx.browser.window
import kotlinx.coroutines.await
import org.w3c.fetch.Response

class SkillService {

    suspend fun fetchAll(): List<SkillDto> {
        val response: Response = window.fetch("assets/skills.json").await()
        val responseJson: dynamic = response.json().await().asDynamic()
        val skills: Array<dynamic> = responseJson.skills as Array<dynamic>

        return skills.map {
            SkillDto(
                name = it.name as String,
                knowledge = it.knowledge as Int,
            )
        }.toList()
    }

}
