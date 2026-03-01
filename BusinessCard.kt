data class Contact(
    val phone: String,
    val email: String,
    val website: String
)

fun renderBorder(width: Int): String {
    return "+" + "-".repeat(width - 2) + "+\n"
}

fun renderCenteredText(text: String, width: Int): String {
    val contentWidth = width - 2
    val padding = (contentWidth - text.length) / 2
    val line = " ".repeat(padding) + text +
            " ".repeat(contentWidth - padding - text.length)
    return "|$line|\n"
}

fun renderLogo(width: Int): String {
    val builder = StringBuilder()
    builder.append(renderCenteredText("*** My Company ***", width))
    builder.append(renderCenteredText("Innovate. Create. Inspire.", width))
    return builder.toString()
}

fun renderHeader(name: String, title: String, width: Int): String {
    val builder = StringBuilder()
    builder.append(renderCenteredText(name, width))
    builder.append(renderCenteredText(title, width))
    return builder.toString()
}

fun renderContact(contact: Contact, width: Int): String {
    val builder = StringBuilder()
    builder.append(renderCenteredText("Phone: ${contact.phone}", width))
    builder.append(renderCenteredText("Email: ${contact.email}", width))
    builder.append(renderCenteredText("Web: ${contact.website}", width))
    return builder.toString()
}

fun renderBusinessCard(
    name: String,
    title: String,
    contact: Contact,
    width: Int = 40
): String {
    val builder = StringBuilder()

    builder.append(renderBorder(width))
    builder.append(renderLogo(width))
    builder.append(renderBorder(width))
    builder.append(renderHeader(name, title, width))
    builder.append(renderBorder(width))
    builder.append(renderContact(contact, width))
    builder.append(renderBorder(width))

    return builder.toString()
}

fun main() {
    val contact = Contact(
        phone = "+91 9876543210",
        email = "nimra@email.com",
        website = "www.mycompany.com"
    )

    val card = renderBusinessCard(
        name = "Nimra Taj",
        title = "Software Engineer",
        contact = contact,
        width = 40
    )

    println(card)
}
