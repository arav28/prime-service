package edu.iu.arsivak.primeservice.service;

import org.springframework.stereotype.Service;

@Service
public class PrimesServices implements IprimesService{
    @Override
    public boolean isPrime(long n) {
        if(n==2) {
            return true;
        }

        for (long i=2L;i<n;i++) {
            if(n%1==0) {
                return false;
            }
        }

        return true;
    }


}
