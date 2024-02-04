package com.amadeus.FlightSearch.restapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.amadeus.FlightSearch.auth.JwtUtil;
import com.amadeus.FlightSearch.entities.User;
import com.amadeus.FlightSearch.model.request.LoginReq;
import com.amadeus.FlightSearch.model.response.ErrorRes;
import com.amadeus.FlightSearch.model.response.LoginRes;

@Controller
@RequestMapping("/rest/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;


    private JwtUtil jwtUtil;
    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;

    }

    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody LoginReq loginReq)  {

        try {
            Authentication authentication =
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginReq.getUserName(), loginReq.getPassword()));
            String userName = authentication.getName();
            User user = new User(userName,"", true);
            String token = jwtUtil.createToken(user);
            LoginRes loginRes = new LoginRes(userName,token);
            System.out.println(loginRes.getToken());
            return ResponseEntity.ok(loginRes);

        }catch (BadCredentialsException e){
            ErrorRes errorResponse = new ErrorRes(HttpStatus.BAD_REQUEST,"Invalid username or password");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }catch (Exception e){
            ErrorRes errorResponse = new ErrorRes(HttpStatus.BAD_REQUEST, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }
}