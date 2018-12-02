package ch.erard22.mysecondhand.customer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerResource {

    @Autowired
    public CustomerService service;


    @CrossOrigin(origins = "*")
    @RequestMapping("/customers")
    public Iterable<Customer> search(@RequestParam("filter") String filter, @RequestParam("page") int page, @RequestParam("pageSize") int pageSize) {
        service.add(new Customer("123", "Erard", "Michel", "Länggasse 45", 3360, "Herzogenbuchsee"));
        service.add(new Customer("124", "Erard", "Kristin", "Länggasse 45", 3360, "Herzogenbuchsee"));
        service.add(new Customer("125", "Meier", "Sandra", "Länggasse 12", 3367, "Thörigen"));
        service.add(new Customer("126", "Meyer", "Thomas", "Bernstrasse 14", 3367, "Thörigen"));
        service.add(new Customer("127", "Balmer", "Tamara", "Weyerweg 9", 3362, "Oberönz"));
        return service.findWithFilter(filter, PageRequest.of(page, pageSize));
    }

}
