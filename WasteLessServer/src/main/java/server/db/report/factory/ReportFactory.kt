package server.db.report.factory

import server.db.report.Report
import server.db.report.entity.MonthlyReport
import server.db.report.entity.WeeklyReport

class ReportFactory {
    fun getReport(reportType: String): Report {
        if (reportType == "WEEKLY") {
            return WeeklyReport()
        }
        return MonthlyReport()
    }
}