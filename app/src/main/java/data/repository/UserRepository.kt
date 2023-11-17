// UserRepository.kt

package data.repository

import data.model.User
import kotlin.collections.MutableList


class UserRepository {
    // In a real-world scenario, you would typically interact with a backend or a database here

    // Simulating a list of users for demonstration purposes
    private val userList: MutableList<User> = mutableListOf()

    fun addUser(user: User) {
        // Add a new user to the list
        userList.add(user)
    }

    fun getUserById(userId: String): User? {
        // Find a user by their unique ID
        return userList.find { it.userId == userId }
    }

    fun getAllUsers(): List<User> {
        // Return the list of all users
        return userList.toList()
    }

    // Additional methods for user management can be added here
}
