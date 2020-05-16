package server.mediator.handler

import org.springframework.beans.factory.annotation.Autowired
import server.mediator.Handler
import server.mediator.query.ReadReportQuery
import server.mediator.response.ReadReportQueryResponse
import server.service.query.ReportQueryService

class ReadReportQueryHandler
    : Handler<ReadReportQuery, ReadReportQueryResponse> {

    @Autowired
    private lateinit var reportQueryService: ReportQueryService

    override fun handle(request: ReadReportQuery): ReadReportQueryResponse {

        return ReadReportQueryResponse(reportQueryService.getReport(request.userId, request.reportType))
    }
}