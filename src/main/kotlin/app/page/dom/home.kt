package app.page.dom

import app.page.home.HomeProps
import app.page.home.HomeRComponent
import react.RBuilder
import react.RHandler

fun RBuilder.home(handler: RHandler<HomeProps>) {
    child(HomeRComponent::class, handler)
}
