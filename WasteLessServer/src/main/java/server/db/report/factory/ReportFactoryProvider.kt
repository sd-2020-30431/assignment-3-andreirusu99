package server.db.report.factory

class ReportFactoryProvider {
    companion object{
        fun getReportFactory(reportType: String) : ReportFactory{
            if (reportType == "WEEKLY") {
                return WeeklyReportFactory()
            }
            return MonthlyReportFactory()
        }
    }
}