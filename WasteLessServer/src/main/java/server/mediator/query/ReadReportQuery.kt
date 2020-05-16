package server.mediator.query

import server.mediator.Request

class ReadReportQuery constructor(var userId: Int, var reportType: String)
    : Request {
}