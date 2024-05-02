package wanner.pay.api.wannerpayments.persist.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import wanner.pay.api.wannerpayments.persist.document.PaymentLog;

public interface PaymentLogRepository extends ReactiveMongoRepository<PaymentLog,String> {

}
