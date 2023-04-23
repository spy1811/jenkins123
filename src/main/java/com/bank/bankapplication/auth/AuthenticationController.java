package com.bank.bankapplication.auth;

import com.bank.bankapplication.entity.Transaction;
import com.bank.bankapplication.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.origin.Origin;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;
    private final TransactionService transactionService;
    @CrossOrigin(origins= {"http://localhost:3000","http://13.59.119.154:8081"})
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
        return  ResponseEntity.ok(service.register(request));

    }


    @CrossOrigin(origins= {"http://localhost:3000","http://13.59.119.154:8081/"})
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        return  ResponseEntity.ok(service.authenticate(request));
    }
    @CrossOrigin(origins= {"http://localhost:3000","http://13.59.119.154:8081/"})
    @PostMapping("/validate")
    public ResponseEntity<String> validateUser(@RequestBody ValidateRequest request){
        return ResponseEntity.ok(service.validateUsert(request));
    }

    @CrossOrigin(origins= {"http://localhost:3000","http://13.59.119.154:8081/"})
    @GetMapping("/getTransaction")
    public List<Transaction> getTransaction(){
        return transactionService.fetAll();
    }

    @CrossOrigin(origins= {"http://localhost:3000","http://13.59.119.154:8081/"})
    @PostMapping("/byDate")
    public List<Transaction> getByDate(@RequestBody DateRequest tdata) throws ParseException {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").parse(tdata.getTdate()));

        return transactionService.findByDate(new SimpleDateFormat("yyyy-MM-dd").parse(tdata.getTdate()));
    }

    @CrossOrigin(origins= {"http://localhost:3000","http://13.59.119.154:8081/"})
    @PostMapping("/byDateBetween")
    public List<Transaction> byDateBetween(@RequestBody DateRequestBetween tdata) throws ParseException {
        return transactionService.findByDataBetween(
                new SimpleDateFormat("yyyy-MM-dd").parse(tdata.getSdate()),
                new SimpleDateFormat("yyyy-MM-dd").parse(tdata.getEdate())
        );
    }

    @CrossOrigin(origins= {"http://localhost:3000","http://13.59.119.154:8081/"})
    @GetMapping("/topRecord")
    public List<Transaction> topRecord() {
        return transactionService.findLast();
    }

    /*@CrossOrigin(origins= {"http://localhost:3000","http://entmcq.voidspy.uk"})
    @PostMapping("/byDateBelow")
    public List<Transaction> getByDateBelow(@RequestBody DateRequest tdata) throws ParseException {
        return transactionService.findByDateBelow(
                new SimpleDateFormat("yyyy-MM-dd").parse(tdata.getTdate())
        );
    }*/
}
