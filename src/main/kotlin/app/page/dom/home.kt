package app.page.dom

import app.page.home.Home
import app.page.home.HomeRProps
import react.RBuilder
import react.RHandler
import react.ReactElement

fun RBuilder.home(handler: RHandler<HomeRProps>): ReactElement {
    return child(Home::class, handler)
}
