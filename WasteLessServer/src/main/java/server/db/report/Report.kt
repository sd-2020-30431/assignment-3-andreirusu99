package server.db.report

interface Report {
    fun computeWastedCalories(userId: Int): ReportDTO
}