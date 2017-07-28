package com.example.sample.hibernate.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.sample.hibernate.service.MultiServiceInterface;
import com.example.sample.hibernate.types.CustomerConfigIdentifier;
import com.example.sample.hibernate.types.CustomerHDetails;

@RestController
@RequestMapping(value = "/sampleCustomer/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class SampleRestHibernateServiceController {

    @Autowired
    @Qualifier("MultiServiceImpl")
    private MultiServiceInterface multiService;

    private static final Logger LOG = LoggerFactory.getLogger(SampleRestHibernateServiceController.class);

    @RequestMapping(method = RequestMethod.GET, value = "/manu")
    public String manu() {
        System.out.println("******Mai Hu Manu*******");
        return "Mai hu Manu";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/custDetailsHibernate", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CustomerHDetails> getCustHibnerte(@RequestBody CustomerConfigIdentifier id) {
        LOG.info("starting .........");
        CustomerHDetails response = multiService.queryCustConfigsHibernate(id.getId());
        return new ResponseEntity<CustomerHDetails>(response, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/custAllDetailsHibernate", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<CustomerHDetails>> getAllCustHibnerte(@RequestBody CustomerConfigIdentifier id) {
        LOG.info("starting .........");
        List<CustomerHDetails> response = multiService.queryAllCustConfigsHibernate();
        return new ResponseEntity<List<CustomerHDetails>>(response, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveCustDetailsHibernate", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> saveNewCustomerViaHibnerte(@RequestBody CustomerHDetails customerHDetails) {
        LOG.info("starting .........");
        String response = multiService.saveNewCustomerDetails(customerHDetails);
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateCustDetailsHibernate", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> updateCustomerViaHibnerte(@RequestBody CustomerHDetails customerHDetails) {
        LOG.info("starting .........");
        String response = multiService.updateCustomerById(customerHDetails);
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/deleteCustDetailsHibernate", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteCustomerViaHibnerte(@RequestBody CustomerConfigIdentifier id) {
        LOG.info("starting .........");
        String response = multiService.deleteCustomerById(id.getId());
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

}