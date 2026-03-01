data class Contact(
    val name: String,
    val phone: String?,
    val email: String?,
    val isFavorite: Boolean
)

fun addContact(
    contacts: MutableList<Contact>,
    name: String,
    phone: String?,
    email: String?,
    isFavorite: Boolean
) {
    contacts.add(Contact(name, phone, email, isFavorite))
}

fun displayContacts(contacts: List<Contact>) {
    if (contacts.isEmpty()) {
        println("No contacts found.")
        return
    }

    for (contact in contacts) {
        println("----------------------------")
        println("Name: ${contact.name}")
        println("Phone: ${contact.phone ?: "Not Available"}")
        println("Email: ${contact.email ?: "Not Available"}")
        println("Favorite: ${if (contact.isFavorite) "Yes" else "No"}")
    }
    println("----------------------------")
}

// Higher-order function for filtering
fun filterContacts(
    contacts: List<Contact>,
    filterCondition: (Contact) -> Boolean
): List<Contact> {
    return contacts.filter(filterCondition)
}

fun main() {

    val contacts = mutableListOf<Contact>()

    // Adding sample contacts
    addContact(contacts, "Nimra Taj", "9876543210", "nimra@email.com", true)
    addContact(contacts, "Alan Turing", null, "alan@email.com", false)
    addContact(contacts, "Ada Lovelace", "1234567890", null, true)
    addContact(contacts, "Katherine Johnson", null, null, false)

    println("All Contacts:")
    displayContacts(contacts)

    println("\nFavorite Contacts:")
    val favoriteContacts = filterContacts(contacts) { it.isFavorite }
    displayContacts(favoriteContacts)

    println("\nContacts With Email:")
    val emailContacts = filterContacts(contacts) { it.email != null }
    displayContacts(emailContacts)
}
