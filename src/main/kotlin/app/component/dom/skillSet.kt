package app.component.dom

import app.component.skillSet.SkillSetProps
import app.component.skillSet.SkillSetRComponent
import react.RBuilder
import react.RHandler

fun RBuilder.skillSet(handler: RHandler<SkillSetProps>) {
    child(SkillSetRComponent::class, handler)
}
