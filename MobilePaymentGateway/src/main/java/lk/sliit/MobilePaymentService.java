package lk.sliit;

import org.springframework.web.bind.annotation.*;

/**
 * Created by VMARALA on 5/19/2017.
 */

@CrossOrigin
@RestController
@RequestMapping(value = "/api/")
public class MobilePaymentService {

    @RequestMapping(value = "payment", method = RequestMethod.POST)
    public PaymentAuth authorizePayment(@RequestBody PaymentRequest pr){
        PaymentAuth pa = new PaymentAuth();

        return pa;
    }
}
