package ch.erard22.mysecondhand.customer.repository;


import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import ch.erard22.mysecondhand.customer.Customer;

public interface CustomerRepository extends ElasticsearchRepository<Customer, String> {


}
