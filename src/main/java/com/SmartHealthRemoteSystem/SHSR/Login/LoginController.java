package com.SmartHealthRemoteSystem.SHSR.Login;

import com.SmartHealthRemoteSystem.SHSR.User.Doctor.DoctorRepository;
import com.SmartHealthRemoteSystem.SHSR.User.Patient.PatientRepository;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.ExecutionException;


@RestController
public class LoginController {

    @RequestMapping("/varification")
    public String varification(HttpServletRequest request, HttpServletResponse response) throws InterruptedException, ExecutionException  {
        if(DoctorRepository.getDoctor(request.getParameter("uid"))!= null && DoctorRepository.getDoctor(request.getParameter("pswd")) !=null){
            return "doctorDashBoard.html";
        }else if (PatientRepository.getPatient(request.getParameter("uid")) != null &&  PatientRepository.getPatient(request.getParameter("pswd")) !=null ){
            return "patientDashBoard.html";
        }else {
            return "login.html";
        }
    }
}
