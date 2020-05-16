package server.mediator.response

import server.db.report.ReportDTO
import server.mediator.Response

class ReadReportQueryResponse constructor(var report: ReportDTO)
    : Response {
}