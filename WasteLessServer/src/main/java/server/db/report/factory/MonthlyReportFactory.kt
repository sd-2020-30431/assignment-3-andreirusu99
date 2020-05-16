package server.db.report.factory

import server.db.report.Report
import server.db.report.entity.MonthlyReport

class MonthlyReportFactory : AbstractReportFactory() {

    override fun getReport(reportType: String): Report {
        return MonthlyReport()
    }
}