package server.db.report.factory

import server.db.model.MonthlyReport
import server.db.report.Report

class MonthlyReportFactory : ReportFactory() {

    override fun getReport(reportType: String): Report {
        return MonthlyReport()
    }
}