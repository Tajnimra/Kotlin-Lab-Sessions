// Data class for Theme
data class Theme(val name: String, val primaryColor: String, val backgroundColor: String)

// Function to apply theme
fun applyTheme(theme: Theme) {
    println("\nApplying Theme: ${theme.name}")
    println("Primary Color: ${theme.primaryColor}")
    println("Background Color: ${theme.backgroundColor}")
}

// Function to animate progress bar
fun animateProgressBar() {
    print("\nLoading: ")
    for (i in 1..20) {
        print("#")
        Thread.sleep(150)   // delay to simulate animation
    }
    println(" Done!")
}

fun main() {

    // Define themes
    val lightTheme = Theme("Light Theme", "Blue", "White")
    val darkTheme = Theme("Dark Theme", "Purple", "Black")

    println("Theme Switching Simulation")

    // Apply Light Theme
    applyTheme(lightTheme)
    animateProgressBar()

    // Apply Dark Theme
    applyTheme(darkTheme)
    animateProgressBar()

    println("\nTheme switch and animation completed.")
}
