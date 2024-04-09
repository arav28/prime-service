package edu.iu.arsivak.primeservice.controller;


import edu.iu.arsivak.primeservice.rabbitmq.MQSender;
import edu.iu.arsivak.primeservice.service.IprimesService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/primes")
public class PrimesController {

    IprimesService iprimesService;

    private final MQSender mqsender;

    public PrimesController(IprimesService iprimesService, MQSender mqsender) {
        this.iprimesService = iprimesService;
        this.mqsender =mqsender;
    }
    @GetMapping("/{n}")
    public boolean isPrime(@PathVariable int n) {
        boolean result = iprimesService.isPrime(n);
        Object principal = SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        String username = ((Jwt) principal).getSubject();
        System.out.println(username);
        mqsender.sendMessage(username,n,result);
        return result;
    }
}
