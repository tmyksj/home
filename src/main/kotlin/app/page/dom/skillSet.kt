package app.page.dom

import app.page.skillSet.SkillSetProps
import app.page.skillSet.SkillSetRComponent
import react.RBuilder
import react.RHandler

fun RBuilder.skillSet(handler: RHandler<SkillSetProps>) {
    child(SkillSetRComponent::class, handler)
}
