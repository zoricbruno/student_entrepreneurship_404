package hr.ferit.up404.laughly.ui

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Inspire : Screen("inspire")
    object Laugh : Screen("laugh")
    object Play : Screen("throw")
}
