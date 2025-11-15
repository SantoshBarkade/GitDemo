package com.ai.SpringAiDemo;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class GenAIController {

   private final ChatClient chatClient;

   public GenAIController(ChatClient.Builder builder){
       this.chatClient=builder.build();
   }

//    public GenAIController(ChatService chatService) {
//        this.chatService = chatService;
//    }

//    @GetMapping("/ask-ai")
//    public String getResponse(@RequestParam String prompt){
//        return chatService.getResponse(prompt);
//    }

    @GetMapping("/chat")
    public ResponseEntity<String> chat(@RequestParam(value = "q",required = true) String q){
       var result=chatClient.prompt(q).call().content();
       return ResponseEntity.ok(result);
    }

}
