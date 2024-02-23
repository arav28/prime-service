package edu.iu.arsivak.primeservice.controller;


import edu.iu.arsivak.primeservice.service.IprimesService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/primes")
public class PrimesController {

    IprimesService iprimesService;

    public PrimesController(IprimesService iprimesService) {
        this.iprimesService = iprimesService;
    }
    @GetMapping("/{n}")
    public boolean isPrime(@PathVariable int n) {
        return iprimesService.isPrime(n);
    }
}
