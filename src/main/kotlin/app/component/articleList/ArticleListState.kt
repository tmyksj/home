package app.component.articleList

import app.dto.ArticleDto
import react.State

external interface ArticleListState : State {

    var articleDtoList: List<ArticleDto>?

}
