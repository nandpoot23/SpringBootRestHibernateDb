package com.example.sample.hibernate.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.example.sample.hibernate.types.CustomerHDetails;

@Component("MultiServiceImpl")
public class MultiServiceImpl implements MultiServiceInterface {

    private static org.slf4j.Logger LOG = LoggerFactory.getLogger(MultiServiceImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    private Session session;

    private Transaction transaction;

    @Override
    public CustomerHDetails queryCustConfigsHibernate(int id) {

        CustomerHDetails customerHDetails = null;
        if (id != 0) {
            LOG.debug("MyServiceImpl::queryCustConfigsHibernate  id : " + id);

            if (StringUtils.isEmpty(session) || !session.isOpen()) {
                session = getSession();
            }
            customerHDetails = (CustomerHDetails) session.get(CustomerHDetails.class, id);

        }

        return customerHDetails;

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<CustomerHDetails> queryAllCustConfigsHibernate() {

        List<CustomerHDetails> customerHDetailsList = null;

        if (StringUtils.isEmpty(session) || !session.isOpen()) {
            session = getSession();
        }

        customerHDetailsList = session.createCriteria(CustomerHDetails.class).list();
        return customerHDetailsList;
    }

    @Override
    public String saveNewCustomerDetails(CustomerHDetails cusDetails) {

        if (StringUtils.isEmpty(session) || !session.isOpen()) {
            session = getSession();
        }

        session.save(cusDetails);
        transaction.commit();
        return "Customer is saved";
    }

    @Override
    public String updateCustomerById(CustomerHDetails cusDetails) {

        String response = null;
        if (StringUtils.isEmpty(session) || !session.isOpen()) {
            session = getSession();
        }
        if (cusDetails.getId() > 0) {

            CustomerHDetails emp = (CustomerHDetails) session.get(CustomerHDetails.class, cusDetails.getId());
            if (!StringUtils.isEmpty(emp)) {
                if (!StringUtils.isEmpty(cusDetails.getFirstName())) {
                    emp.setFirstName(cusDetails.getFirstName());
                }

                // we can add more fields here to update

                try {
                    session.update(emp);
                    transaction.commit();
                    response = "Successfully Updated";
                } catch (Exception e) {
                    response = "Exception generated...";
                    e.printStackTrace();
                }
            }
        } else {
            response = "No data exist for the given id";
        }
        return response;

    }

    @Override
    public String deleteCustomerById(int customerId) {

        String response = null;
        if (StringUtils.isEmpty(session) || !session.isOpen()) {
            session = getSession();
        }
        CustomerHDetails customerDetails = (CustomerHDetails) session.get(CustomerHDetails.class, customerId);
        System.out.println(customerDetails);
        session.delete(customerDetails);
        transaction.commit();
        response = "customer deleted.";
        return response;

    }

    private Session getSession() {

        Session session = sessionFactory.getCurrentSession();
        transaction = session.beginTransaction();
        return session;
    }

}
