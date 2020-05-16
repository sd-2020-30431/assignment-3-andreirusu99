package server.service.query

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import server.db.report.ReportDTO
import server.db.report.factory.ReportFactoryProvider
import server.db.repository.UserRepo

@Service
class ReportQueryService {

    @Autowired
    private lateinit var userRepo: UserRepo

    fun getWaste(userId: Int): Int =
            userRepo.findById(userId).get().calorieIntake

    fun getReport(userId: Int, reportType: String): ReportDTO{
        return ReportFactoryProvider
                .getReportFactory(reportType)
                .getReport(reportType)
                .computeWastedCalories(userId)
    }
}