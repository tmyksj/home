package app.page.article

import app.dto.ArticleDto
import react.State

external interface ArticleState : State {

    var articleDto: ArticleDto?

    var exists: Boolean?

}
