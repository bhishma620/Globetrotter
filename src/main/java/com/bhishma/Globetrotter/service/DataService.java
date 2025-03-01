package com.bhishma.Globetrotter.service;

import com.bhishma.Globetrotter.entity.Destination;
import com.bhishma.Globetrotter.entity.Request;
import org.springframework.http.ResponseEntity;

public interface DataService {

    ResponseEntity<String> addData(Request destination);
}
