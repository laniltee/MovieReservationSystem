package lk.sliit;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * Created by Lanil Marasinghe on 5/19/2017.
 */

@CrossOrigin
@RestController
@RequestMapping(value = "/api/")
public class MobilePaymentService {

    @RequestMapping(value = "payment", method = RequestMethod.POST)
    public PaymentAuth authorizePayment(@RequestBody PaymentRequest pr) {
        PaymentAuth pa = new PaymentAuth();
        pa.setTimeStamp(LocalDateTime.now().toString().replace("T", " ").substring(0, 19));
        pa.setUsername(pr.getUsername());
        pa.setAmount(pr.getAmount());
        pa.setMobileNo(pr.getMobileNo());

        if (MobilePayGatewayApplication.users.containsKey(pr.getUsername())) {
            if (MobilePayGatewayApplication.accounts.containsKey(pr.getMobileNo())) {
                if (MobilePayGatewayApplication.users.get(pr.getUsername()).getPin() == MobilePayGatewayApplication.accounts.get(pr.getMobileNo()).getPin()) {
                    if (MobilePayGatewayApplication.accounts.get(pr.getMobileNo()).getBalance() >= pr.getAmount()) {
                        pa.setStatus(true);
                        pa.setMessage("Your Transaction is Successful");
                    } else {
                        pa.setStatus(false);
                        pa.setMessage("Your Account Balance is Insufficient For This Transaction");
                    }
                } else {
                    pa.setStatus(false);
                    pa.setMessage("You Have Entered An Invalid PIN");
                }
            } else {
                pa.setStatus(false);
                pa.setMessage("You Have Entered An Invalid Mobile Number");
            }
        } else {
            pa.setStatus(false);
            pa.setMessage("You Have Not Registered For Mobile Payment Service");
        }
        return pa;
    }
}
