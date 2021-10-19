package app.css

import kotlinx.css.*

object Layout {

    val extraLarge: LinearDimension = 85.375.rem

    val mediaMedium: (CssBuilder, RuleSet) -> Rule = { cssBuilder, block ->
        cssBuilder.media("(max-width: 40rem)", block)
    }

}
