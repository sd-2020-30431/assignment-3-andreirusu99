package server.db.report

import server.db.model.User

interface Report {
    fun computeWastedCalories(user: User): Int
}