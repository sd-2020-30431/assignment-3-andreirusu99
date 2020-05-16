package server.db.report.factory

import server.db.report.Report

abstract class ReportFactory {

    abstract fun getReport(reportType: String): Report
}