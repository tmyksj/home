package app.page.notFound

import app.component.dom.notFound
import react.RBuilder
import react.RComponent

class NotFoundRComponent : RComponent<NotFoundProps, NotFoundState>() {

    override fun RBuilder.render() {
        notFound { }
    }

}
