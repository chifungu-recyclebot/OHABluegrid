// ReportedIssue.kt

package data.model

import android.util.Pair

data class ReportedIssue(
    val uniqueId: String, // Unique identifier for the reported issue
    val timestamp: Long, // Timestamp when the issue was reported
    val image: String, // URL or path to the image of the issue
    val issueType: String, // Type of the reported issue (e.g., Marine Plastics, Bin Overflow)
    val gps: Pair<Double, Double>, // GPS coordinates of the reported issue
    val computedAddress: String, // Computed address based on GPS coordinates
    val citizen: User, // User who reported the issue (Citizen)
    val assignedWasteManager: User?, // Assigned Waste Manager (null if not assigned yet)
    val status: IssueStatus // Enum representing the status of the reported issue
)

enum class IssueStatus {
    RESOLVED,
    PENDING,
    NOT_RESOLVED
}
