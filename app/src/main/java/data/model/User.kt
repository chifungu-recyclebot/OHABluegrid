package data.model



data class User(
    val userId: String, // Unique identifier for the user
    val username: String,
    val email: String,
    val role: UserRole // Enum representing user roles (Citizen, WasteManager, Admin)
)

enum class UserRole {
    CITIZEN,
    WASTE_MANAGER,
    ADMIN
}
