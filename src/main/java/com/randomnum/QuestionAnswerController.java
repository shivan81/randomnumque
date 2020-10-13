package com.randomnum;

import java.util.Random;
import java.util.StringTokenizer;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class QuestionAnswerController {
    
    private final Random random = new Random();

    private int generateRandomNumber() {
        return random.nextInt(10) + 1;
    }

    @RequestMapping(value="/", method=RequestMethod.POST, produces="application/json")
    public Question setQuestion() {
        int a = generateRandomNumber();
        int b = generateRandomNumber();
        int c = generateRandomNumber();
        long timestamp = System.currentTimeMillis();
        String question = "Please sum the numbers " + a + ", " + b + ", " + c;
        String answer = Integer.toString(a + b + c);
        return new Question((question + "*" + answer + "*" + timestamp), question);
    }

    @RequestMapping(value="/", method=RequestMethod.GET, produces="application/json")
    public ResponseEntity<String> validateResponse(@RequestParam("responses") String responses, @RequestParam("question") String question,
        @RequestParam("answer") String answer) {
        
        if (responses != null) {
        	String expectedQuestion ="";
        	String expectedAnswer = "";
        	StringTokenizer result = new StringTokenizer(responses, "*");
        	int count = result.countTokens();
        	 for (int i = 0; i <count; i++) {
        		 if(i==0)
        			 expectedQuestion = result.nextToken();
        		 else if(i==1)
        			 expectedAnswer = result.nextToken();
        	 } 
        	 if (expectedQuestion.equals(question) && expectedAnswer.equals(answer)) {
                     return new ResponseEntity<>(JSONObject.quote("Correct Answer"), HttpStatus.OK);
                 }
                  
        	 
        }
        return new ResponseEntity<>(JSONObject.quote("Wrong Answer"), HttpStatus.BAD_REQUEST);
    }
}

