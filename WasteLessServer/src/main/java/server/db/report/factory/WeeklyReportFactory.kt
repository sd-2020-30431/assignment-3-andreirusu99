package server.db.report.factory

import server.db.model.WeeklyReport
import server.db.report.Report

class WeeklyReportFactory : ReportFactory(){
    override fun getReport(reportType: String): Report {
        return WeeklyReport()
    }
}