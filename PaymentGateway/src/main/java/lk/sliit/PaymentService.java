package lk.sliit;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

/**
 * Created by Lanil Marasinghe on 5/18/2017.
 */

@CrossOrigin
@RestController
@RequestMapping(value = "/api/")
public class PaymentService {

    @RequestMapping(value = "/payment", method = RequestMethod.POST)
    public PaymentAuth authorizePayment(@RequestBody PaymentRequest pr, HttpServletResponse response) {


        PaymentAuth pa = new PaymentAuth();
        pa.setUsername(pr.getUsername());
        pa.setAmount(pr.getAmount());
        pa.setCreditCardNo(pr.getCreditCardNo());
        pa.setTimeStamp(LocalDateTime.now().toString().replace("T", " ").substring(0, 19));

        if (PaymentGatewayApplication.customers.containsKey(pr.getUsername()) && PaymentGatewayApplication.cards.containsKey(pr.getCreditCardNo())) {

            AccountHolder authCust = PaymentGatewayApplication.customers.get(pr.getUsername());
            CreditCard reqCard = PaymentGatewayApplication.cards.get(pr.getCreditCardNo());

            if (authCust.getUsername().equals(reqCard.getAccount().getHolder().getUsername())) {
                if (reqCard.addPayment(pr.getAmount())) {
                    pa.setMessage("CREDIT_CARD_PAYMENT_SUCCESFULL");
                    pa.setStatus(true);
                    response.setStatus(HttpServletResponse.SC_ACCEPTED);
                } else {
                    pa.setMessage("CREDIT_CARD_INSUFFICIENT_BALANCE");
                    pa.setStatus(false);
                    //response.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
                }
            } else {
                pa.setMessage("CREDIT_CARD_OWNER_MISMATCH");
                pa.setStatus(false);
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
        } else {
            pa.setMessage("AUTHENTICATION_FAILED_INVALID_USER_OR_CCNO");
            pa.setStatus(false);
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }

        return pa;
    }
}
