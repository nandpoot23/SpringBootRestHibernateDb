package com.example.sample.hibernate.service;

import java.util.List;

import com.example.sample.hibernate.types.CustomerHDetails;

public abstract interface MultiServiceInterface {

    public CustomerHDetails queryCustConfigsHibernate(int customerId);

    public List<CustomerHDetails> queryAllCustConfigsHibernate();

    public String saveNewCustomerDetails(CustomerHDetails cusDetails);

    public String updateCustomerById(CustomerHDetails cusDetails);

    public String deleteCustomerById(int customerId);

}
