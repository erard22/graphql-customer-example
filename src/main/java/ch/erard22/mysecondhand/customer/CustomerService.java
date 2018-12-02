package ch.erard22.mysecondhand.customer;

import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;
import static org.elasticsearch.index.query.QueryBuilders.queryStringQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import ch.erard22.mysecondhand.customer.repository.CustomerRepository;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    public List<Customer> findAll() {
        return StreamSupport.stream(customerRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }


    public Page<Customer> findWithFilter(String filter, Pageable pageable) {

        final NativeSearchQueryBuilder queryBuilder =
                new NativeSearchQueryBuilder()
                        .withQuery(queryStringQuery(filter))
                        .withSort(SortBuilders.fieldSort("name").order(SortOrder.ASC))
                        .withPageable(pageable)
                        ;

        return customerRepository.search(queryBuilder.build());
    }


    public void add(Customer customer) {
        customerRepository.save(customer);
    }
}
