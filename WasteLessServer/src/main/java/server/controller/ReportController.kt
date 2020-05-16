package server.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import server.db.report.ReportDTO
import server.mediator.Mediator
import server.mediator.query.ReadReportQuery
import server.mediator.response.ReadReportQueryResponse

@RestController
@RequestMapping("/wasteless")
class ReportController {

    @Autowired
    private lateinit var mediator: Mediator

    @RequestMapping("/report/{userId}/{type}")
    fun getReport(@PathVariable userId: Int, @PathVariable type: String) : ResponseEntity<ReportDTO>{
        val request = ReadReportQuery(userId, type)
        val handler = mediator.handle<ReadReportQuery, ReadReportQueryResponse>(request)
        val response = handler.handle(request)
        return ResponseEntity.ok(response.report)
    }

}