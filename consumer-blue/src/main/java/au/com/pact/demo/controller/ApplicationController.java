package au.com.pact.demo.controller;

import au.com.pact.demo.model.DecisionRequest;
import au.com.pact.demo.model.DecisionResponse;
import au.com.pact.demo.service.DecisionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static au.com.pact.demo.constant.DefaultValues.CONTENT_TYPE;
import static javax.servlet.http.HttpServletResponse.SC_INTERNAL_SERVER_ERROR;

@RestController
@Api(tags = "Application Controller", description = "Operations on Application Controller")
public class ApplicationController {

    @Autowired
    private DecisionService decisionService;

    @GetMapping(value = "/application", produces = CONTENT_TYPE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Check Application", notes = "This is check application endpoint.", produces = CONTENT_TYPE)
    public ResponseEntity<DecisionResponse> checkApplication() {
        DecisionRequest request = new DecisionRequest();

        DecisionResponse decisionResponse = decisionService.processDecision(request);


        return new ResponseEntity<>(decisionResponse, HttpStatus.OK);
    }
}