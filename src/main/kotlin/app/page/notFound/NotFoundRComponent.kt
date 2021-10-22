package app.page.notFound

import app.component.dom.NotFound
import react.RBuilder
import react.RComponent

class NotFoundRComponent : RComponent<NotFoundProps, NotFoundState>() {

    override fun RBuilder.render() {
        NotFound { }
    }

}
