package org.spring.Post;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="post")
public class PostController {
    @RequestMapping(value="getPosts",method= RequestMethod.GET)
    <T> ResponseEntity<T> getsPost(){
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value="getPost",method= RequestMethod.GET)
    <T> ResponseEntity<T> getPost(String id){
        return null;
    }
    @RequestMapping(value="getUserPostedPost",method= RequestMethod.GET)
    <T>  ResponseEntity<T> getUserPostedPost(String userId){
            return null;
    }
    <T>  ResponseEntity<T>  setPost(@RequestBody Post post){
        return null;
    }
}
