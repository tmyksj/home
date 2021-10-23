package app.component.dom

import app.component.articleList.ArticleListProps
import app.component.articleList.ArticleListRComponent
import react.ComponentClass
import react.router.dom.withRouter

val ArticleList: ComponentClass<ArticleListProps> = withRouter(ArticleListRComponent::class)
