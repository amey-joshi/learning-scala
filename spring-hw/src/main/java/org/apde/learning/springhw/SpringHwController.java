package org.apde.learning.springhw;

import org.apde.learning.springhw.model.Greeting;
import org.apde.learning.springhw.model.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SpringHwController {
    @Autowired
    RestTemplate restTemplate;

    public static final String URL = "https://gturnquist-quoters.cfapps.io/api/random";

    @GetMapping("/greet")
    public Greeting greet(@RequestParam(name = "name", defaultValue = "World")String name) {
        return new Greeting(name);
    }

    @GetMapping("/quote")
    public Quote quote() {
        return restTemplate.getForObject(URL, Quote.class);
    }
}
