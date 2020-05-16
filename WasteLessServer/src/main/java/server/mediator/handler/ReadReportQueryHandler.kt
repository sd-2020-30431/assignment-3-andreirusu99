package server.mediator.handler

import org.springframework.beans.factory.annotation.Autowired
import server.db.report.ReportDTO
import server.mediator.Handler
import server.mediator.query.ReadReportQuery
import server.mediator.response.ReadReportQueryResponse
import server.service.query.UserQueryService

class ReadReportQueryHandler
    : Handler<ReadReportQuery, ReadReportQueryResponse> {

    @Autowired
    private lateinit var userQueryService: UserQueryService

    override fun handle(request: ReadReportQuery): ReadReportQueryResponse {

        return ReadReportQueryResponse(ReportDTO(userQueryService.getWaste(request.userId)))
    }
}