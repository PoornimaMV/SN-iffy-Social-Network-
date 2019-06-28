package com.example.courseapi.service;

import com.example.courseapi.model.Relation;
import com.example.courseapi.model.Request;
import com.example.courseapi.repository.RequestsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Properties;

@Service
public class RequestsService {


    @Autowired
    private RequestsRepository requestsRepository;
    public Request createRequests(Request requests) {

        return requestsRepository.save(requests);
    }

    public List<Request> getAllRequests() {

        return (List<Request>) requestsRepository.findAll();
    }

    public Request getRequestsById(long requestId) {

        return  requestsRepository.findById(requestId).orElse(null);
    }
}
