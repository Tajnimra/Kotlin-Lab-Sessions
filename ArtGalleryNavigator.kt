data class Artwork(
    val title: String,
    val artist: String,
    val year: Int
)

fun displayArtwork(artwork: Artwork) {
    println("----------------------------")
    println("Title : ${artwork.title}")
    println("Artist: ${artwork.artist}")
    println("Year  : ${artwork.year}")
    println("----------------------------")
}

fun main() {

    val gallery = listOf(
        Artwork("Mona Lisa", "Leonardo da Vinci", 1503),
        Artwork("Starry Night", "Vincent van Gogh", 1889),
        Artwork("The Scream", "Edvard Munch", 1893),
        Artwork("Girl with a Pearl Earring", "Johannes Vermeer", 1665)
    )

    var currentIndex = 0

    mainLoop@ while (true) {

        displayArtwork(gallery[currentIndex])

        println("Enter command (next / prev / exit):")
        val input = readLine()?.toLowerCase()

        when (input) {
            "next" -> {
                currentIndex = (currentIndex + 1) % gallery.size
            }

            "prev" -> {
                currentIndex = if (currentIndex - 1 < 0) {
                    gallery.size - 1
                } else {
                    currentIndex - 1
                }
            }

            "exit" -> {
                println("Exiting Art Gallery Navigator.")
                break@mainLoop
            }

            else -> {
                println("Invalid command. Try again.")
            }
        }
    }
}
