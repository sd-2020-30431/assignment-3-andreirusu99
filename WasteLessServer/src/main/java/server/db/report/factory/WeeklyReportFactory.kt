package server.db.report.factory

import server.db.report.Report
import server.db.report.entity.WeeklyReport

class WeeklyReportFactory : AbstractReportFactory(){
    override fun getReport(reportType: String): Report {
        return WeeklyReport()
    }
}