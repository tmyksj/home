package app.component.dom

import app.component.skillSet.SkillSetRComponent
import app.component.skillSet.SkillSetRProps
import react.RBuilder
import react.RHandler
import react.ReactElement

fun RBuilder.skillSet(handler: RHandler<SkillSetRProps>): ReactElement {
    return child(SkillSetRComponent::class, handler)
}
