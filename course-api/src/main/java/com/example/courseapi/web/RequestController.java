package com.example.courseapi.web;


import com.example.courseapi.model.Request;
import com.example.courseapi.service.RequestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RequestController {

    @Autowired
    private RequestsService requestsService;



    @RequestMapping(value = "/requests", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Request> createdPosts(@RequestBody Request requests) {
        Request createdRelations = requestsService.createRequests(requests);
        return Optional.ofNullable(createdRelations)
                .map(u -> ResponseEntity.ok().body(u))
                .orElse(ResponseEntity.notFound().build());
    }


    @RequestMapping(value="/relations",method= RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Request> getRequests()
    {
        return requestsService.getAllRequests();
    }
    @RequestMapping(value="/relations/{id}",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Request getRequestsById(@PathVariable long id)
    {
        return requestsService.getRequestsById(id);
    }



}