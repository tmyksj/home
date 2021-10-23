package app.service

import app.dto.ArticleDto
import kotlinx.browser.window
import kotlinx.coroutines.await
import org.w3c.fetch.Response
import kotlin.js.Date

class ArticleService {

    suspend fun fetchAll(): List<ArticleDto> {
        val response: Response = window.fetch("assets/articles.json").await()
        val responseJson: dynamic = response.json().await().asDynamic()
        val articles: Array<dynamic> = responseJson.articles as Array<dynamic>

        return articles.map {
            ArticleDto(
                uuid = it.uuid as String,
                name = it.name as String,
                body = "",
                createdDate = (it.createdDate as String).toDate(),
                lastModifiedDate = (it.lastModifiedDate as String).toDate(),
            )
        }.toList().sortedByDescending {
            it.lastModifiedDate.getTime()
        }
    }

    suspend fun fetchByUuid(uuid: String): ArticleDto? {
        val articleDto: ArticleDto = fetchAll().firstOrNull { it.uuid == uuid } ?: return null

        val response = window.fetch("assets/articles/${uuid}/index.md").await()
        val responseText: String = response.text().await()

        return articleDto.copy(body = responseText)
    }

    private fun String.toDate(): Date {
        val s: List<String> = split(delimiters = arrayOf("-"))
        return Date(year = s[0].toInt(), month = s[1].toInt() - 1, day = s[2].toInt())
    }

}
