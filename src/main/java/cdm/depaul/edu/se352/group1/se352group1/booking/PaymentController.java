package cdm.depaul.edu.se352.group1.se352group1.booking;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;
import java.util.UUID;


@Controller
@RequestMapping("/payments")
public class PaymentController {
    @Autowired
    private PaymentRepository paymentRepository;

    @GetMapping
    public String list(Model model, HttpSession session){
//        ModelAndView mAndV = new ModelAndView("se352group1/payments");
        model.addAttribute("payments",paymentRepository.findAll());

        if(session.getAttribute("payment") == null){
            model.addAttribute("payment",new Payment());
            model.addAttribute("btnAddOrModifyLabel","Add");
        }
        else{
            model.addAttribute("payment",session.getAttribute("payment"));
            model.addAttribute("btnAddOrModifyLabel","Modify");
        }
        return "payments";
    }
    @GetMapping("/view/{id}")
    public String get(@PathVariable("id") Long id,  HttpSession session) {
        session.setAttribute("payment", paymentRepository.findById(id));
        return "redirect:/payments";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model, HttpSession session) {
        paymentRepository.deleteById(id);
        return "redirect:/payments";
    }

    @PostMapping
    public String save(@ModelAttribute Payment payment, Model model, HttpSession session) {
//        Object f = session.getAttribute("currentStudent");
//        f.toString();

//        String n = f.toString();
//        Student student = null;
//        for (Student s : studentList) {
//            if (s.getId().toString().equals(n)) {
//                student = s;
//            }
//        }
        UUID uuid = UUID.randomUUID();
        payment.setTransactionId(uuid.toString());
//        payment.setStudent(student);
        paymentRepository.save(payment);
        model.addAttribute("info", "Payment successful!!");


        return "redirect:/";
    }



}

