package server.db.report.factory

import server.db.report.Report

abstract class AbstractReportFactory {

    abstract fun getReport(reportType: String): Report
}