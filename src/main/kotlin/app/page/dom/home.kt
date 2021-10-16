package app.page.dom

import app.page.home.HomeRComponent
import app.page.home.HomeRProps
import react.RBuilder
import react.RHandler
import react.ReactElement

fun RBuilder.home(handler: RHandler<HomeRProps>): ReactElement {
    return child(HomeRComponent::class, handler)
}
